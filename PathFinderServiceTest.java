package com.denver.test;

import java.util.ArrayList;

import com.denver.DestinationNotValidException;
import com.denver.PathFinderService;
import com.denver.model.Bag;

/**
 * This is stand alone class to demonstrate usage of the framework/module Tests
 * the system using InputHelper.
 * 
 * @author manohar
 *
 */
public class PathFinderServiceTest {
	/**
	 * 
	 * It creates input data of BaggageList, FlightList and Routing System.
	 * Input Case considered : 
	 * 0001 Concourse_A_Ticketing UA12
	 * 0002 A5 UA17
	 * 0003 A2 UA10
	 * 0004 A8 UA18
	 * 0005 A7 ARRIVAL
	 *  
	 * @param arg
	 */
	public static void main(String... arg) {

		PathFinderService pathFinderService = new PathFinderService();
		pathFinderService.init(InputHelper.getRouteSystem());
		ArrayList<Bag> bagWithRoutes = null;
		try {
			bagWithRoutes = pathFinderService.getOptimalRoute(
					InputHelper.getBaggaeList(), InputHelper.getFlightList());
			// bagWithRoutes =
			// pathFinderService.getOptimalRoute(InputHelper.getInvalidBaggaeList(),InputHelper.getFlightList());
			if (bagWithRoutes != null) {
				System.out.println("Shortest Path:");
				for (Bag bag : bagWithRoutes) {
					System.out.println(bag.getBagID() + " " + bag.getRoute());
				}
			}			
		} catch (DestinationNotValidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
