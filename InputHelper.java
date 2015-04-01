/**
 * 
 */
package com.denver.test;

import java.util.ArrayList;

import com.denver.model.Bag;
import com.denver.model.Edge;
import com.denver.model.Flight;
import com.denver.model.RouteSystem;

/**
 * This is helper class to generate some test data/model.
 * @author manohar
 *
 */
public class InputHelper {
	/**
	 * 
	 * @return
	 */
	public static RouteSystem getRouteSystem() {
		return createRouteSystem() ;
	}
	/**
	 * 
	 * @return
	 */
	private static RouteSystem createRouteSystem() {
		RouteSystem  routeSystem = new RouteSystem();
		
		ArrayList<String> vertices = new ArrayList<String>();
		vertices.add("A1");
		vertices.add("A2");
		vertices.add("A3");
		vertices.add("A4");
		vertices.add("A5");
		vertices.add("A6");
		vertices.add("A7");
		vertices.add("A8");
		vertices.add("A9");
		vertices.add("A10");
		vertices.add("Concourse_A_Ticketing");
		vertices.add("BaggageClaim");
		
		routeSystem.setVertices(vertices);	
		
		Edge edge1 = new Edge();
		edge1.setSource("Concourse_A_Ticketing");
		edge1.setTarget("A5");
		edge1.setWeightage(5);
		
		Edge edge2 = new Edge();
		edge2.setSource("A5");
		edge2.setTarget("BaggageClaim");
		edge2.setWeightage(5);
						
		Edge edge3 = new Edge();
		edge3.setSource("A5");
		edge3.setTarget("A10");
		edge3.setWeightage(4);
		
		Edge edge4 = new Edge();
		edge4.setSource("A5");
		edge4.setTarget("A1");
		edge4.setWeightage(6);
				
	
				
		Edge edge6 = new Edge();
		edge6.setSource("A1");
		edge6.setTarget("A2");
		edge6.setWeightage(1);
		
		
		Edge edge7 = new Edge();
		edge7.setSource("A2");
		edge7.setTarget("A3");
		edge7.setWeightage(1);
		
		Edge edge8 = new Edge();
		edge8.setSource("A3");
		edge8.setTarget("A4");
		edge8.setWeightage(1);
		
		Edge edge9 = new Edge();
		edge9.setSource("A10");
		edge9.setTarget("A9");
		edge9.setWeightage(1);
		
		Edge edge10 = new Edge();
		edge10.setSource("A9");
		edge10.setTarget("A8");
		edge10.setWeightage(1);
		
		Edge edge11 = new Edge();
		edge11.setSource("A8");
		edge11.setTarget("A7");
		edge11.setWeightage(1);
		
		Edge edge12 = new Edge();
		edge12.setSource("A7");
		edge12.setTarget("A6");
		edge12.setWeightage(1);
		
		routeSystem.getEdges().add(edge1);
		routeSystem.getEdges().add(edge2);
		routeSystem.getEdges().add(edge3);
		routeSystem.getEdges().add(edge4);		
		routeSystem.getEdges().add(edge6);
		routeSystem.getEdges().add(edge7);
		routeSystem.getEdges().add(edge8);
		routeSystem.getEdges().add(edge9);
		routeSystem.getEdges().add(edge10);
		routeSystem.getEdges().add(edge11);
		routeSystem.getEdges().add(edge12);
		
		return routeSystem ;
	}
	/**
	 * Flight List
	 * @return
	 */
	public static ArrayList<Flight> getFlightList() {
		return createFlightList();
	}
	/**
	 * 
	 * @return
	 */
	public static ArrayList<Bag> getBaggaeList(){
		return createBaggaeList();
	}
	/**
	 * 
	 * @return
	 */
	public static ArrayList<Bag> getInvalidBaggaeList(){
		return createInvalidBaggaeList();
	}
	/**
	 * Baggage List
	 * @return
	 */
	private static ArrayList<Bag> createBaggaeList(){
		ArrayList<Bag> bagList = new ArrayList<Bag>();
		
		Bag bag1 = new Bag();
		bag1.setBagID("0001");
		bag1.setOrigin("Concourse_A_Ticketing");
		bag1.setFlightID("UA12");
		
		Bag bag2 = new Bag();
		bag2.setBagID("0002");
		bag2.setOrigin("A5");
		bag2.setFlightID("UA17");

		Bag bag3 = new Bag();
		bag3.setBagID("0003");
		bag3.setOrigin("A2");
		bag3.setFlightID("UA10");

		Bag bag4 = new Bag();
		bag4.setBagID("0004");
		bag4.setOrigin("A8");
		bag4.setFlightID("UA18");
		

		Bag bag5 = new Bag();
		bag5.setBagID("0005");
		bag5.setOrigin("A7");
		bag5.setFlightID("ARRIVAL");
		
		bagList.add(bag1);
		bagList.add(bag2);
		bagList.add(bag3);
		bagList.add(bag4);
		bagList.add(bag5);
		
		return bagList ;
	}
	/**
	 *  Invalid baggage List to test one negative scenario.
	 * @return
	 */
	private static ArrayList<Bag> createInvalidBaggaeList(){
		ArrayList<Bag> bagList = new ArrayList<Bag>();
		
		Bag bag1 = new Bag();
		bag1.setBagID("0001");
		bag1.setOrigin("Concourse_A_Ticketing");
		bag1.setFlightID("InvalidFlight");
		
		Bag bag2 = new Bag();
		bag2.setBagID("0002");
		bag2.setOrigin("A6");
		bag2.setFlightID("UA17");

		Bag bag3 = new Bag();
		bag3.setBagID("0003");
		bag3.setOrigin("A2");
		bag3.setFlightID("UA10");

		Bag bag4 = new Bag();
		bag4.setBagID("0004");
		bag4.setOrigin("A8");
		bag4.setFlightID("UA18");
		

		Bag bag5 = new Bag();
		bag5.setBagID("0005");
		bag5.setOrigin("A7");
		bag5.setFlightID("ARRIVAL");
		
		bagList.add(bag1);
		bagList.add(bag2);
		bagList.add(bag3);
		bagList.add(bag4);
		bagList.add(bag5);
		
		return bagList ;
	}
	/**
	 * Flight list
	 * @return
	 */
	private static ArrayList<Flight> createFlightList(){
		ArrayList<Flight> flightList = new ArrayList<Flight>();
		
		Flight flight1 = new Flight();
		flight1.setFlightID("UA10");
		flight1.setTerminal("A1");
		flight1.setDestination("MIA");
		flight1.setScheduledTime("08:00");
		
		Flight flight2 = new Flight();
		flight2.setFlightID("UA11");
		flight2.setTerminal("A1");
		flight2.setDestination("LAX");
		flight2.setScheduledTime("09:00");
		
		Flight flight3 = new Flight();
		flight3.setFlightID("UA12");
		flight3.setTerminal("A1");
		flight3.setDestination("JFK");
		flight3.setScheduledTime("09:45");
		
		Flight flight4 = new Flight();
		flight4.setFlightID("UA13");
		flight4.setTerminal("A2");
		flight4.setDestination("JFK");
		flight4.setScheduledTime("10:00");
		
		Flight flight5 = new Flight();
		flight5.setFlightID("UA14");
		flight5.setTerminal("A2");
		flight5.setDestination("JFK");
		flight5.setScheduledTime("09:00");
		
		Flight flight6 = new Flight();
		flight6.setFlightID("UA15");
		flight6.setTerminal("A2");
		flight6.setDestination("JFK");
		flight6.setScheduledTime("10:00");
		
		Flight flight7 = new Flight();
		flight7.setFlightID("UA16");
		flight7.setTerminal("A");
		flight7.setDestination("JFK");
		flight7.setScheduledTime("09:00");
		
		Flight flight8 = new Flight();
		flight8.setFlightID("UA17");
		flight8.setTerminal("A4");
		flight8.setDestination("MHT");
		flight8.setScheduledTime("09:15");
		
		Flight flight9 = new Flight();
		flight9.setFlightID("UA18");
		flight9.setTerminal("A5");
		flight9.setDestination("LAX");
		flight9.setScheduledTime("10:15");
		
			
		flightList.add(flight1);
		flightList.add(flight2);
		flightList.add(flight3);
		flightList.add(flight4);
		flightList.add(flight5);
		flightList.add(flight6);
		flightList.add(flight7);
		flightList.add(flight8);
		flightList.add(flight9);
				
		return flightList ;
	}
	
	
	
	
	
}
