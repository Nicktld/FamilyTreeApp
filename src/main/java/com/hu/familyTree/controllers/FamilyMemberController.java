package com.hu.familyTree.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hu.familyTree.db.entities.*;
import com.hu.familyTree.db.repos.FamilyMemberRepos;

@RestController
@RequestMapping("/familyMember")
public class FamilyMemberController {
	
	@Autowired
	FamilyMemberRepos familyMemberRepos;
	
	@GetMapping
	public FamilyMemberEntity getFamilyMember(
			@RequestParam(required=false) String firstName,
			@RequestParam(required=false) String lastName) {
		
		return familyMemberRepos.findByFirstNameLastName(firstName, lastName).get(0);
	}
	
	@GetMapping("/all")
	public List<FamilyMemberEntity> getAllFamilyMembers() {
		return familyMemberRepos.findAll();
	}
	
	@GetMapping("/{id}")
	public FamilyMemberEntity getFamilyMemberById(
			@PathVariable Long id) {
		return familyMemberRepos.findById(id).get();
	}
	
	@PostMapping
	public String addFamilyMember(
			@RequestParam(required=true) String firstName,
			@RequestParam(required=true) String lastName,
			@RequestParam(required=true) String gender) {
		FamilyMemberEntity familyMember = new FamilyMemberEntity(firstName, lastName, gender);
		familyMemberRepos.save(familyMember);
		return "Created";
	}
	
	@PutMapping("/{id}")
	public String editFamilyMember(
			@PathVariable Long id,
			@RequestParam(required=false) String firstName,
			@RequestParam(required=false) String lastName,
			@RequestParam(required=false) String gender) {
		FamilyMemberEntity familyMember = familyMemberRepos.findById(id).get();
		if(firstName != null) {
			familyMember.setFirstName(firstName);
		}
		if(lastName != null) {
			familyMember.setLastName(lastName);
		}
		if(gender != null) {
			familyMember.setGender(gender);
		}
		familyMemberRepos.save(familyMember);
		return "Updated";
	}
	
	@DeleteMapping("/{id}")
	public String deleteFamilyMember(
			@PathVariable Long id) {
		familyMemberRepos.deleteById(id);
		return "Deleted";
	}
}
