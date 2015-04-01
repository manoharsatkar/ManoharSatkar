/**
 * 
 */
package com.denver.model;

import java.io.Serializable;

/**
 * Model to hold baggage information.
 * 
 * @author manohar
 *
 */
public class Bag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String bagID;
	/**
	 * 
	 */
	private String origin;
	/**
	 * 
	 */
	private String flightID;
	/**
	 * 
	 */
	private String destination;
	/**
	 * 
	 */
	private String route;

	/**
	 * 
	 * @return destination
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * 
	 * @param destination
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	/**
	 * 
	 * @return bagID
	 */
	public String getBagID() {
		return bagID;
	}
	/**
	 * 
	 * @param bagID
	 */
	public void setBagID(String bagID) {
		this.bagID = bagID;
	}
	/**
	 * 
	 * @return bagID
	 */
	public String getOrigin() {
		return origin;
	}
	/**
	 * 
	 * @param origin
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	/**
	 * 
	 * @return
	 */
	public String getFlightID() {
		return flightID;
	}
	/**
	 * 
	 * @param flightID
	 */
	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}
	/**
	 * 
	 * @return route
	 */
	public String getRoute() {
		return route;
	}
	/**
	 * 
	 * @param route
	 */
	public void setRoute(String route) {
		this.route = route;
	}

}
