/**
 * 
 */
package com.denver.model;

/**
 * Model to hold edges /connectors  between vertices or nodes in routing system.
 * It included source , target node and it's weight
 * @author manohar
 *
 */
public class Edge {
  
	/**
	 * 
	 */
	private String source ;
	/**
	 * 
	 */
	private String target ;
	/**
	 * 
	 */
	private double weightage ;
	/**
	 * 
	 * @return
	 */
	public String getSource() {
		return source;
	}
	/**
	 * 
	 * @param source
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * 
	 * @return
	 */
	public String getTarget() {
		return target;
	}
	/**
	 * 
	 * @param target
	 */
	public void setTarget(String target) {
		this.target = target;
	}
	/**
	 * 
	 * @return
	 */
	public double getWeightage() {
		return weightage;
	}
	/**
	 * 
	 * @param weightage
	 */
	public void setWeightage(double weightage) {
		this.weightage = weightage;
	}
}
