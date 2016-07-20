package de.mlo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Special {

	@Id
	@GeneratedValue
	@Getter
	@Setter
	private int id;
	
	@Column(unique = true)
	@Getter
	@Setter
	private String name;

}
