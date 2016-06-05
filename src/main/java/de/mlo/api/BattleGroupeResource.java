package de.mlo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.mlo.Repository.BattlegroupeRepository;
import de.mlo.model.Battlegroupe;

@RestController
public class BattleGroupeResource {

	@Autowired
	BattlegroupeRepository battleRepo;
	
	@RequestMapping("/api/battlegroupe")
	public List<Battlegroupe> getAllBattleGroupes() {
		return battleRepo.findAll();
	}
}
