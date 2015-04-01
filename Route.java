/**
 * 
 */
package com.denver.model;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Data Structure / Model to hold optimal route information.
 * @author manohar
 *
 */
public class Route implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private LinkedList<String> optimalPath;
	/**
	 * 
	 */
	private double travelTime ;
	/**
	 * 
	 * @return
	 */
	public double getTravelTime() {
		return travelTime;
	}
	/**
	 * 
	 * @param travelTime
	 */
	public void setTravelTime(double travelTime) {
		this.travelTime = travelTime;
	}
	/**
	 * 
	 * @return
	 */
	public LinkedList<String> getOptimalPath() {
		return optimalPath;
	}
	/**
	 * 
	 * @param optimalPath
	 */
	public void setOptimalPath(LinkedList<String> optimalPath) {
		this.optimalPath = optimalPath;
	}
	
}
