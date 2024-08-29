package my.utem.edu.ftmk.dad.luggageTrackingModule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Conveyorlane;
import my.utem.edu.ftmk.dad.luggageTrackingModule.repository.ConveyorlaneRepository;

/**
 * 
 * @author Ole Kacak
 *
 */

@RestController
@RequestMapping("/api/conveyorlanes")
public class ConveyorlaneRESTController {
	
	/**
	 * this is declaration for object repository
	 */
	@Autowired
	private ConveyorlaneRepository conveyorlaneRepository;
	
	/**
	 * 
	 * @param ConveyorlaneID
	 * this function is for delete data of Conveyorlane 
	 * by using ConveyorlaneID 
	 */
	@DeleteMapping("{ConveyorlaneID}")
	public ResponseEntity<HttpStatus> deleteConveyorlane(
			@PathVariable long ConveyorlaneID)
	{
		conveyorlaneRepository.deleteById(ConveyorlaneID);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * 
	 * @return the list of Conveyorlane record
	 */
	@GetMapping
	public List<Conveyorlane> getConveyorlane()
	{
		return conveyorlaneRepository.findAll();
	}
	
	/**
	 * 
	 * @param ConveyorlaneID
	 * @return Conveyorlane data by ConveyorlaneID
	 */
	@GetMapping ("{ConveyorlaneID}")
	public Conveyorlane getConveyorlane(
			@PathVariable long ConveyorlaneID )
	{
		Conveyorlane conveyorlane = conveyorlaneRepository.findById(
				ConveyorlaneID).get();
		
		return conveyorlane;
	}
	
	/**
	 * 
	 * @param conveyorlane
	 * this function want to create and save the Conveyorlane data 
	 */
	@PostMapping
	public Conveyorlane insertConveyorlane (
			@RequestBody Conveyorlane conveyorlane)
	{
		return conveyorlaneRepository.save(conveyorlane);
	}
	
	/**
	 * 
	 * @param conveyorlane
	 * this function want to edit and update the Conveyorlane data 
	 */
	@PutMapping
	public Conveyorlane updateConveyorlane (
			@RequestBody Conveyorlane conveyorlane)
	{
		return conveyorlaneRepository.save(conveyorlane);
	}


}
