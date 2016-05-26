package de.mlo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.mlo.Repository.GameSizeRepository;
import de.mlo.Repository.LightShipRepository;
import de.mlo.model.GameSize;
import de.mlo.model.LightShip;

import java.util.List;

@RestController
public class LightShipResource {

	@Autowired
	LightShipRepository lightShipRepo;
	
	@RequestMapping("/api/lightShip")
	public List<LightShip> resource() {
		return lightShipRepo.findAll();
	}
}
