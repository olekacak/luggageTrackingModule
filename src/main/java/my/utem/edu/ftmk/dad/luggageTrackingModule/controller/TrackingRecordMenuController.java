package my.utem.edu.ftmk.dad.luggageTrackingModule.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Trackingrecord;
import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Luggage;
import my.utem.edu.ftmk.dad.luggageTrackingModule.model.CheckPoint;
import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Conveyorlane;
import my.utem.edu.ftmk.dad.luggageTrackingModule.model.ShuttleTruck;
import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Flight;

/**
 * 
 * @author Ole Kacak
 * this is the controller for trackingrecord
 */

@Controller
public class TrackingRecordMenuController {
	
	private String defaultURI = 
			"http://localhost:8080/luggagehandling/api/trackingrecords";
	
	/**
	 * 
	 * @param model
	 * this function for getting list of tracking record
	 */
	@GetMapping("/trackingrecord/list")
	public String getTrackingrecords (Model model)
	{
		// The URI for GET trackingrecord
		String uri = "http://localhost:8080/luggagehandling/api/luggages";
		
		// Get a list luggage from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Luggage[]> response = restTemplate.getForEntity(
				uri, Luggage[].class);
		
		// Parse JSON data to array of object
		Luggage trackingrecords[] = response.getBody();
		
		
		// Parse an array to a list object
		List<Luggage> trackingrecordslist = Arrays.asList(trackingrecords);
		
