/**
 * 
 */
package com.dmc.searchpath.domain;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.SelectBeforeUpdate;

/**
 * @author Fabio E. Pavão
 * @since 10/11/2014
 */
@Entity
@SelectBeforeUpdate
public class LogisticsNetworkMap implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7059519854944182708L;

	@Id
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Route> routes;

	/**
	 * Default constructor.
	 */
	public LogisticsNetworkMap() { }
	
	/**
	 * @param name
	 * @param locations
	 */
	public LogisticsNetworkMap(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 */
	public LogisticsNetworkMap withRoute(Route route) {
		if (this.routes == null)
			this.routes = new LinkedHashSet<Route>();
		
		this.routes.add(route);
		return this;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the routes
	 */
	public Set<Route> getRoutes() {
		return routes;
	}

	/**
	 * @param routes the routes to set
	 */
	public void setRoutes(Set<Route> routes) {
		this.routes = routes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((routes == null) ? 0 : routes.hashCode());
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
		LogisticsNetworkMap other = (LogisticsNetworkMap) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (routes == null) {
			if (other.routes != null)
				return false;
		} else if (!routes.equals(other.routes))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("name", name)
				.append("routes", routes)
				.toString();
	}
	
}
