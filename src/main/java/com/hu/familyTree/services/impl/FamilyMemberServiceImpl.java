package com.hu.familyTree.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hu.familyTree.db.entities.FamilyMemberEntity;
import com.hu.familyTree.db.repos.FamilyMemberRepos;
import com.hu.familyTree.db.repos.RelationRepos;
import com.hu.familyTree.services.FamilyMemberService;

@Component
public class FamilyMemberServiceImpl implements FamilyMemberService {
	
	@Autowired
	FamilyMemberRepos familyMemberRepos;
	
	@Autowired
	RelationRepos relationRepos;
	
	@Override
	public FamilyMemberEntity getFamilyMemberByFirstNameLastName(String firstName, String lastName) {
		
		return familyMemberRepos.findByFirstNameLastName(firstName, lastName).get(0);
	}
	
	@Override
	public FamilyMemberEntity getFamilyMemberById(Long id) {
		return familyMemberRepos.findById(id).get();
	}
	
	@Override
	public List<FamilyMemberEntity> getAllFamilyMembers() {
		return familyMemberRepos.findAll();
	}
	
	@Override
	public String addFamilyMember(String firstName, String lastName, String gender) {
		FamilyMemberEntity familyMember = new FamilyMemberEntity(firstName, lastName, gender);
		familyMember = familyMemberRepos.save(familyMember);
		return familyMember.toString() + " is created!";
	}
	
	@Override
	public String editFamilyMember(Long id, String firstName, String lastName, String gender) {
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
		familyMember = familyMemberRepos.save(familyMember);
		return familyMember.toString() + " is updated!";
	}
	
	@Override
	public String deleteFamilyMember(Long id) {
		FamilyMemberEntity familyMember = familyMemberRepos.findById(id).get();
		familyMemberRepos.deleteById(id);
		return familyMember.toString() + " is deleted!";
	}
}
