package my.utem.edu.ftmk.dad.luggageTrackingModule.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 * @author Ole Kacak
 *
 */

@Entity
@Table (name = "shuttletruck")
public class ShuttleTruck {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "TruckID")
	private int truckId;
	
	@Column (name = "OperatorName")
	private String operatorName;
	
	@Column (name = "Location")
	private String location;

	/**
	 * 
	 * @return the id of shuttletruck
	 */
	public int getTruckId() {
		return truckId;
	}

	/**
	 * 
	 * @param truckId
	 * set the  value of id for shuttletruck
	 */
	public void setTruckId(int truckId) {
		this.truckId = truckId;
	}

	/**
	 * 
	 * @return the opereator name for shuttletruck
	 */
	public String getOperatorName() {
		return operatorName;
	}

	/**
	 * 
	 * @param operatorName
	 * set the value of operator name for shuttletruck
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	/**
	 * 
	 * @return the location for shuttletruck
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * 
	 * @param location
	 * set the value of location for shuttletruck
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
}