		// Attach list to model as attribute 
		model.addAttribute("trackingrecords", trackingrecordslist);
		
		
		// returning HTML file
		return "trackingrecords";
		
	}
	
	/**
	 * 
	 * @param trackingRecordId
	 * @param model
	 * this function for display the related data for checkpoint 1
	 */
	@GetMapping("/trackingrecord/cp1/{trackingRecordId}")
	public String getTrackingRecordCp1 (
			@PathVariable int trackingRecordId, Model model)
	{
		
		String title = "Checkpoint 1";
		Trackingrecord trackingrecords1 = new Trackingrecord();

		// This block get an trackingrecord to be updated
		if (trackingRecordId > 0) {

			// Generate new URI and append TrackingRecordID to it
			String uri = defaultURI + "/" + trackingRecordId;

			// Get an order type from the web service
			RestTemplate restTracking = new RestTemplate();
			trackingrecords1 = restTracking.getForObject(
					uri, Trackingrecord.class);

			//Give a new title to the page
			title = "Edit Checkpoint";
		}
		
		/*
		 * 
		 * The uri for get checkpoint unit
		 * List of all checkpoint unit for drop down list menu
		 */
		RestTemplate checkpointREST = new RestTemplate();
		ResponseEntity<CheckPoint[]> responseCheckpoint =
				checkpointREST.getForEntity(
					"http://localhost:8080/luggagehandling/api/checkpoints", 
					CheckPoint[].class);
				
				
		// Parse JSON data to array of object
		CheckPoint checkpointArray[] = responseCheckpoint.getBody();
						
		// Parse an array to a list object
		List<CheckPoint> checkpointList = Arrays.asList(checkpointArray);
		
		/*
		 * 
		 * The uri for get luggage unit
		 * List of all luggage unit for drop down list menu
		 */
		 
		RestTemplate restTemplateluggage = new RestTemplate();
		ResponseEntity<Luggage[]> responseLuggage = 
				restTemplateluggage.getForEntity(
						"http://localhost:8080/luggagehandling/api/luggages", 
						Luggage[].class);
		
		Luggage luggageArray[] = responseLuggage.getBody();	
		
		// Parse an array to a list object
		List<Luggage> luggageList = Arrays.asList(luggageArray);
						
		// Attach value to pass to front end
		model.addAttribute("trackingrecord1", trackingrecords1);
		model.addAttribute("checkpoints", checkpointList);
		model.addAttribute("luggages", luggageList);
		model.addAttribute("pageTitle", title);
		
		return "checkpoint1info";
	}
	
	/**
	 * 
	 * @param trackingrecord
	 * this function for saving the data for checkpoint 1 in the trackingrecord
	 */
	@RequestMapping("/trackingrecord/cp1/save")
	public String inserttrackingrecordcp1 (
			@ModelAttribute Trackingrecord trackingrecord)
	{
		// Create a new RestTemplate
		RestTemplate restTemplatecp1 = new RestTemplate();
		
		// Create request body
		HttpEntity<Trackingrecord> request = 
				new HttpEntity<Trackingrecord>(trackingrecord);
		
		String trackingrecordcp1Response = "";
		
		String uri = defaultURI + "/cp1/save";
		
		if (trackingrecord.getTrackingRecordId() > 0)
		{
			// This block update an new order type and send request as PUT
			restTemplatecp1.put(defaultURI, request, Trackingrecord.class);
		}
		else 
		{
			// This block ass a new passenger and send request as POST
			trackingrecordcp1Response = restTemplatecp1.postForObject(
					uri, request, String.class);
			
		}
		
		System.out.println(trackingrecordcp1Response);
		
		// Redirect to cp2 input
		return "redirect:/trackingrecord/cp2/0";
	}
	
	/**
	 * 
	 * @param trackingRecordId
	 * @param model
	 * this function for display the related data for checkpoint 2
	 */
	@GetMapping("/trackingrecord/cp2/{trackingRecordId}")
	public String getTrackingRecordCp2 (
			@PathVariable int trackingRecordId, Model model)
	{
		
		String title = "Checkpoint 2";
		Trackingrecord trackingrecords2 = new Trackingrecord();

		// This block get an trackingrecord to be updated
		if (trackingRecordId > 0) {

			// Generate new URI and append TrackingRecordID to it
			String uri = defaultURI + "/" + trackingRecordId;

			// Get an order type from the web service
			RestTemplate restTracking = new RestTemplate();
			trackingrecords2 = restTracking.getForObject(
					uri, Trackingrecord.class);

			//Give a new title to the page
			title = "Edit Checkpoint";
		}
		
		/*
		 * 
		 * The uri for get checkpoint 2 unit
		 * List of all checkpoint 2 unit for drop down list menu
		 */
		RestTemplate checkpoint2REST = new RestTemplate();
		ResponseEntity<CheckPoint[]> responseCheckpoint2 =
				checkpoint2REST.getForEntity(
						"http://localhost:8080/luggagehandling/api/checkpoints", 
						CheckPoint[].class);
				
				
		// Parse JSON data to array of object
		CheckPoint checkpointArray[] = responseCheckpoint2.getBody();
						
		// Parse an array to a list object
		List<CheckPoint> checkpointList = Arrays.asList(checkpointArray);
		
		/*
		 * 
		 * The uri for get conveyorlane unit
		 * List of all conveyorlane unit for drop down list menu
		 */
		 
		RestTemplate restTemplateConveyorlane = new RestTemplate();
		ResponseEntity<Conveyorlane[]> responseConveyorlane = 
				restTemplateConveyorlane.getForEntity(
					"http://localhost:8080/luggagehandling/api/conveyorlanes", 
					Conveyorlane[].class);
		
		Conveyorlane conveyorlaneArray[] = responseConveyorlane.getBody();	
		
		// Parse an array to a list object
		List<Conveyorlane> conveyorlaneList = Arrays.asList(conveyorlaneArray);
		
		/*
		 * 
		 * The uri for get luggage unit
		 * List of all luggage unit for drop down list menu
		 */
		 
		RestTemplate restTemplateluggage = new RestTemplate();
		
		ResponseEntity<Luggage[]> responseLuggage = 
				
				restTemplateluggage.getForEntity(
						"http://localhost:8080/luggagehandling/api/luggages", 
						Luggage[].class);
		
		Luggage luggageArray[] = responseLuggage.getBody();	
		
		// Parse an array to a list object
		List<Luggage> luggageList = Arrays.asList(luggageArray);
						
		// Attach value to pass to front end
		model.addAttribute("trackingrecord2", trackingrecords2);
		model.addAttribute("checkpoints", checkpointList);
		model.addAttribute("conveyorlanes", conveyorlaneList);
		model.addAttribute("luggages", luggageList);
		model.addAttribute("pageTitle", title);
		
		return "checkpoint2info";
	}
	
	/**
	 * 
	 * @param trackingrecord
	 * this function for saving the data for checkpoint 2 in the trackingrecord
	 */
	@RequestMapping("/trackingrecord/cp2/save")
	public String inserttrackingrecordcp2 (
			@ModelAttribute Trackingrecord trackingrecord)
	{
		String uri = defaultURI + "/cp2/save";
		
		// Create a new RestTemplate
		RestTemplate restTemplatecp2 = new RestTemplate();
		
		// Create request body
		HttpEntity<Trackingrecord> request = 
				new HttpEntity<Trackingrecord>(trackingrecord);
		
		String trackingrecordcp2Response = "";
		
		if (trackingrecord.getTrackingRecordId() > 0)
		{
			// This block update an new order type and send request as PUT
			restTemplatecp2.put(defaultURI, request, Trackingrecord.class);
		}
		else 
		{
			// This block ass a new passenger and send request as POST
			trackingrecordcp2Response = restTemplatecp2.postForObject(
					uri, request, String.class);
			
		}
		
		System.out.println(trackingrecordcp2Response);
		
		// Redirect to cp2 input
		return "redirect:/trackingrecord/cp3/0";
	}
	
	/**
	 * 
	 * @param trackingRecordId
	 * @param model
	 *  this function for display the related data for checkpoint 3
	 */
	@GetMapping("/trackingrecord/cp3/{trackingRecordId}")
	public String getTrackingRecordCp3 (
			@PathVariable int trackingRecordId, Model model)
	{
		
		String title = "Checkpoint 3";
		Trackingrecord trackingrecords3 = new Trackingrecord();

		// This block get an trackingrecord to be updated
		if (trackingRecordId > 0) {

			// Generate new URI and append TrackingRecordID to it
			String uri = defaultURI + "/" + trackingRecordId;

			// Get an order type from the web service
			RestTemplate restTracking = new RestTemplate();
			trackingrecords3 = restTracking.getForObject(
					uri, Trackingrecord.class);

			//Give a new title to the page
			title = "Edit Checkpoint";
		}
		
		/*
		 * 
		 * The uri for get checkpoint unit
		 * List of all checkpoint unit for drop down list menu
		 */
		RestTemplate checkpoint3REST = new RestTemplate();
		ResponseEntity<CheckPoint[]> responseCheckpoint3 =
				checkpoint3REST.getForEntity(
					"http://localhost:8080/luggagehandling/api/checkpoints", 
					CheckPoint[].class);
				
				
		// Parse JSON data to array of object
		CheckPoint checkpointArray[] = responseCheckpoint3.getBody();
						
		// Parse an array to a list object
		List<CheckPoint> checkpointList = Arrays.asList(checkpointArray);
		
		/*
		 * 
		 * The uri for get shuttletruck unit
		 * List of all shuttletruck unit for drop down list menu
		 */
		 
		RestTemplate restTemplateShuttletruck = new RestTemplate();
		ResponseEntity<ShuttleTruck[]> responseShuttletruck = 
				restTemplateShuttletruck.getForEntity(
					"http://localhost:8080/luggagehandling/api/shuttletrucks", 
					ShuttleTruck[].class);
		
		ShuttleTruck shuttletruckArray[] = responseShuttletruck.getBody();	
		
		// Parse an array to a list object
		List<ShuttleTruck> shuttletruckList = Arrays.asList(shuttletruckArray);
		
		/*
		 * 
		 * The uri for get luggage unit
		 * List of all luggage unit for drop down list menu
		 */
		 
		RestTemplate restTemplateluggage = new RestTemplate();
		
		ResponseEntity<Luggage[]> responseLuggage = 
				
				restTemplateluggage.getForEntity(
						"http://localhost:8080/luggagehandling/api/luggages", 
						Luggage[].class);
		
		Luggage luggageArray[] = responseLuggage.getBody();	
		
		// Parse an array to a list object
		List<Luggage> luggageList = Arrays.asList(luggageArray);
						
		// Attach value to pass to front end
		model.addAttribute("trackingrecord3", trackingrecords3);
		model.addAttribute("checkpoints", checkpointList);
		model.addAttribute("shuttletrucks", shuttletruckList);
		model.addAttribute("luggages", luggageList);
		model.addAttribute("pageTitle", title);
		
		return "checkpoint3info";
	}
	
