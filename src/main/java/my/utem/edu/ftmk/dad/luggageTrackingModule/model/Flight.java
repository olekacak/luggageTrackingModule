package my.utem.edu.ftmk.dad.luggageTrackingModule.model;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * 
 * @author Ole Kacak
 *
 */

@Entity
@Table (name = "flight")
public class Flight {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name = "FlightID")
	private int flightId;
	
	@Column (name = "FlightName")
	private String name;
	
	@Column (name = "DepartingTime")
	private Time departingTime;
	
	@Column (name = "ArrivingTime")
	private Time arrivingTime;
	
	@Column (name = "DepartingDate")
	private Date departingDate;
	
	@Column (name = "FlightNo")
	private String flightNo;
	
	@ManyToOne
	@JoinColumn (name = "AirportID")
	private Airport airportId;

	/**
	 * 
	 * @return the value of flightId for Flight
	 */
	public int getFlightId() {
		return flightId;
	}

	/**
	 * 
	 * @param flightId
	 * set the value of flightId for Flight
	 */
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	/**
	 * 
	 * @return the value of name for Flight
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 * set the value of name for Flight
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return the value of departingTime for Flight
	 */
	public Time getDepartingTime() {
		return departingTime;
	}

	/**
	 * 
	 * @param departingTime
	 * set the value of departingTime for Flight
	 */
	public void setDepartingTime(Time departingTime) {
		this.departingTime = departingTime;
	}

	/**
	 * 
	 * @return the value of arrivingTime for Flight
	 */
	public Time getArrivingTime() {
		return arrivingTime;
	}

	/**
	 * 
	 * @param arrivingTime
	 * set the value of arrivingTime for Flight
	 */
	public void setArrivingTime(Time arrivingTime) {
		this.arrivingTime = arrivingTime;
	}

	/**
	 * 
	 * @return the value of departingDate for Flight
	 */
	public Date getDepartingDate() {
		return departingDate;
	}

	/**
	 * 
	 * @param departingDate
	 * set the value of departingDate for Flight
	 */
	public void setDepartingDate(Date departingDate) {
		this.departingDate = departingDate;
	}

	/**
	 * 
	 * @return the value of flightNo for Flight
	 */
	public String getFlightNo() {
		return flightNo;
	}

	/**
	 * 
	 * @param flightNo
	 * set the value of flightNo for Flight
	 */
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	/**
	 * 
	 * @return the value of airportId for Flight
	 */
	public Airport getAirportId() {
		return airportId;
	}

	/**
	 * 
	 * @param airportId
	 * set the value of airportId for Flight
	 */
	public void setAirportId(Airport airportId) {
		this.airportId = airportId;
	}

	
	
}
