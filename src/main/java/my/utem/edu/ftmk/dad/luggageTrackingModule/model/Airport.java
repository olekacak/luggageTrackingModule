package my.utem.edu.ftmk.dad.luggageTrackingModule.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author MONALIZA
 *
 */


@Entity
@Table (name = "airport")
public class Airport {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "AirportID")
	private int airportId;
	
	
	@Column (name = "DepartingAirport")
	private String departingAirport;
	
	@Column (name = "ArrivalAirport")
	private String arrivalAirport;

	/**
	 * 
	 * @return the value of airportId for Airport
	 */
	public int getAirportId() {
		return airportId;
	}

	/**
	 * 
	 * @param airportId
	 * set the value of airportId for Airport
	 */
	public void setAirportId(int airportId) {
		this.airportId = airportId;
	}

	/**
	 * 
	 * @return the value of departingAirport for Airport
	 */
	public String getDepartingAirport() {
		return departingAirport;
	}

	/**
	 * 
	 * @param departingAirport
	 * set the value of departingAirport for Airport
	 */
	public void setDepartingAirport(String departingAirport) {
		this.departingAirport = departingAirport;
	}

	/**
	 * 
	 * @return the value of arrivalAirport for Airport
	 */
	public String getArrivalAirport() {
		return arrivalAirport;
	}

	/**
	 * 
	 * @param arrivalAirport
	 * set the value of arrivalAirport for Airport
	 */
	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	

	
	
	
	
	

	
	

}
