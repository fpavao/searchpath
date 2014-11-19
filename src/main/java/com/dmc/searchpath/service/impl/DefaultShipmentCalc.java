/**
 * 
 */
package com.dmc.searchpath.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.psjava.algo.graph.shortestpath.DijkstraAlgorithm;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathResult;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.MutableDirectedWeightedGraph;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.goods.GoodDijkstraAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dmc.searchpath.domain.LogisticsNetworkMap;
import com.dmc.searchpath.domain.Route;
import com.dmc.searchpath.domain.ShipmentData;
import com.dmc.searchpath.domain.ShipmentRequest;
import com.dmc.searchpath.exception.NoMapFoundException;
import com.dmc.searchpath.exception.NoRouteFoundException;
import com.dmc.searchpath.repository.LogisticsNetworkMapRepository;
import com.dmc.searchpath.service.ShipmentCalc;

/**
 * @author Fabio E. Pavão
 * @since 10/11/2014
 */
@Service
@Transactional
public class DefaultShipmentCalc implements ShipmentCalc {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private LogisticsNetworkMapRepository lnmRepository;
	
	@Autowired
	public DefaultShipmentCalc(LogisticsNetworkMapRepository lnmRepository) {
		this.lnmRepository = lnmRepository;
	}
	
	/* (non-Javadoc)
	 * @see com.dmc.searchpath.service.ShipmentCalc#getShortestPath(com.dmc.searchpath.domain.ShipmentRequest)
	 */
	@Override
	public ShipmentData getShortestPath(ShipmentRequest shipmentRequest)
			throws NoMapFoundException, NoRouteFoundException {
		return getShortestPath(shipmentRequest.getMapName(), shipmentRequest.getFrom(), 
				shipmentRequest.getTo(), shipmentRequest.getAutonomy(), shipmentRequest.getFuelValue());
	}

	/**
	 * 
	 */
	public ShipmentData getShortestPath(String mapName, String from, String to,
			Double autonomy, Double fuelValue) throws NoMapFoundException, NoRouteFoundException {
	
		ShipmentData shipmentData = new ShipmentData();
			
		try {
			LogisticsNetworkMap map = lnmRepository.findOne(mapName);
			
			if (map == null)
				throw new NoMapFoundException("Map " + mapName + " not found.");
		
			IntegerNumberSystem NS = IntegerNumberSystem.getInstance();
			
			DijkstraAlgorithm dijkstra = GoodDijkstraAlgorithm.getInstance();
			SingleSourceShortestPathResult<String, Integer, DirectedWeightedEdge<String, Integer>> result = dijkstra
					.calc(getGraph(map), from, NS);
			
			if (!result.isReachable(to))
				throw new NoRouteFoundException("No path between " + to + " and " + from);
			
			shipmentData.setCost((result.getDistance(to) / autonomy) * fuelValue);
			
			Iterable<DirectedWeightedEdge<String, Integer>> path = result.getPath(to);
			
			for (DirectedWeightedEdge<String, Integer> dwe : path) {
				shipmentData.addPlace(dwe.from());
			}
			
			shipmentData.addPlace(to);
			
		} catch (NoMapFoundException e) {
			throw new NoMapFoundException(e);
		} catch (NoRouteFoundException e) {
			throw new NoRouteFoundException(e);
		} catch (RuntimeException e) {
			throw new IllegalArgumentException(e);			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return shipmentData;
	}
	
	private MutableDirectedWeightedGraph<String, Integer> getGraph(LogisticsNetworkMap map) {
		
		MutableDirectedWeightedGraph<String, Integer> graph = MutableDirectedWeightedGraph.create();
		List<String> vertices = new LinkedList<String>(); 
		
		for (Route r : map.getRoutes()) {
			if (!vertices.contains(r.getOrigin()))
				vertices.add(r.getOrigin());
			
			if (!vertices.contains(r.getDestination()))
				vertices.add(r.getDestination());
		}
		
		for (String v : vertices)
			graph.insertVertex(v);
		
		for (Route r : map.getRoutes())
			graph.addEdge(r.getOrigin(), r.getDestination(), r.getDistance().intValue());
		
		return graph;
	}

}
