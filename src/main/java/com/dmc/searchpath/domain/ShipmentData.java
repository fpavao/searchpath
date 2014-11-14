/**
 * 
 */
package com.dmc.searchpath.domain;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Fabio E. Pavão
 * @since 10/11/2014
 */
public class ShipmentData {
	
	private List<String> places;
	private Double cost;
	
	public ShipmentData() { }

	/**
	 * @param places
	 * @param cost
	 */
	public ShipmentData(List<String> places, Double cost) {
		this.places = places;
		this.cost = cost;
	}

	/**
	 * @param cost
	 */
	public ShipmentData(Double cost) {
		this.cost = cost;
	}

	public void addPlace(String place) {
		if (this.places == null)
			this.places = new LinkedList<String>();
		
		this.places.add(place);
	}
	
	/**
	 * @return the places
	 */
	public List<String> getPlaces() {
		return places;
	}

	/**
	 * @param places the places to set
	 */
	public void setPlaces(List<String> places) {
		this.places = places;
	}

	/**
	 * @return the cost
	 */
	public Double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((places == null) ? 0 : places.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShipmentData other = (ShipmentData) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (places == null) {
			if (other.places != null)
				return false;
		} else if (!places.equals(other.places))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("places", places)
				.append("cost", cost)
				.toString();
	}

	
}
