package com.hu.familyTree.db.repos;

import java.util.List;
import java.util.Optional;

import com.hu.familyTree.db.entities.FamilyMemberEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FamilyMemberRepos extends CrudRepository<FamilyMemberEntity, Long> {
	
	Optional<FamilyMemberEntity> findById(Long id);
	
	List<FamilyMemberEntity> findAll();
	
	void deleteById(Long id);
	
	@SuppressWarnings("unchecked")
	FamilyMemberEntity save(FamilyMemberEntity familyMemberEntity);
	
	@Query("SELECT u FROM FamilyMemberEntity u WHERE u.firstName = ?1 AND u.lastName = ?2")
	List<FamilyMemberEntity> findByFirstNameLastName(String firstname, String lastname);

}
