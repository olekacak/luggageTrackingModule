package my.utem.edu.ftmk.dad.luggageTrackingModule.model;



import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Table (name = "trackingrecord")
public class Trackingrecord {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "TrackingRecordID")
	private int trackingRecordId;
	
	@JsonIgnoreProperties("trackingrecords")
	@ManyToOne
	@JoinColumn (name = "LuggageID")
	private Luggage luggage;
	
	@Column (name = "RecordedBy")
	private String recordedBy;
	
	@ManyToOne
	@JoinColumn (name = "CpID")
	private CheckPoint checkPointId;
	
	@ManyToOne
	@JoinColumn (name = "TruckID")
	private ShuttleTruck truckId;
	
	@ManyToOne
	@JoinColumn (name = "ConveyorlaneID")
	private Conveyorlane conveyorlane;
		
	@Column (name = "DateTime")
	private LocalDateTime DateTime;

	/**
	 * 
	 * @return the trackingRecordId for trackingrecord
	 */
	public int getTrackingRecordId() {
		return trackingRecordId;
	}

	/**
	 * 
	 * @param operatorName
	 * set the value of trackingRecordId for trackingrecord
	 */
	public void setTrackingRecordId(int trackingRecordId) {
		this.trackingRecordId = trackingRecordId;
	}

	/**
	 * 
	 * @return the luggage for trackingrecord
	 */
	public Luggage getLuggage() {
		return luggage;
	}

	/**
	 * 
	 * @param operatorName
	 * set the value of luggage for trackingrecord
	 */
	public void setLuggage(Luggage luggage) {
		this.luggage = luggage;
	}

	/**
	 * 
	 * @return the recordedBy for trackingrecord
	 */
	public String getRecordedBy() {
		return recordedBy;
	}

	/**
	 * 
	 * @param operatorName
	 * set the value of recordedBy for trackingrecord
	 */
	public void setRecordedBy(String recordedBy) {
		this.recordedBy = recordedBy;
	}

	/**
	 * 
	 * @return the checkPointId for trackingrecord
	 */
	public CheckPoint getCheckPointId() {
		return checkPointId;
	}

	/**
	 * 
	 * @param operatorName
	 * set the value of checkPointId for trackingrecord
	 */
	public void setCheckPointId(CheckPoint checkPointId) {
		this.checkPointId = checkPointId;
	}

	/**
	 * 
	 * @param operatorName
	 * set the value of truckId for trackingrecord
	 */
	public ShuttleTruck getTruckId() {
		return truckId;
	}

	/**
	 * 
	 * @param operatorName
	 * set the value of truckId for trackingrecord
	 */
	public void setTruckId(ShuttleTruck truckId) {
		this.truckId = truckId;
	}

	/**
	 * 
	 * @param operatorName
	 * set the value of conveyorlane for trackingrecord
	 */
	public Conveyorlane getConveyorlane() {
		return conveyorlane;
	}

	/**
	 * 
	 * @param operatorName
	 * set the value of conveyorlane for trackingrecord
	 */
	public void setConveyorlane(Conveyorlane conveyorlane) {
		this.conveyorlane = conveyorlane;
	}

	/**
	 * 
	 * @param operatorName
	 * set the value of DateTime for trackingrecord
	 */
	public LocalDateTime getDateTime() {
		return DateTime;
	}

	/**
	 * 
	 * @param operatorName
	 * set the value of DateTime for trackingrecord
	 */
	public void setDateTime(LocalDateTime dateTime) {
		DateTime = dateTime;
	}

}
