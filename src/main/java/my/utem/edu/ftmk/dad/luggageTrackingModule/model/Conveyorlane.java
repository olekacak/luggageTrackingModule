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
@Table(name= "conveyorlane")
public class Conveyorlane {
	
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name = "ConveyorLaneID")
	private int conveyorLaneId;
	
	@Column (name = "LaneNumber")
	private String laneNumber;

	/**
	 * 
	 * @return the value of conveyorLaneId for Conveyorlane
	 */
	public int getConveyorLaneId() {
		return conveyorLaneId;
	}

	/**
	 * 
	 * @param conveyorLaneId
	 * set the value of conveyorLaneId for Conveyorlane
	 */
	public void setConveyorLaneId(int conveyorLaneId) {
		this.conveyorLaneId = conveyorLaneId;
	}

	/**
	 * 
	 * @return the value of laneNumber for Conveyorlane
	 */
	public String getLaneNumber() {
		return laneNumber;
	}

	/**
	 * 
	 * @param laneNumber
	 * set the value of laneNumber for Conveyorlane
	 */
	public void setLaneNumber(String laneNumber) {
		this.laneNumber = laneNumber;
	}
	
}
