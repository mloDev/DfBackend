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

import de.mlo.Repository.BattleGroupRepository;
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
	BattleGroupRepository battleRepo;

	@RequestMapping(value =  "/api/fleet", method = RequestMethod.GET)
	public List<Fleet> getAllFleets() {
		return fleetRepo.findAll();
	}
	
	@RequestMapping(value = "/api/fleet", method = RequestMethod.POST) 
	public ResponseEntity<Fleet> saveFleet(@RequestBody Fleet fleet) {
		List<BattleGroup> battleGroup = new ArrayList<BattleGroup>();
		battleGroup.addAll(fleet.getLineBattleGroups());
		battleGroup.addAll(fleet.getPathfinderBattleGroups());
		battleGroup.addAll(fleet.getFlagBattleGroups());
		battleGroup.addAll(fleet.getVanguardBattleGroups());
		if ( fleet != null) {
			for ( int i = 0; battleGroup.size() > i; i++ ) {
				battleRepo.save(battleGroup.get(i));
			}
		}
		fleetRepo.save(fleet);
		return new ResponseEntity<Fleet>(fleet, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/fleet/{id}", method = RequestMethod.PUT) 
	public @ResponseBody ResponseEntity<Fleet> updateFleet(@RequestBody Fleet fleet) {
		List<BattleGroup> battleGroup = new ArrayList<BattleGroup>();
		battleGroup.addAll(fleet.getLineBattleGroups());
		battleGroup.addAll(fleet.getPathfinderBattleGroups());
		battleGroup.addAll(fleet.getFlagBattleGroups());
		battleGroup.addAll(fleet.getVanguardBattleGroups());
		if ( fleet != null) {
			for ( int i = 0; battleGroup.size() > i; i++ ) {
				battleRepo.saveAndFlush(battleGroup.get(i));
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
