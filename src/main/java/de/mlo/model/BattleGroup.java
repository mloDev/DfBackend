package de.mlo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class BattleGroup {
	
	@Id
	@GeneratedValue
	@Getter
	@Setter
	private int id;

	@OneToOne
	@JoinColumn(name = "battlegrouptype_id")
	@Getter
	@Setter
	private BattleGroupType battleGroupeType;
	
    @ManyToMany
    @JoinTable(name = "battlegroup_lights")
	@Getter
	@Setter
	private List<Ship> lightShips = new ArrayList<>();
	
    @ManyToMany
    @JoinTable(name = "battlegroup_mediums")
	@Getter
	@Setter
	private List<Ship> mediumShips;
	
    @ManyToMany
    @JoinTable(name = "battlegroup_heavies")
	@Getter
	@Setter
	private List<Ship> heavyShips;
	
    @ManyToMany
    @JoinTable(name = "battlegroup_superHeavies")
	@Getter
	@Setter
	private List<Ship> superHeavyShips;

}
