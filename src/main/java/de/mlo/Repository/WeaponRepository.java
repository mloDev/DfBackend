package de.mlo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.model.Weapon;

public interface WeaponRepository extends JpaRepository<Weapon, Integer> {

}
