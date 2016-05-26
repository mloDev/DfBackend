package de.mlo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.mlo.Repository.GameSizeRepository;
import de.mlo.model.GameSize;

import java.util.List;

@RestController
public class GameSizeResource {

	@Autowired
	GameSizeRepository gameSizeRepo;
	
	@RequestMapping("/api/gamesize")
	public List<GameSize> resource() {
		return gameSizeRepo.findAll();
	}
}