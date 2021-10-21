package com.hu.familyTree.services;

import java.util.List;

import com.hu.familyTree.db.entities.FamilyMemberEntity;

public interface FamilyMemberService {

	// GET
	FamilyMemberEntity getFamilyMemberById(Long id);
	
	FamilyMemberEntity getFamilyMemberByFirstNameLastName(String firstName, String lastName);
	
	List<FamilyMemberEntity> getAllFamilyMembers();
	
	
	// POST
	String addFamilyMember(String firstName, String lastName, String gender);
	
	
	// PUT
	String editFamilyMember(Long id, String firstName, String lastName, String gender);
	
	
	// DELETE
	String deleteFamilyMember(Long id);
}
