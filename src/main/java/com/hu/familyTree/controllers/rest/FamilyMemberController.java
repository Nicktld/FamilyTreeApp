package com.hu.familyTree.controllers.rest;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hu.familyTree.db.entities.*;
import com.hu.familyTree.db.repos.FamilyMemberRepos;
import com.hu.familyTree.services.FamilyMemberService;
import com.hu.familyTree.services.RelationService;

@RestController
@RequestMapping("/api/familyMember")
public class FamilyMemberController {
	
	@Autowired
	FamilyMemberService familyMemberService;
	
	@Autowired
	RelationService relationService;
	
	@GetMapping
	public FamilyMemberEntity getFamilyMemberByFirstNameLastName(
			@RequestParam(name="firstName", required=true) String firstName,
			@RequestParam(name="lastName", required=true) String lastName) {
		
		return familyMemberService.getFamilyMemberByFirstNameLastName(firstName, lastName);
	}
	
	@GetMapping("/{id}")
	public FamilyMemberEntity getFamilyMemberById(
			@PathVariable Long id) {
		return familyMemberService.getFamilyMemberById(id);
	}
	
	@GetMapping("/all")
	public List<FamilyMemberEntity> getAllFamilyMembers() {
		return familyMemberService.getAllFamilyMembers();
	}
	

	@PostMapping
	public String addFamilyMember(
			@RequestParam(name="firstName", required=true) String firstName,
			@RequestParam(name="lastName", required=true) String lastName,
			@RequestParam(name="gender", required=true) String gender) {
		String resStr = familyMemberService.addFamilyMember(firstName, lastName, gender);
		return resStr;
	}
	
	@PutMapping("/{id}")
	public String editFamilyMember(
			@PathVariable Long id,
			@RequestParam(name="firstName", required=false) String firstName,
			@RequestParam(name="lastName", required=false) String lastName,
			@RequestParam(name="gender", required=false) String gender) {
		String resStr = familyMemberService.editFamilyMember(id, firstName, lastName, gender);
		return resStr;
	}
	
	@DeleteMapping("/{id}")
	public String deleteFamilyMember(
			@PathVariable Long id) {
		String resStr = relationService.deleteRelationByPerson(id);
		resStr += familyMemberService.deleteFamilyMember(id);
		return resStr;
	}
}
