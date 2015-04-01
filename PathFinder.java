package com.denver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import com.denver.model.Edge;
import com.denver.model.Route;
import com.denver.model.RouteSystem;
/**
 * PathFinder is core class that has responsibility to calcualte the shortest path for given Routing system
 * @author manohar
 *
 */
public class PathFinder {
	/**
	 *  Array to hold weightage by each node.
	 */
	private double distancesWeight[];
	/**
	 *  Set to investigate sorted and unsorted elements.
	 */
	private Set<Integer> settled;
	/**
	 * Set to investigate sorted and unsorted elements.
	 */
	private Set<Integer> unsettled;
	/**
	 * Number of nodes in system
	 */
	private int number_of_nodes;
	/**
	 *  Adjacency Matrix to calculate shortest path based on bidirectional weightage.
	 */
	private int adjacencyMatrix[][];
	/**
	 * predecessors for referring to elements in devised path.
	 */
	private Map<Integer,Integer> predecessors ;
	/**
	 * Route to hold shortest route result.
	 */
	private Route route = new Route();
	/**
	 * Mapping between Node string and index for convenience.
	 */
	private ArrayList<String> nodeMapList ;	
	
	/**
	 * 
	 * @param routeSystem
	 */
	public PathFinder(RouteSystem routeSystem){
		init(routeSystem);		
	}
	/**
	 *  Create Matrix based on given Route System and connections.
	 * @param routeSystem
	 */
	public void  createAdjencencyMatrix(RouteSystem routeSystem){
		init(routeSystem);	
	}
	/**
	 * Initialization of various required data structures.
	 * @param routeSystem
	 */
	private void init(RouteSystem routeSystem) {
		nodeMapList = new ArrayList<String>();
		this.adjacencyMatrix = createAdjencyMatrix(routeSystem);			
		int lenghtOfArray = adjacencyMatrix.length;
		this.number_of_nodes = lenghtOfArray -1 ;
		this.distancesWeight = new double[lenghtOfArray];		
		predecessors = new HashMap<Integer, Integer>();
		settled = new HashSet<Integer>();
		unsettled = new HashSet<Integer>();
	}
	/**
	 * Reset the data vehicles used for calculation.
	 */
	private void reset(){
		settled.clear();
		unsettled.clear();
		predecessors.clear();
	}
    /**
     * Finds optimal path for given source and target node based on weightage.
     * @param sourceNodeParam
     * @param targetNodeParam
     * @return Route
     */
	public Route findOptimalPath(String sourceNodeParam,String targetNodeParam){
		int sourceNode = 1+nodeMapList.indexOf(sourceNodeParam);
		int targetNode = 1+nodeMapList.indexOf(targetNodeParam);
		reset();
        int evaluationNode;
        for (int i = 1; i <= number_of_nodes; i++)
        {
            distancesWeight[i] = Integer.MAX_VALUE;
        }
        unsettled.add(sourceNode);        
        distancesWeight[sourceNode] = 0;
        
        while (!unsettled.isEmpty())
        {   evaluationNode = getNodeWithMinimumDistanceFromUnsettled();      
            unsettled.remove(evaluationNode);
            settled.add(evaluationNode);
            evaluateNeighbours(evaluationNode);
        }
        route.setOptimalPath(getPath(targetNode));
        route.setTravelTime(distancesWeight[targetNode]);   
                      
        return route ;
    }
    /**
     * To get the final path for shorted route.
     * @param tareget
     * @return
     */
	private LinkedList<String> getPath(Integer tareget) {
		LinkedList<String> path = new LinkedList<String>();
		Integer step = tareget ;		
		if(predecessors.get(step) == null){
			return null;
		}
		path.add(nodeMapList.get(step-1));
		while(predecessors.get(step) != null){
			step = predecessors.get(step);
			path.add(nodeMapList.get(step-1));
		}
		Collections.reverse(path);
		return path;
			
	}
 /**
  * Finds Node with minimum distance from unsettled nodes to find out next possible element in shorted path.
  * @return int
  */
	private int getNodeWithMinimumDistanceFromUnsettled() {
		int node = 0;
		double minDistance;
		Iterator<Integer> iterator = unsettled.iterator();
		node = iterator.next();
		minDistance = distancesWeight[node];
		for (int i = 1; i <= distancesWeight.length; i++) {
			if (unsettled.contains(i)) {
				if (distancesWeight[i] <= minDistance) {
					minDistance = distancesWeight[i];
					node = i;
				}
			}
		}
		return node;
	}
	/**
	 * Finds possible neighbors for given node and adds to unsettled collection.
	 * @param evaluationNode
	 * 
	 */
	private void evaluateNeighbours(int evaluationNode) {
		double edgeDistance = -1;
		double newDistance = -1;

		for (int destinationNode = 1; destinationNode <= number_of_nodes; destinationNode++) {
			if (!settled.contains(destinationNode)) {
				if (adjacencyMatrix[evaluationNode][destinationNode] != Integer.MAX_VALUE) {
					edgeDistance = adjacencyMatrix[evaluationNode][destinationNode];
					newDistance = distancesWeight[evaluationNode]+ edgeDistance;
					if (newDistance < distancesWeight[destinationNode]) {
						distancesWeight[destinationNode] = newDistance;
						predecessors.put(destinationNode, evaluationNode);
					}
					unsettled.add(destinationNode);
				}
			}
		}
	}
	/**
	 * Creats adjency matrix based on given route system containing vertices and all valid edges.
	 * @param routeSystem
	 * @return
	 */
	private int [][] createAdjencyMatrix(RouteSystem routeSystem){
	    this.nodeMapList = routeSystem.getVertices();
	    //Prepare adjencyMatrix from Route System 
	    int node_matrix_length = 1+routeSystem.getVertices().size();
	    int N = Integer.MAX_VALUE;	    
	    int [][] adjencyMatrix = new int [node_matrix_length][node_matrix_length];	    
	    
	    ArrayList<Edge> edges = routeSystem.getEdges();
	    for(Edge edge : edges){
	    	int src =  1+ nodeMapList.indexOf(edge.getSource());
			int dest = 1+ nodeMapList.indexOf(edge.getTarget());	    		
			adjencyMatrix[src][dest] = (int)edge.getWeightage();			
			adjencyMatrix[dest][src] = (int)edge.getWeightage();			
	    }        
	    for(int i=0;i< node_matrix_length ;i++ ){
	    	for (int j =0; j<node_matrix_length ;j++){
	    		if(adjencyMatrix[i][j] == 0 && i != j ){
	    			adjencyMatrix[i][j] = N;
	    		}   		
	    	}
	    }		
		return adjencyMatrix;
	}
}
