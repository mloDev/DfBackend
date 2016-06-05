package de.mlo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Battlegroupe {
	
	@Id
	@GeneratedValue
	@Getter
	@Setter
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "battlegrouptype_id")
	@Getter
	@Setter
	private BattleGroupeType battleGroupeType;
	
/*    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "battlegroup_id")
	@Getter
	@Setter
	private List<LightShip> lightShip;
	
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "battlegroup_id")
	@Getter
	@Setter
	private List<MediumShip> mediumShip;
	
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "battlegroup_id")
	@Getter
	@Setter
	private List<HeavyShip> heavyShip;
	
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "battlegroup_id")
	@Getter
	@Setter
	private List<SuperHeavyShip> superHeavyShip;*/

}
