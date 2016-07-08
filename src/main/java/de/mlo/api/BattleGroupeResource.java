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

import de.mlo.Repository.BattleGroupeTypeRepository;
import de.mlo.Repository.BattlegroupeRepository;
import de.mlo.model.BattleGroupeType;
import de.mlo.model.Battlegroupe;

@RestController
public class BattleGroupeResource {

	@Autowired
	BattlegroupeRepository battleRepo;
	
	@Autowired
	BattleGroupeTypeRepository battleTypeRepo;
	
	@RequestMapping(value =  "/api/battlegroupe", method = RequestMethod.GET)
	public List<Battlegroupe> getAllBattleGroupes() {
		return battleRepo.findAll();
	}
	
	@RequestMapping(value =  "/api/battlegroupeType", method = RequestMethod.GET)
	public List<BattleGroupeType> getAllBattleGroupeTypes() {
		return battleTypeRepo.findAll();
	}
	
	@RequestMapping(value = "/api/battlegroupe", method = RequestMethod.POST) 
	public ResponseEntity<Battlegroupe> saveBattleGroupe(@RequestBody Battlegroupe battleGroupe) {
		
		if (battleGroupe != null) {
		}
		battleRepo.save(battleGroupe);
		return new ResponseEntity<Battlegroupe>(battleGroupe, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/battlegroupe/{id}", method = RequestMethod.PUT) 
	public @ResponseBody ResponseEntity<Battlegroupe> updateBattleGroupe(@RequestBody Battlegroupe battleGroupe) {
		
		if (battleGroupe != null) {
		}
		battleRepo.saveAndFlush(battleGroupe);
		return new ResponseEntity<Battlegroupe>(battleGroupe, HttpStatus.OK);
	}
}

