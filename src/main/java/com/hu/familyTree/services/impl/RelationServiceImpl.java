package com.hu.familyTree.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hu.familyTree.db.entities.RelationEntity;
import com.hu.familyTree.db.repos.RelationRepos;
import com.hu.familyTree.services.RelationService;

@Component
public class RelationServiceImpl implements RelationService {
	
	@Autowired
	RelationRepos relationRepos;
	
	// GET
	@Override
	public List<RelationEntity> getAllRelations() {
		return relationRepos.findAll();
	}
	
	@Override
	public RelationEntity getRelationById(Long id) {
		return relationRepos.findById(id).get();
	}
	
	@Override
	public List<RelationEntity> getRelationsByPerson(Long person) {
		return relationRepos.findByPerson(person);
	}
	
	
	// POST
	@Override
	public String addRelation(Long person1, Long person2,
			String relationName, String relationNameVice) {
		RelationEntity relation = new RelationEntity(relationName, relationNameVice, person1, person2);
		relation = relationRepos.save(relation);
		return relation.toString() + " is created!";
	}
	
	
	// PUT
	@Override
	public String editRelation(Long id, Long person1, Long person2,
			String relationName, String relationNameVice) {
		RelationEntity relation = relationRepos.findById(id).get();
		if(person1 != null) {
			relation.setPerson1(person1);
		}
		if(person2 != null) {
			relation.setPerson2(person2);
		}
		if(relationName != null) {
			relation.setRelationName(relationName);
		}
		if(relationNameVice != null) {
			relation.setRelationNameVice(relationNameVice);
		}
		relation = relationRepos.save(relation);
		return relation.toString() + " is updated!";
	}
	
	
	// DELETE
	@Override
	public String deleteRelation(Long id) {
		RelationEntity relation = relationRepos.findById(id).get();
		relationRepos.deleteById(id);
		return relation.toString() + " is deleted!";
	}

	@Override
	public String deleteRelationByPerson(Long person) {
		relationRepos.deleteByPerson(person);
		return "Relations of Person[ " + person + " ] are deleted!";
	}
	
}
