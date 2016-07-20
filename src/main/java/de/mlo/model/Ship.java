package de.mlo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import de.mlo.enums.Faction;
import de.mlo.enums.ShipType;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Ship {
	
	@Id
	@GeneratedValue
	@Getter
	@Setter
	private int id;
	
	@Column
	@Getter
	@Setter
	private String name;

	@Column
	@Getter
	@Setter
	private int scan;
	
	@Column
	@Getter
	@Setter
	private String sig;
	
	@Column
	@Getter
	@Setter
	private int thrust;
	
	@Column
	@Getter
	@Setter
	private int hull;
	
	@Column
	@Getter
	@Setter
	private String a;
	
	@Column
	@Getter
	@Setter
	private int pd;
	
	@Column
	@Getter
	@Setter
	private int gmin;
	
	@Column
	@Getter
	@Setter
	private int gmax;
	
	@Column
	@Getter
	@Setter
	private String t;
	
	@ManyToMany
	@JoinTable(name = "ship_specials")
	@Getter
	@Setter
	private List<Special> specials;
	
	@Enumerated(EnumType.STRING)
	@Column
	@Getter
	@Setter
	private Faction faction;
	
	@Column
	@Getter
	@Setter
	private int pts;
	
	@ManyToMany
	@JoinTable(name = "ship_weapons")
	@Getter
	@Setter
	private List<Weapon> weapons; 
	
	@ManyToMany
	@JoinTable(name = "ship_loads")
	@Getter
	@Setter
	private List<Load> loads; 
	
	@Enumerated(EnumType.STRING)
	@Getter
	@Setter
	private ShipType shipType;
	
	@Column
	@Getter
	@Setter
	private String factionLogoURL;
		
}
