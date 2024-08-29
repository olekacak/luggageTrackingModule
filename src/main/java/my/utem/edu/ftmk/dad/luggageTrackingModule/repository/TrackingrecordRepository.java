package my.utem.edu.ftmk.dad.luggageTrackingModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Trackingrecord;

/**
 * 
 * @author Ole Kacak
 *
 */

public interface TrackingrecordRepository 
	extends JpaRepository<Trackingrecord, Long> {

}