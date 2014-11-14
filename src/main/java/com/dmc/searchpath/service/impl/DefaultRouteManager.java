/**
 * 
 */
package com.dmc.searchpath.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dmc.searchpath.domain.LogisticsNetworkMap;
import com.dmc.searchpath.repository.LogisticsNetworkMapRepository;
import com.dmc.searchpath.service.RouteManager;

/**
 * @author Fabio E. Pavão
 * @since 10/11/2014
 */
@Service
@Transactional
public class DefaultRouteManager implements RouteManager {
	
	private LogisticsNetworkMapRepository lnmRepository;
	
	@Autowired
	public DefaultRouteManager(LogisticsNetworkMapRepository lnmRepository) {
		this.lnmRepository = lnmRepository;
	}
	
	/**
	 * 
	 */
	@Transactional
	public LogisticsNetworkMap addOrUpdate(LogisticsNetworkMap map) {
		return lnmRepository.save(map);
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	@Transactional(readOnly = true)
	public LogisticsNetworkMap get(String name) {
		return lnmRepository.findOne(name);
	}

}
