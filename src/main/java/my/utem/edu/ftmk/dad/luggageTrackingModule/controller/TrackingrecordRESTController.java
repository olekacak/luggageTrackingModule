package my.utem.edu.ftmk.dad.luggageTrackingModule.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Conveyorlane;
import my.utem.edu.ftmk.dad.luggageTrackingModule.model.ShuttleTruck;
import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Trackingrecord;
import my.utem.edu.ftmk.dad.luggageTrackingModule.model.CheckPoint;
import my.utem.edu.ftmk.dad.luggageTrackingModule.
repository.TrackingrecordRepository;

/**
 * 
 * @author Ole Kacak
 *
 */

@RestController
@RequestMapping("/api/trackingrecords")
public class TrackingrecordRESTController {

	/**
	 * this is declaration for object repository
	 */
	@Autowired
	private TrackingrecordRepository trackingrecordRepository;

	/**
	 * 
	 * @return list of tracking record
	 */
	@GetMapping
	public List<Trackingrecord> getTrackingrecord()
	{
		return trackingrecordRepository.findAll();
	}

	/**
	 * 
	 * @param trackingRecordId
	 * @return trackingrecord data by id
	 */
	@GetMapping ("{trackingRecordId}")
	public Trackingrecord getTrackingrecord(
			@PathVariable long trackingRecordId )
	{
		Trackingrecord trackingrecord = trackingrecordRepository.findById(
				trackingRecordId).get();

		return trackingrecord;
	}

	/**
	 * 
	 * @param trackingrecord
	 * this function want to save trackingrecord data for checkpoint 1
	 */
	@PostMapping ("cp1/save")
	public Trackingrecord inserttrackingrecord (
			@RequestBody Trackingrecord trackingrecord)
	{
		// this is to create object for Date and Time
		LocalDateTime DateTime = LocalDateTime.now();

		// this is to set value for DateTime
		trackingrecord.setDateTime(DateTime);

		// this is to create object for checkpoint 1
		CheckPoint checkPoint = new CheckPoint();

		// this is to set value for checkpoint 1
		checkPoint.setCheckPointId(1);
		trackingrecord.setCheckPointId(checkPoint);

		// this is to set value for recordedBy
		trackingrecord.setRecordedBy("staff");

		// this is to create object for conveyorlane
		Conveyorlane conveyorlane = new Conveyorlane();

		// this is to set value for conveyorlane
		conveyorlane.setConveyorLaneId(9999);
		trackingrecord.setConveyorlane(conveyorlane);

		// this is to create object for shuttletruck
		ShuttleTruck shuttletruck = new ShuttleTruck();

		// this is to set value for shuttletruck 
		shuttletruck.setTruckId(9999);
		trackingrecord.setTruckId(shuttletruck);

		return trackingrecordRepository.save(trackingrecord);
	}

	/**
	 * 
	 * @param trackingrecord
	 * this function want to save trackingrecord data for checkpoint 2
	 */
	@PostMapping ("cp2/save")
	public Trackingrecord inserttrackingrecord2 (
			@RequestBody Trackingrecord trackingrecord)
	{
		// this is to create object for Date and Time
		LocalDateTime DateTime = LocalDateTime.now();

		// this is to set value for DateTime
		trackingrecord.setDateTime(DateTime);

		// this is to create object for checkpoint 2
		CheckPoint checkPoint = new CheckPoint();

		// this is to set value for checkpoint 2
		checkPoint.setCheckPointId(2);
		trackingrecord.setCheckPointId(checkPoint);

		// this is to set value for recordedBy
		trackingrecord.setRecordedBy("staff");

		// this is to create object for conveyorlane
		Conveyorlane conveyorlane = new Conveyorlane();

		// this is to set value for conveyorlane
		conveyorlane.setConveyorLaneId(9999);
		trackingrecord.setConveyorlane(conveyorlane);

		// this is to create object for shuttletruck
		ShuttleTruck shuttletruck = new ShuttleTruck();

		// this is to set value for shuttletruck 
		shuttletruck.setTruckId(9999);
		trackingrecord.setTruckId(shuttletruck);

		return trackingrecordRepository.save(trackingrecord);
	}

	/**
	 * 
	 * @param trackingrecord
	 * this function want to save trackingrecord data for checkpoint 3
	 */
	@PostMapping ("cp3/save")
	public Trackingrecord inserttrackingrecord3 (
			@RequestBody Trackingrecord trackingrecord)
	{
		// this is to create object for Date and Time
		LocalDateTime DateTime = LocalDateTime.now();

		// this is to set value for DateTime
		trackingrecord.setDateTime(DateTime);

		// this is to create object for checkpoint 3
		CheckPoint checkPoint = new CheckPoint();

		// this is to set value for checkpoint 2
		checkPoint.setCheckPointId(3);
		trackingrecord.setCheckPointId(checkPoint);

		// this is to set value for recordedBy
		trackingrecord.setRecordedBy("staff");

		// this is to create object for conveyorlane
		Conveyorlane conveyorlane = new Conveyorlane();

		// this is to set value for conveyorlane
		conveyorlane.setConveyorLaneId(9999);
		trackingrecord.setConveyorlane(conveyorlane);

		// this is to create object for shuttletruck
		ShuttleTruck shuttletruck = new ShuttleTruck();

		// this is to set value for shuttletruck 
		shuttletruck.setTruckId(9999);
		trackingrecord.setTruckId(shuttletruck);


		return trackingrecordRepository.save(trackingrecord);
	}

	/**
	 * 
	 * @param trackingrecord
	 * this function want to save trackingrecord data for checkpoint 4
	 */
	@PostMapping ("cp4/save")
	public Trackingrecord inserttrackingrecord4 (
			@RequestBody Trackingrecord trackingrecord)
	{
		// this is to create object for Date and Time
		LocalDateTime DateTime = LocalDateTime.now();

		// this is to set value for DateTime
		trackingrecord.setDateTime(DateTime);

		// this is to create object for checkpoint 4
		CheckPoint checkPoint = new CheckPoint();

		// this is to set value for checkpoint 4
		checkPoint.setCheckPointId(4);
		trackingrecord.setCheckPointId(checkPoint);

		// this is to set value for recordedBy
		trackingrecord.setRecordedBy("staff");

		// this is to create object for conveyorlane
		Conveyorlane conveyorlane = new Conveyorlane();

		// this is to set value for conveyorlane
		conveyorlane.setConveyorLaneId(9999);
		trackingrecord.setConveyorlane(conveyorlane);

		// this is to create object for shuttletruck
		ShuttleTruck shuttletruck = new ShuttleTruck();

		// this is to set value for shuttletruck 
		shuttletruck.setTruckId(9999);
		trackingrecord.setTruckId(shuttletruck);

		return trackingrecordRepository.save(trackingrecord);
	}

}