/**
 * 
 * @param trackingrecord
 * this function for saving the data for checkpoint 3 in the trackingrecord
 */
	@RequestMapping("/trackingrecord/cp3/save")
	public String inserttrackingrecordcp3 (
			@ModelAttribute Trackingrecord trackingrecord)
	{
		String uri = defaultURI + "/cp3/save";
		
		// Create a new RestTemplate
		RestTemplate restTemplatecp3 = new RestTemplate();
		
		// Create request body
		HttpEntity<Trackingrecord> request = 
				new HttpEntity<Trackingrecord>(trackingrecord);
		
		String trackingrecordcp3Response = "";
		
		if (trackingrecord.getTrackingRecordId() > 0)
		{
			// This block update an new order type and send request as PUT
			restTemplatecp3.put(defaultURI, request, Trackingrecord.class);
		}
		else 
		{
			// This block ass a new passenger and send request as POST
			trackingrecordcp3Response = restTemplatecp3.postForObject(
					uri, request, String.class);
			
		}
		
		System.out.println(trackingrecordcp3Response);
		
		// Redirect to cp4 input
		return "redirect:/trackingrecord/cp4/0";
	}
	
	/**
	 * 
	 * @param trackingRecordId
	 * @param model
	 * this function for display the related data for checkpoint 4
	 */
	@GetMapping("/trackingrecord/cp4/{trackingRecordId}")
	public String getTrackingRecordCp4 (
			@PathVariable int trackingRecordId, Model model)
	
	{
		
		String title = "Checkpoint 4";
		Trackingrecord trackingrecords4 = new Trackingrecord();

		// This block get an trackingrecord to be updated
		if (trackingRecordId > 0) {

			// Generate new URI and append TrackingRecordID to it
			String uri = defaultURI + "/" + trackingRecordId;

			// Get an order type from the web service
			RestTemplate restTracking = new RestTemplate();
			trackingrecords4 = restTracking.getForObject(
					uri, Trackingrecord.class);

			//Give a new title to the page
			title = "Edit Checkpoint";
		}
		
		/*
		 * 
		 * The uri for get checkpoint unit
		 * List of all checkpoint unit for drop down list menu
		 */
		RestTemplate checkpoint4REST = new RestTemplate();
		ResponseEntity<CheckPoint[]> responseCheckpoint4 =
				checkpoint4REST.getForEntity(
					"http://localhost:8080/luggagehandling/api/checkpoints", 
					CheckPoint[].class);
				
				
		// Parse JSON data to array of object
		CheckPoint checkpointArray[] = responseCheckpoint4.getBody();
						
		// Parse an array to a list object
		List<CheckPoint> checkpointList = Arrays.asList(checkpointArray);
		
		/*
		 * 
		 * The uri for get flight unit
		 * List of all flight unit for drop down list menu
		 */
		 
		RestTemplate restTemplateFlight = new RestTemplate();
		ResponseEntity<Flight[]> responseFlight = 
				restTemplateFlight.getForEntity(
						"http://localhost:8080/luggagehandling/api/flights", 
						Flight[].class);
		
		Flight flightArray[] = responseFlight.getBody();	
		
		// Parse an array to a list object
		List<Flight> flightList = Arrays.asList(flightArray);
		
		/*
		 * 
		 * The uri for get luggage unit
		 * List of all luggage unit for drop down list menu
		 */
		 
		RestTemplate restTemplateluggage = new RestTemplate();
		
		ResponseEntity<Luggage[]> responseLuggage = 
				
				restTemplateluggage.getForEntity(
						"http://localhost:8080/luggagehandling/api/luggages", 
						Luggage[].class);
		
		Luggage luggageArray[] = responseLuggage.getBody();	
		
		// Parse an array to a list object
		List<Luggage> luggageList = Arrays.asList(luggageArray);
						
		// Attach value to pass to front end
		model.addAttribute("trackingrecord4", trackingrecords4);
		model.addAttribute("checkpoints", checkpointList);
		model.addAttribute("flights", flightList);
		model.addAttribute("luggages", luggageList);
		model.addAttribute("pageTitle", title);
		
		return "checkpoint4info";
	}
	
	/**
	 * 
	 * @param trackingrecord
	 * this function for saving the data for checkpoint 3 in the trackingrecord
	 */
	@RequestMapping("/trackingrecord/cp4/save")
	public String inserttrackingrecordcp4 (
			@ModelAttribute Trackingrecord trackingrecord)
	{
		String uri = defaultURI + "/cp4/save";
		
		// Create a new RestTemplate
		RestTemplate restTemplatecp4 = new RestTemplate();
		
		// Create request body
		HttpEntity<Trackingrecord> request = 
				new HttpEntity<Trackingrecord>(trackingrecord);
		
		String trackingrecordcp4Response = "";
		
		if (trackingrecord.getTrackingRecordId() > 0)
		{
			// This block update an new order type and send request as PUT
			restTemplatecp4.put(defaultURI, request, Trackingrecord.class);
		}
		else 
		{
			// This block ass a new passenger and send request as POST
			trackingrecordcp4Response = restTemplatecp4.postForObject(
					uri, request, String.class);
			
		}
		
		System.out.println(trackingrecordcp4Response);
		
		// Redirect to cp4 input
		return "redirect:/menu/list";
	}
	
	/**
	 * 
	 * @param model
	 * this function for listing the menu
	 */
	@GetMapping("/menu/list")
	public String getMenu (Model model)
	{
	
		return "menu";
		
	}
}