package com.hu.familyTree.controllers.rest;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hu.familyTree.db.entities.*;
import com.hu.familyTree.services.RelationService;


@RestController
@RequestMapping("/api/relation")
public class RelationController2 {
	
	@Autowired
	RelationService relationService;
	
	@GetMapping("/all")
	public List<RelationEntity> getAllRelations() {
		return relationService.getAllRelations();
	}
	
	@GetMapping("/{id}")
	public RelationEntity getRelationById(
			@PathVariable Long id) {
		return relationService.getRelationById(id);
	}
	
	@GetMapping("/person/{id}")
    public List<RelationEntity> getRelationsByPerson(
    		@PathVariable Long person) {
		return relationService.getRelationsByPerson(person);
    }
    
    @PostMapping
    public String addRelation(
    		@RequestParam(name="person1", required=true) Long person1,
    		@RequestParam(name="person2", required=true) Long person2,
    		@RequestParam(name="relationName", required=true) String relationName,
    		@RequestParam(name="relationNameVice", required=true) String relationNameVice) {
        return relationService.addRelation(person1, person2, relationName, relationNameVice);
    }
	
    @PutMapping("/{id}")
    public String editRelation(
    		@PathVariable(required=true) Long id,
    		@RequestParam(name="person1", required=false) Long person1,
    		@RequestParam(name="person2", required=false) Long person2,
    		@RequestParam(name="relationName", required=false) String relationName,
    		@RequestParam(name="relationNameVice", required=false) String relationNameVice) {
    	return relationService.editRelation(id, person1, person2, relationName, relationNameVice);
    }
    
    @DeleteMapping("/{id}")
    public String deleteRelation(
    		@PathVariable(required=true) Long id) {
    	return relationService.deleteRelation(id);
    }

    @DeleteMapping("/person/{id}")
    public String deleteRelationByPerson(
    		@PathVariable(required=true) Long id) {
    	return relationService.deleteRelationByPerson(id);
    }
}
