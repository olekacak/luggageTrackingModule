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
@Table (name = "checkpoint")
public class CheckPoint {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "cpID")
	private int checkPointId;
	
	@Column (name = "CheckpointName")
	private String name;

	/**
	 * 
	 * @return the value of checkPointId for CheckPoint
	 */
	public int getCheckPointId() {
		return checkPointId;
	}

	/**
	 * 
	 * @param checkPointId
	 * set the value of checkPointId for CheckPoint
	 */
	public void setCheckPointId(int checkPointId) {
		this.checkPointId = checkPointId;
	}

	/**
	 * 
	 * @return the value of name for CheckPoint
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 * set the value of name for CheckPoint
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	
	
	
	

	

	
	


}
