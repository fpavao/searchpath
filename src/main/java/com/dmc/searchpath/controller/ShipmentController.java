/**
 * 
 */
package com.dmc.searchpath.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmc.searchpath.domain.ShipmentData;
import com.dmc.searchpath.domain.ShipmentRequest;
import com.dmc.searchpath.exception.NoMapFoundException;
import com.dmc.searchpath.exception.NoRouteFoundException;
import com.dmc.searchpath.service.ShipmentCalc;

/**
 * @author Fabio E. Pavão
 * @since 10/11/2014
 */
@RestController
@RequestMapping("shipment")
public class ShipmentController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	private ShipmentCalc shipmentCalc;
	
	@Autowired
	public ShipmentController(ShipmentCalc shipmentCalc) {
		this.shipmentCalc = shipmentCalc;
	}
	
	@RequestMapping(value = "/path", consumes = "application/json", 
					produces = "application/json", method = GET)
	public ShipmentData getPath(@RequestBody ShipmentRequest shipmentRequest) {
		
		ShipmentData shipmentData = new ShipmentData();
		
		try {
			shipmentData = shipmentCalc.getShortestPath(shipmentRequest);
			
		} catch (NoMapFoundException | NoRouteFoundException e) {
			logger.error(e.getMessage(), e);
		}
		
		return shipmentData;
	}

}
