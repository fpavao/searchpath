package com.dmc.repository;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.dmc.searchpath.domain.LogisticsNetworkMap;
import com.dmc.searchpath.domain.Route;
import com.dmc.searchpath.repository.LogisticsNetworkMapRepository;

/**
 * @author Fabio E. Pavão
 * @since 12/11/2014
 */
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class LogisticsNetworkMapRepositoryTest {

	@Autowired
	private LogisticsNetworkMapRepository repository;

	@Test
	public void shouldPersistAMapWithRoutes() {
		
		LogisticsNetworkMap expected = new LogisticsNetworkMap("SP").withRoute(new Route("A", "B", new BigDecimal(10.0)));
		expected = repository.save(expected);
		LogisticsNetworkMap actual = repository.findOne(expected.getName());
		Assert.assertNotNull(actual);
		Assert.assertSame(expected.getName(), actual.getName());
	}

}
