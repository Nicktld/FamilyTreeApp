package com.hu.familyTree.controllers.rest;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hu.familyTree.db.entities.*;
import com.hu.familyTree.db.repos.FamilyMemberRepos;
import com.hu.familyTree.services.FamilyMemberService;

@RestController
@RequestMapping("/api/familyMember")
public class FamilyMemberController {
	
	@Autowired
	FamilyMemberService familyMemberService;
	
	@GetMapping
	public FamilyMemberEntity getFamilyMemberByFirstNameLastName(
			@RequestParam(required=true) String firstName,
			@RequestParam(required=true) String lastName) {
		
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
			@RequestParam(required=true) String firstName,
			@RequestParam(required=true) String lastName,
			@RequestParam(required=true) String gender) {
		String resStr = familyMemberService.addFamilyMember(firstName, lastName, gender);
		return resStr;
	}
	
	@PutMapping("/{id}")
	public String editFamilyMember(
			@PathVariable Long id,
			@RequestParam(required=false) String firstName,
			@RequestParam(required=false) String lastName,
			@RequestParam(required=false) String gender) {
		String resStr = familyMemberService.editFamilyMember(id, firstName, lastName, gender);
		return resStr;
	}
	
	@DeleteMapping("/{id}")
	public String deleteFamilyMember(
			@PathVariable Long id) {
		String resStr = familyMemberService.deleteFamilyMember(id);
		return resStr;
	}
}
