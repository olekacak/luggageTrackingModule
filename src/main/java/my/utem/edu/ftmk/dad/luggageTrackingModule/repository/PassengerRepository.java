package my.utem.edu.ftmk.dad.luggageTrackingModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.Passenger;

/**
 * 
 * @author Ole Kacak
 *
 */

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

	/**
	 * 
	 * @param PassengerIC
	 * this method is to find and return a passenger by using PassengerIC 
	   from a database table.
	 */
	@Query(value="SELECT * from passenger "
			+ " where PassengerIC = :PassengerIC", nativeQuery=true)

	public Passenger findPassengerByIC (
			@Param("PassengerIC") String PassengerIC);
}