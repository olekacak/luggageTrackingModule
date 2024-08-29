package my.utem.edu.ftmk.dad.luggageTrackingModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.ShuttleTruck;

/**
 * 
 * @author Ole Kacak
 *
 */

public interface ShuttleTruckRepository 
	extends JpaRepository<ShuttleTruck, Long> {

}
