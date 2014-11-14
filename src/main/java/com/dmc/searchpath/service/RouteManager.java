/**
 * 
 */
package com.dmc.searchpath.service;

import com.dmc.searchpath.domain.LogisticsNetworkMap;

/**
 * @author Fabio E. Pavão
 * @since 10/11/2014
 */
public interface RouteManager {
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	LogisticsNetworkMap addOrUpdate(LogisticsNetworkMap map);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	LogisticsNetworkMap get(String name);

}
