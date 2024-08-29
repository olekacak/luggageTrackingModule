package my.utem.edu.ftmk.dad.luggageTrackingModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Flight;

/**
 * 
 * @author Ole Kacak
 *
 */

public interface FlightRepository extends JpaRepository<Flight, Long> {
	
	

}