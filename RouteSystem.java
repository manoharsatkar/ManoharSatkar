/**
 * 
 */
package com.denver.model;

import java.util.ArrayList;

/**
 * This model/ data structure to hold all information about connection system.
 * Edges and Vertices/nodes.
 * @author manohar
 *
 */
public class RouteSystem {
	/**
	 * 
	 */
	private String versionID;
	/**
	 * 
	 */
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	
	private ArrayList<String> vertices ;
	
	/**
	 * 
	 * @return ArrayList<Edge>
	 */
	public ArrayList<Edge> getEdges() {
		return edges;
	}
	/**
	 * 
	 * @param edges
	 */
	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getVertices() {
		return vertices;
	}
	/**
	 * 
	 * @param vertices
	 */
	public void setVertices(ArrayList<String> vertices) {
		this.vertices = vertices;
	}
	/**
	 * 
	 * @return
	 */
	public String getVersionID() {
		return versionID;
	}
	/**
	 * 
	 * @param versionID
	 */
	public void setVersionID(String versionID) {
		this.versionID = versionID;
	}	
	

}
