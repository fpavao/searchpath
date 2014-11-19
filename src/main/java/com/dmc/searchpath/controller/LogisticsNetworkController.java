/**
 * 
 */
package com.dmc.searchpath.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmc.searchpath.domain.LogisticsNetworkMap;
import com.dmc.searchpath.repository.LogisticsNetworkMapRepository;

/**
 * @author Fabio E. Pavão
 * @since 10/11/2014
 */
@RestController
@RequestMapping("map")
public class LogisticsNetworkController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private LogisticsNetworkMapRepository lnmRepository;
	
	@Autowired
	public LogisticsNetworkController(LogisticsNetworkMapRepository lnmRepository) {
		this.lnmRepository = lnmRepository;
	}
	
	@RequestMapping(consumes = "application/json", produces = "application/json", method = POST)
	public ResponseEntity<String> create(@RequestBody LogisticsNetworkMap map) {
		
		try {
			lnmRepository.save(map);
		
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@RequestMapping(consumes = "application/json", produces = "application/json", method = PUT)
	public ResponseEntity<String> update(@RequestBody LogisticsNetworkMap map) {
		
		try {
			lnmRepository.save(map);
		
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}

}
