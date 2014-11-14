package com.dmc.searchpath.service;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import com.dmc.searchpath.domain.LogisticsNetworkMap;
import com.dmc.searchpath.domain.Route;
import com.dmc.searchpath.domain.ShipmentData;
import com.dmc.searchpath.exception.NoMapFoundException;
import com.dmc.searchpath.exception.NoRouteFoundException;
import com.dmc.searchpath.repository.LogisticsNetworkMapRepository;

/**
 * 
 * @author Fabio E. Pavão
 * @since 10/11/2014
 */
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ShipmentCalcTest {
	
	@Autowired
	private ShipmentCalc shipmentCalc;
	
	@Autowired
	private LogisticsNetworkMapRepository repository;

	@BeforeTransaction
	public void setUp() {
			
		LogisticsNetworkMap actual = new LogisticsNetworkMap("SP")
			.withRoute(new Route("A", "B", new BigDecimal(10.0)))
			.withRoute(new Route("B", "D", new BigDecimal(15.0)))
			.withRoute(new Route("A", "C", new BigDecimal(20.0)))
			.withRoute(new Route("C", "D", new BigDecimal(50.0)))
			.withRoute(new Route("B", "E", new BigDecimal(30.0)));

		actual = repository.save(actual);
	}
	
	@Test
	public void calculateShortestPathAndReturnShipmentData() throws NoMapFoundException, NoRouteFoundException {
		ShipmentData expected = new ShipmentData(6.25);
		expected.addPlace("A");
		expected.addPlace("B");
		expected.addPlace("D");
		ShipmentData actual = shipmentCalc.getShortestPath("SP", "A", "D", 10.0, 2.50);
		Assert.assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldReturnIllegalArgument() throws NoMapFoundException, NoRouteFoundException {
		shipmentCalc.getShortestPath("SP", "A", "F", 10.0, 2.50);
	}
	
	@Test(expected = NoMapFoundException.class)
	public void shouldReturnMapNotFound() throws NoMapFoundException, NoRouteFoundException {
		shipmentCalc.getShortestPath("BH", "A", "D", 10.0, 2.50);
	}
	
	@Test(expected = NoRouteFoundException.class)
	public void shouldReturnRouteNotFound() throws NoMapFoundException, NoRouteFoundException {
		shipmentCalc.getShortestPath("SP", "B", "C", 10.0, 2.50);
	}

}
