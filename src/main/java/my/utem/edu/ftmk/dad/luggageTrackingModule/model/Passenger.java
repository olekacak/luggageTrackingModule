package my.utem.edu.ftmk.dad.luggageTrackingModule.model;

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
@Table(name = "passenger")
public class Passenger {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "PassengerID")
	private int passengerId;
	
	@Column (name = "Name")
	private String name;
	
	@Column (name = "PhoneNumber")
	private String phoneNumber;
	
	@Column (name = "Email")
	private String email;
	
	@Column (name = "Gender")
	private String gender;
	
	@Column (name = "PassengerIC")
	private String passengerIc;
	
	@ManyToOne
	@JoinColumn (name = "FlightID")
	private Flight flightId;
	
	
	/**
	 * 
	 * @return the passengerId of passenger
	 */
	public int getPassengerId() {
		return passengerId;
	}

	/**
	 * 
	 * @param passengerId
	 * set the  value of passengerId for passenger
	 */
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	/**
	 * 
	 * @return the name of passenger
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 * set the  value of name for passenger
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return the phoneNumber of passenger
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * 
	 * @param phoneNumber
	 * set the  value of phoneNumber for passenger
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * 
	 * @return the email of passenger
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 * set the  value of email for passenger
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return the gender of passenger
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * 
	 * @param gender
	 * set the  value of gender for passenger
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * 
	 * @return the passengerIc of passenger
	 */
	public String getPassengerIc() {
		return passengerIc;
	}

	/**
	 * 
	 * @param passengerIc
	 * set the  value of passengerIc for passenger
	 */
	
	public void setPassengerIc(String passengerIc) {
		this.passengerIc = passengerIc;
	}

	/**
	 * 
	 * @return the flightId of passenger
	 */
	public Flight getFlightId() {
		return flightId;
	}

	/**
	 * 
	 * @param flightId
	 * set the  value of flightId for passenger
	 */
	public void setFlightId(Flight flightId) {
		this.flightId = flightId;
	}
	
}
