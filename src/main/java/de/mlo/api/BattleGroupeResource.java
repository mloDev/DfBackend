package de.mlo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.mlo.Repository.BattleGroupRepository;
import de.mlo.Repository.BattleGroupTypeRepository;
import de.mlo.model.BattleGroupType;
import de.mlo.model.BattleGroup;

@RestController
public class BattleGroupeResource {

	@Autowired
	BattleGroupRepository battleRepo;
	
	@Autowired
	BattleGroupTypeRepository battleTypeRepo;
	
	@RequestMapping(value =  "/api/battlegroupe", method = RequestMethod.GET)
	public List<BattleGroup> getAllBattleGroupes() {
		return battleRepo.findAll();
	}
	
	@RequestMapping(value =  "/api/battlegroupeType", method = RequestMethod.GET)
	public List<BattleGroupType> getAllBattleGroupTypes() {
		return battleTypeRepo.findAll();
	}
	
	@RequestMapping(value = "/api/battlegroupe", method = RequestMethod.POST) 
	public ResponseEntity<BattleGroup> saveBattleGroupe(@RequestBody BattleGroup battleGroupe) {
		
		if (battleGroupe != null) {
		}
		battleRepo.save(battleGroupe);
		return new ResponseEntity<BattleGroup>(battleGroupe, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/battlegroupe/{id}", method = RequestMethod.PUT) 
	public @ResponseBody ResponseEntity<BattleGroup> updateBattleGroupe(@RequestBody BattleGroup battleGroupe) {
		
		if (battleGroupe != null) {
		}
		battleRepo.saveAndFlush(battleGroupe);
		return new ResponseEntity<BattleGroup>(battleGroupe, HttpStatus.OK);
	}
}

