package my.utem.edu.ftmk.dad.luggageTrackingModule.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * 
 * @author Ole Kacak
 *
 */

@Entity
@Table(name = "luggage")
public class Luggage {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "LuggageID")
	private int luggageId;
		 
	@ManyToOne
	@JoinColumn (name = "passengerID")
	private Passenger passenger; 	
	
	@OneToMany(mappedBy = "luggage",fetch = FetchType.LAZY)
	@JsonIgnoreProperties("luggage")
	private List<Trackingrecord> trackingrecords;
	
	/**
	 * 
	 * @return the value of trackingrecords so that we can 
	 *  access to the tracking records associated with the object or class
	 */
	public List<Trackingrecord> getTrackingrecords() {
		return trackingrecords;
	}
	
	/**
	 * 
	 * @param trackingrecords
	 * set the  value of trackingrecords for luggage
	 */
	public void setTrackingrecords(List<Trackingrecord> trackingrecords) {
		this.trackingrecords = trackingrecords;
	}

	/**
	 * 
	 * @return the value of luggageId for luggage
	 */
	public int getLuggageId() {
		return luggageId;
	}

	/**
	 * 
	 * @param luggageId
	 * set the  value of luggageId for luggage
	 */
	public void setLuggageId(int luggageId) {
		this.luggageId = luggageId;
	}

	/**
	 * 
	 * @return the value of passenger for luggage
	 */
	public Passenger getPassenger() {
		return passenger;
	}

	/**
	 * 
	 * @param passenger
	 * set the  value of passenger for luggage
	 */
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	
}