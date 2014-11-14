package com.dmc.searchpath.domain;

/**
 * 
 * @author Fabio E. Pavão
 * @since 10/11/2014
 */
public class ShipmentRequest {

	private String mapName, from, to;
	private Double autonomy, fuelValue;
	
	/**
	 * 
	 */
	public ShipmentRequest() { }

	/**
	 * @param mapName
	 * @param from
	 * @param to
	 * @param autonomy
	 * @param fuelValue
	 */
	public ShipmentRequest(String mapName, String from, String to,
			Double autonomy, Double fuelValue) {
		this.mapName = mapName;
		this.from = from;
		this.to = to;
		this.autonomy = autonomy;
		this.fuelValue = fuelValue;
	}

	/**
	 * @return the mapName
	 */
	public String getMapName() {
		return mapName;
	}

	/**
	 * @param mapName the mapName to set
	 */
	public void setMapName(String mapName) {
		this.mapName = mapName;
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * @return the autonomy
	 */
	public Double getAutonomy() {
		return autonomy;
	}

	/**
	 * @param autonomy the autonomy to set
	 */
	public void setAutonomy(Double autonomy) {
		this.autonomy = autonomy;
	}

	/**
	 * @return the fuelValue
	 */
	public Double getFuelValue() {
		return fuelValue;
	}

	/**
	 * @param fuelValue the fuelValue to set
	 */
	public void setFuelValue(Double fuelValue) {
		this.fuelValue = fuelValue;
	}
	
	
	
}


