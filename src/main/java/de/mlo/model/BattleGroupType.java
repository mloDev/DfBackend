package de.mlo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import de.mlo.enums.BattleType;
import lombok.Getter;
import lombok.Setter;

@Entity
public class BattleGroupType {
	
	@Id
	@GeneratedValue
	@Getter
	@Setter
	private int id;
	
	@Enumerated(EnumType.STRING)
	@Column
	@Getter
	@Setter
	private BattleType battleType;
	
	@Column
	@Getter
	@Setter
	private int maxShips;
	
	@Column
	@Getter
	@Setter
	int lightShipSize;
	
	@Column
	@Getter
	@Setter
	int mediumShipSize;
	
	@Column
	@Getter
	@Setter
	int heavyShipSize;
	
	@Column
	@Getter
	@Setter
	int superHeavyShipSize;
	
	@Column
	@Getter
	@Setter
	int lightShipMin;
	
	@Column
	@Getter
	@Setter
	int mediumShipMin;
	
	@Column
	@Getter
	@Setter
	int heavyShipMin;
	
	@Column
	@Getter
	@Setter
	int superHeavyShipMin;


}
