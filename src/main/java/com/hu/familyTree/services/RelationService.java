package com.hu.familyTree.services;

import java.util.List;

import com.hu.familyTree.db.entities.RelationEntity;

public interface RelationService {
	// GET
	List<RelationEntity> getAllRelations();
	
	RelationEntity getRelationById(Long id);
	
	List<RelationEntity> getRelationsByPerson(Long person);
	
	
	// POST
	String addRelation(Long person1, Long person2, String relationName, String relationNameVice);
	
	
	// PUT
	String editRelation(Long id, Long person1, Long person2, String relationName, String relationNameVice);
	
	
	// DELETE
	String deleteRelation(Long id);
	
	String deleteRelationByPerson(Long person);
}
