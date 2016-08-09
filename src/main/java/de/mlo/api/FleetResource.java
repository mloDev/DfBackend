package de.mlo.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.mlo.Repository.BattlegroupeRepository;
import de.mlo.Repository.FleetRepository;
import de.mlo.enums.Faction;
import de.mlo.model.BattleGroup;
import de.mlo.model.Fleet;
import de.mlo.model.Ship;

@RestController
public class FleetResource {

	@Autowired
	FleetRepository fleetRepo;
	
	@Autowired
	BattlegroupeRepository battleRepo;

	@RequestMapping(value =  "/api/fleet", method = RequestMethod.GET)
	public List<Fleet> getAllFleets() {
		return fleetRepo.findAll();
	}
	
	@RequestMapping(value = "/api/fleet", method = RequestMethod.POST) 
	public ResponseEntity<Fleet> saveFleet(@RequestBody Fleet fleet) {
		List<BattleGroup> battleGroupe = new ArrayList<BattleGroup>();
		battleGroupe.addAll(fleet.getLineBattlegroupes());
		battleGroupe.addAll(fleet.getPathfinderBattlegroupes());
		battleGroupe.addAll(fleet.getFlagBattlegroupes());
		battleGroupe.addAll(fleet.getVanguardBattlegroupes());
		if ( fleet != null) {
			for ( int i = 0; battleGroupe.size() > i; i++ ) {
				battleRepo.save(battleGroupe.get(i));
			}
		}
		fleetRepo.save(fleet);
		return new ResponseEntity<Fleet>(fleet, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/fleet/{id}", method = RequestMethod.PUT) 
	public @ResponseBody ResponseEntity<Fleet> updateFleet(@RequestBody Fleet fleet) {
		List<BattleGroup> battleGroupe = new ArrayList<BattleGroup>();
		battleGroupe.addAll(fleet.getLineBattlegroupes());
		battleGroupe.addAll(fleet.getPathfinderBattlegroupes());
		battleGroupe.addAll(fleet.getFlagBattlegroupes());
		battleGroupe.addAll(fleet.getVanguardBattlegroupes());
		if ( fleet != null) {
			for ( int i = 0; battleGroupe.size() > i; i++ ) {
				battleRepo.saveAndFlush(battleGroupe.get(i));
			}
		}
		fleetRepo.saveAndFlush(fleet);
		return new ResponseEntity<Fleet>(fleet, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/api/fleetByUserId/{userId}", method = RequestMethod.GET)
	public List<Fleet> getFleetsByUserId(@PathVariable String userId) {
		return fleetRepo.getByUserId(userId);
	}
}
