/**
 * 
 */
package com.denver.model;

import java.io.Serializable;

/**
 * @author manohar
 *
 */
public class Flight implements Serializable{
	

private static final long serialVersionUID = 1L;
private String flightID ;
private String terminal ;
private String destination ;
private String scheduledTime ;

public String getFlightID() {
	return flightID;
}
public void setFlightID(String flightID) {
	this.flightID = flightID;
}
public String getTerminal() {
	return terminal;
}
public void setTerminal(String terminal) {
	this.terminal = terminal;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public String getScheduledTime() {
	return scheduledTime;
}
public void setScheduledTime(String scheduledTime) {
	this.scheduledTime = scheduledTime;
}


}
