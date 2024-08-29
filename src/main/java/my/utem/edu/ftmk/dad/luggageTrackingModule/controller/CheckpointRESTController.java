package my.utem.edu.ftmk.dad.luggageTrackingModule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.CheckPoint;
import my.utem.edu.ftmk.dad.luggageTrackingModule.repository.CheckPointRepository;

/**
 * 
 * @author Ole Kacak
 *
 */

@RestController
@RequestMapping("/api/checkpoints")
public class CheckpointRESTController {
	
	/**
	 * this is declaration for object repository
	 */
	@Autowired
	private CheckPointRepository checkpointRepository;
	
	/**
	 * 
	 * @return the list of CheckPoint record
	 */
	@GetMapping
	public List<CheckPoint> getCheckpoint()
	{
		return checkpointRepository.findAll();
	}
	
	/**
	 * 
	 * @param checkPointId
	 * @return CheckPoint data by checkPointId
	 */
	@GetMapping ("{checkPointId}")
	public CheckPoint getCheckpointId(
			@PathVariable long checkPointId )
	{
		CheckPoint checkpoint = 
				checkpointRepository.findById(checkPointId).get();
		
		return checkpoint;
	}
	
}
