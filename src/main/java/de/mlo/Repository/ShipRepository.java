package de.mlo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.enums.Faction;
import de.mlo.model.Ship;

public interface ShipRepository extends JpaRepository<Ship, Integer> {
	
	List<Ship> getByFaction(Faction faction);

}
