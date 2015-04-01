/**
 * 
 */
package com.denver;

import java.util.ArrayList;
import java.util.List;

import com.denver.model.Bag;
import com.denver.model.Flight;
import com.denver.model.Route;
import com.denver.model.RouteSystem;

/**
 * This is service facade to serving the client. It may contain any additional data representation logic.
 * It creates the PathFinder to find out shortest path for given route system.
 * @author manohar
 *
 */
public class PathFinderService {

	private PathFinder pathFinder;

	/**
	 * Create the PathFinderu using route system.
	 * @param routeSystem
	 */
	public void init(RouteSystem routeSystem){
		pathFinder = new PathFinder(routeSystem);
	}
	/**
	 * 
	 * @param baggageLists
	 * @return ArrayList Bags having optimal transition route.
	 * @throws DestinationNotValidException 
	 */
	public ArrayList<Bag> getOptimalRoute(ArrayList<Bag> bagList,ArrayList<Flight> flightList) throws DestinationNotValidException {
		
		for (Bag bag : bagList) {
			for (Flight flight : flightList) {
				if (flight.getFlightID().equals(bag.getFlightID())) {
					bag.setDestination(flight.getTerminal());
				} else if (bag.getFlightID().equals("ARRIVAL")) {
					bag.setDestination("BaggageClaim");
				}
			}
			if(bag.getDestination() == null){
				throw new DestinationNotValidException("Invalid Destination/Flight for Bag: "+bag.getBagID());
			}
			Route route = pathFinder.findOptimalPath(bag.getOrigin(),bag.getDestination());
			List<String> pathElements = route.getOptimalPath();
			StringBuilder path = new StringBuilder();
			for (String i : pathElements) {
				path.append(i);
				path.append(" ");
			}
			path.append(" : " + (int) route.getTravelTime());
			bag.setRoute(path.toString());			
		}
	
		return bagList;
	}

}
