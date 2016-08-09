package de.mlo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import de.mlo.model.Fleet;

public interface FleetRepository extends JpaRepository<Fleet, Integer>{
	
	List<Fleet> getByUserId(@Param("userID") String userId);
	
}
