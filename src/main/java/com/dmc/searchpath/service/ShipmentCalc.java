/**
 * 
 */
package com.dmc.searchpath.service;

import com.dmc.searchpath.domain.ShipmentData;
import com.dmc.searchpath.domain.ShipmentRequest;
import com.dmc.searchpath.exception.NoMapFoundException;
import com.dmc.searchpath.exception.NoRouteFoundException;

/**
 * @author Fabio E. Pavão
 * @since 10/11/2014
 */
public interface ShipmentCalc {

	ShipmentData getShortestPath(String mapName, String from, String to,
			Double autonomy, Double fuelValue) throws NoMapFoundException,
			NoRouteFoundException;

	ShipmentData getShortestPath(ShipmentRequest shipmentRequest)
			throws NoMapFoundException, NoRouteFoundException;

}
