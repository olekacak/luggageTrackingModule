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

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Passenger;
import my.utem.edu.ftmk.dad.luggageTrackingModule.repository.PassengerRepository;

/**
 * 
 * @author Ole Kacak
 *
 */

@RestController
@RequestMapping("/api/passengers")
public class PassengerRESTController {
	
	/**
	 * this is declaration for object repository
	 */
	@Autowired
	private PassengerRepository passengerRepository;
	
	/**
	 * this function is for delete data of passenger by using passengerId 
	 */
	@DeleteMapping("{PassengerID}")
	public ResponseEntity<HttpStatus> deletePassenger(
			@PathVariable long PassengerID)
	{
		passengerRepository.deleteById(PassengerID);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * 
	 * @return the list of passenger record
	 */
	@GetMapping
	public List<Passenger> getPassenger()
	{
		return passengerRepository.findAll();
	}
	
	/**
	 * 
	 * @param PassengerID
	 * @return passenger data by PassengerID
	 */
	@GetMapping ("{PassengerID}")
	public Passenger getPassenger(@PathVariable long PassengerID )
	{
		Passenger passenger = 
				passengerRepository.findById(PassengerID).get();
		
		return passenger;
	}
	
	/**
	 * 
	 * @param passenger
	 * this function want to create and save the passenger data 
	 */
	@PostMapping
	public Passenger insertPassenger (@RequestBody Passenger passenger)
	{
		return passengerRepository.save(passenger);
	}
	
	/**
	 * 
	 * @param passenger
	 * this function want to edit and update the passenger data 
	 */
	@PutMapping
	public Passenger updatePassenger (@RequestBody Passenger passenger)
	{
		return passengerRepository.save(passenger);
	}
	
	/**
	 * 
	 * @param PassengerIC
	 * this function want to get list of the passenger by using passengerIc 
	 */
	@GetMapping("/passenger/{PassengerIC}")
	public Passenger findPassengerByIC (@PathVariable String PassengerIC)
	{
		return passengerRepository.findPassengerByIC(PassengerIC);
	}
	

}
