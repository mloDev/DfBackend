package de.mlo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import de.mlo.enums.Faction;
import lombok.Getter;
import lombok.Setter;
@Entity
public class Fleet {

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
	private int totalPoints;
	
	@Column
	@Getter
	@Setter
	private int maxPoints;
	
	@Column
	@Getter
	@Setter
	private String userId;
	
	@Enumerated(EnumType.STRING)
	@Column
	@Getter
	@Setter
	private Faction faction;
	
	@OneToOne
	@JoinColumn(name = "fleet_gameSize" )
	@Getter
	@Setter
	private GameSize gameSize;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@Getter
	@Setter
	private List<BattleGroup> flagBattlegroupes;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@Getter
	@Setter
	private List<BattleGroup> vanguardBattlegroupes;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@Getter
	@Setter
	private List<BattleGroup> lineBattlegroupes;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@Getter
	@Setter
	private List<BattleGroup> pathfinderBattlegroupes;

	
}
