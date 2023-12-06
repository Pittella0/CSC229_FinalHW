/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc229.csc229_final_hw;
import java.time.LocalDateTime;


/**
 *
 * @author Tony P
 */
public class Plane {
    //set up of plane details
    private String planeID;
    private String destination;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
    private String departurePoint;
    //constructor
    public Plane (String planeID,String destination, LocalDateTime arrivalTime, 
                    LocalDateTime departureTime, String departurePoint ){
        this.planeID = planeID;
        this.destination = destination;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.departurePoint = departurePoint;
    }
    //setters
    public void setPlaneID(String planeID){
        this.planeID = planeID;
    }
    public void setDestination(String destination){
        this.destination = destination;
    }
    public void setArivalTime(LocalDateTime arrivalTime){
        this.arrivalTime = arrivalTime;
    }
    public void setDeparture(LocalDateTime departureTime){
        this.departureTime = departureTime;
    }
    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }
   //getters 
    public String getPlaneID(){
        return planeID;
    }
    public String getDestination(){
        return destination;
    }
    public LocalDateTime getArivalTime(){
        return arrivalTime;
    }
    public LocalDateTime getDeparture(){
        return departureTime;
    }
    public String getDeparturePoint() {
        return departurePoint;
    }
}//end of plane
