# ManoharSatkar
Java Module to calculate shortest path for airport baggage handling system. 

Readme.txt

***************************************************************
This system/module is designed and developed by Manohar Satkar
manohar.satkar@yahoo.com

===============================================================================================================

Given Problem :
***************************************************************

Coding problem Airport Baggage - Pathfinding
 
Denver International Airport has decided to give an automated baggage system another shot. The hardware and tracking systems 
from the previous attempt are still in place, they just need a system to route the baggage.  The system will route baggage
checked, connecting, and terminating in Denver.
You have been asked to implement a system that will route bags to their flights or the proper baggage claim.  
The input describes the airport conveyor system, the departing flights, and the bags to be routed.  The output is the optimal
routing to get bags to their destinations. 
Bags with a flight id of “ARRIVAL” are terminating in Denver are routed to Baggage Claim.
Input: The input consists of several sections.  The beginning of each section is marked by a line starting: “# Section:”
Section 1: A weighted bi-directional graph describing the conveyor system.
Format: <Node 1> <Node 2> <travel_time>
Section 2: Departure list
           Format: <flight_id> <flight_gate> <destination> <flight_time>
Section 3: Bag list
           Format: <bag_number> <entry_point> <flight_id>
Output: The optimized route for each bag
<Bag_Number> <point_1> <point_2> [<point_3>, …] : <total_travel_time>
The output should be in the same order as the Bag list section of the input.
 
Example Input:
# Section: Conveyor System
Concourse_A_Ticketing A5 5
A5 BaggageClaim 5
A5 A10 4
A5 A1 6
A1 A2 1
A2 A3 1
A3 A4 1
A10 A9 1
A9 A8 1
A8 A7 1
A7 A6 1
# Section: Departures
UA10 A1 MIA 08:00
UA11 A1 LAX 09:00
UA12 A1 JFK 09:45
UA13 A2 JFK 08:30
UA14 A2 JFK 09:45
UA15 A2 JFK 10:00
UA16 A3 JFK 09:00
UA17 A4 MHT 09:15
UA18 A5 LAX 10:15
# Section: Bags
0001 Concourse_A_Ticketing UA12
0002 A5 UA17
0003 A2 UA10
0004 A8 UA18
0005 A7 ARRIVAL
Example Output:
0001 Concourse_A_Ticketing A5 A1 : 11
0002 A5 A1 A2 A3 A4 : 9
0003 A2 A1 : 1
0004 A8 A9 A10 A5 : 6
0005 A7 A8 A9 A10 A5 BaggageClaim : 12

========================================================================================================================


**************************************
This solution consists of below files:
**************************************
Bag.java
Edge.java
Flight.java
Route.java
RouteSystem.java
PathFinder.java
PathFinderService.java
DestinationNotValidException.java

*******************************
Classes for Testing the module:
*******************************
PathFinderServiceTest.java
InputHelper.java
								 
================================================================================================================
This system used data model for Bag, Flight , Route, Edges, vertices in Conveyor / routing system. The input is
considered as pojo defined.However as the problem indicates if input is in flat text file, that can be read into 
model classes as well.

*******************************
Assumptions :
*******************************

1. No negative weight is considered
2. Exception Handling is considered at bare minimum as representation, however, can be enhanced as required.
3. Data input has been considered and created in terms of model pojo and not from text/XML file where we would read.
   This system can be extended 
   easily to read the data from Text file or XML file and generate text file containing output.
4. Flight Time factor has not been considered and calculation is based on purely weight assigned to edge.
5. If the route has been busy or crowded baggage will not be reversed or re-directed, rather it will follow designed 
   path based on weight of edge in the system. 

=====================================================================================================================
To Test this module:
*******************************
Create one Java project in eclipse.
import these classes as per the packages defined.
Run PathFinderServiceTest.java .
It will print output to console.
If you need to change the input data e.g. Baggage Details , flight details modify InputHelper class for 
respective data in it.
=================================================END=====================================================================

 
