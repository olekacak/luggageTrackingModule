package my.utem.edu.ftmk.dad.luggageTrackingModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import my.utem.edu.ftmk.dad.luggageTrackingModule.model.CheckPoint;

/**
 * 
 * @author Ole Kacak
 *
 */
public interface CheckPointRepository extends JpaRepository<CheckPoint, Long> {
	
	/**
	 * 
	 * @param CpId
	 * this method is to find and return a specific 
	 * checkpoint by using checkPointId from a database table 
	 * using a custom SQL query.
	 */
	@Query(value="SELECT checkPointId from CP "
			+ " where checkPointId = :checkPointId", nativeQuery=true)
	public CheckPoint findCpById (@Param("checkPointId") int checkPointId);

}
