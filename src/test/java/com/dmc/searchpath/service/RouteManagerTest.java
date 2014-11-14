/**
 * 
 */
package com.dmc.searchpath.service;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dmc.searchpath.domain.LogisticsNetworkMap;
import com.dmc.searchpath.domain.Route;

/**
 * @author Fabio E. Pavão
 * @since 10/11/2014
 */
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class RouteManagerTest {
	
	@Autowired
	private RouteManager routeManager;

	@Test
	public void shouldPersistAMapWithRoutes() {
		
		LogisticsNetworkMap expected = new LogisticsNetworkMap("SP").withRoute(new Route("A", "B", new BigDecimal(10.0)));
		expected = routeManager.addOrUpdate(expected);
		LogisticsNetworkMap actual = routeManager.get(expected.getName());
		Assert.assertNotNull(actual);
		Assert.assertSame(expected, actual);
	}
	
}
