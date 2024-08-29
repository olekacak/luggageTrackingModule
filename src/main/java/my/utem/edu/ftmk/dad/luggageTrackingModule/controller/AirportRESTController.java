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

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Airport;
import my.utem.edu.ftmk.dad.luggageTrackingModule.repository.AirportRepository;

/**
 * 
 * @author Ole Kacak
 *
 */

@RestController
@RequestMapping("/api/airports")
public class AirportRESTController {
	
	/**
	 * this is declaration for object repository
	 */
	@Autowired
	private AirportRepository airportRepository;
	
	/**
	 * 
	 * @param airportId
	 * this function is for delete data of airport by using airportId
	 */
	@DeleteMapping("{airportId}")
	public ResponseEntity<HttpStatus> deleteAirport(
			@PathVariable long airportId)
	{
		airportRepository.deleteById(airportId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * 
	 * @return the list of Airport record
	 */
	@GetMapping
	public List<Airport> getAirport()
	{
		return airportRepository.findAll();
	}
	
	/**
	 * 
	 * @param airportId
	 * @return Airport data by airportId
	 */
	@GetMapping ("{airportId}")
	public Airport getAirport(@PathVariable long airportId )
	{
		Airport airport = airportRepository.findById(airportId).get();
		
		return airport;
	}
	
	/**
	 * 
	 * @param airport
	 * this function want to create and save the airport data 
	 */
	@PostMapping
	public Airport insertAirport (@RequestBody Airport airport)
	{
		return airportRepository.save(airport);
	}
	
	/**
	 * 
	 * @param airport
	 * this function want to edit and update the Airport data
	 */
	@PutMapping
	public Airport updateAirport (@RequestBody Airport airport)
	{
		return airportRepository.save(airport);
	}

}
