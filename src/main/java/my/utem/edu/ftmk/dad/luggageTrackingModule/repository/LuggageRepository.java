package my.utem.edu.ftmk.dad.luggageTrackingModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Luggage;

/**
 * 
 * @author Ole Kacak
 *
 */

@Repository
public interface LuggageRepository extends JpaRepository<Luggage, Long> {
	


}
