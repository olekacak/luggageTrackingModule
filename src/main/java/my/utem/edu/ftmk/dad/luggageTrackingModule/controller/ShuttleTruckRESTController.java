package my.utem.edu.ftmk.dad.luggageTrackingModule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.ShuttleTruck;
import my.utem.edu.ftmk.dad.luggageTrackingModule.repository.ShuttleTruckRepository;

/**
 *  
 * @author Ole Kacak
 *
 */

@RestController
@RequestMapping("/api/shuttletrucks")
public class ShuttleTruckRESTController {
	
	/**
	 * this is declaration for object repository
	 */
	@Autowired
	private ShuttleTruckRepository shuttleTruckRepository;
	
	
	/**
	 * 
	 * @return list of shuttlertruck record
	 */
	@GetMapping
	public List<ShuttleTruck> getShuttletruck()
	{
		return shuttleTruckRepository.findAll();
	}
	
	/**
	 * 
	 * @param TruckID
	 * @return shuttletruck data by truckId
	 */
	@GetMapping ("{truckId}")
	public ShuttleTruck getShuttleTruck(@PathVariable long truckId )
	{
		ShuttleTruck shuttletruck = 
				shuttleTruckRepository.findById(truckId).get();
		
		return shuttletruck;
	}
	
	/**
	 * 
	 * @param shuttletruck
	 * this function want to create and save the shuttletruck data 
	 */
	@PostMapping
	public ShuttleTruck insertShuttletruck (
			@RequestBody ShuttleTruck shuttletruck)
	{
		return shuttleTruckRepository.save(shuttletruck);
	}
	
	/**
	 * 
	 * @param shuttletruck
	 * this function want to edit and update the shuttletruck data 
	 */
	@PutMapping
	public ShuttleTruck updateShuttletruck (
			@RequestBody ShuttleTruck shuttletruck)
	{
		return shuttleTruckRepository.save(shuttletruck);
	}

}
