package com.hu.familyTree.db.repos;

import java.util.List;
import java.util.Optional;

import com.hu.familyTree.db.entities.RelationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationRepos extends JpaRepository<RelationEntity, Long> {

	List<RelationEntity> findAll();
	
	void deleteById(Long id);
	
	@Query("SELECT u FROM RelationEntity u WHERE u.person1 = ?1 OR u.person2 = ?1")
	List<RelationEntity> findByPerson(Long person);

	@Query("DELETE FROM RelationEntity u WHERE u.person1 = ?1 OR u.person2 = ?1")
	void deleteByPerson(Long person);
	
	@Query("DELETE FROM RelationEntity u WHERE u.person1 = ?1 AND u.person2 = ?2")
	void deleteByP1P2(Long person1, Long person2);

}
