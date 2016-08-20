package de.mlo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.model.BattleGroup;

public interface BattleGroupRepository extends JpaRepository<BattleGroup, Integer> {

}
