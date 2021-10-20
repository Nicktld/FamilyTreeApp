package com.hu.familyTree.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.hu.familyTree.db.entities.*;
import com.hu.familyTree.db.repos.FamilyMemberRepos;
import com.hu.familyTree.db.repos.RelationRepos;


@Controller
@RequestMapping("/relation/person")
public class RelationController {
	
	@Autowired
	FamilyMemberRepos familyMemberRepos;
	
	@Autowired
	RelationRepos relationRepos;
	
	@GetMapping("/{id}")
	public String getPersonAllRelations(
			@PathVariable("id") long person, Model model) {
		FamilyMemberEntity familyMember = familyMemberRepos.findById(person).get();
		List<FamilyMemberEntity> familyMembers = new ArrayList<>();
		familyMembers.add(familyMember);
		List<RelationEntity> relationList = relationRepos.findByPerson(person);
		Map<Long, String> nameList = new HashMap<>();
		for(RelationEntity relation : relationList) {
			
			Long person1 = relation.getPerson1();
			Long person2 = relation.getPerson2();
			String fullName = "";
			if(!nameList.containsKey(person1)) {
				FamilyMemberEntity tmpMember = familyMemberRepos.findById(person1).get();
				fullName = tmpMember.getFirstName() + " " + tmpMember.getLastName();
				nameList.put(person1, fullName);
			}
			if(!nameList.containsKey(person2)) {
				FamilyMemberEntity tmpMember = familyMemberRepos.findById(person2).get();
				fullName = tmpMember.getFirstName() + " " + tmpMember.getLastName();
				nameList.put(person2, fullName);
			}	
		}
		model.addAttribute("users", familyMembers);
		model.addAttribute("fullNames", nameList);
		model.addAttribute("relations", relationList);
		return "index";
	}
	
	@GetMapping("/addrelation")
    public String showAddRelationForm(@ModelAttribute RelationEntity relation) {
        return "add-relation";
    }
    
    @PostMapping("/addrelation")
    public String addUser(@ModelAttribute RelationEntity relation, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-relation";
        }
        
        relationRepos.save(relation);
        return "redirect:/index";
    }
	
    @GetMapping("/{id}/edit/{rid}")
	public String showUpdateForm(@PathVariable("id") long person, @PathVariable("rid") long id, Model model) {
		RelationEntity relation = relationRepos.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid relation Id:" + id));
	    
	    model.addAttribute("relation", relation);
	    model.addAttribute("p1", person);
	    return "update-relation";
	}
    
    @PostMapping("/{id}/update/{rid}")
    public String updateRelation(@PathVariable("id") long person, @PathVariable(name="rid") long id, RelationEntity relation, 
      BindingResult result, Model model) {
        if (result.hasErrors()) {
            relation.setId(id);
            return "update-relation";
        }
            
        relationRepos.save(relation);
        return "redirect:/relation/person/" + person;
    }
    
    @GetMapping("/{id}/delete/{rid}")
	public String deleteRelation(@PathVariable(name="id") long person, @PathVariable(name="rid") long id) {
	   RelationEntity relation = relationRepos.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid relation Id:" + id));
        relationRepos.delete(relation);
        return "redirect:/relation/person/" + person;
    }
	

}
