package de.mlo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.mlo.Repository.ShipRepository;
import de.mlo.enums.Faction;
import de.mlo.model.Ship;

import java.util.List;

@RestController
public class ShipResource {

	@Autowired
	ShipRepository shipRepo;
	
	@RequestMapping("/api/ship")
	public List<Ship> getAllShips() {
		return shipRepo.findAll();
	}
	
	@RequestMapping("/api/shipByFaction/{factionString}")
	public List<Ship> getShipsByFaction(@PathVariable String factionString) {
		Faction faction = Faction.valueOf(factionString);
		return shipRepo.getByFaction(faction);
	}
}