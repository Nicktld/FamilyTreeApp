package com.hu.familyTree.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hu.familyTree.db.entities.FamilyMemberEntity;
import com.hu.familyTree.db.repos.FamilyMemberRepos;

@Controller
public class UserController {
    
	@Autowired
	FamilyMemberRepos familyMemberRepos;
	
	@GetMapping("/index")
	public String showUserList(Model model) {
	    model.addAttribute("users", familyMemberRepos.findAll());
	    return "index";
	}
	
    @GetMapping("/adduser")
    public String showAddUserForm(@ModelAttribute FamilyMemberEntity member) {
        return "add-user";
    }
    
    @PostMapping("/adduser")
    public String addUser(@ModelAttribute FamilyMemberEntity member, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
        
        familyMemberRepos.save(member);
        return "redirect:/index";
    }

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		FamilyMemberEntity familyMember = familyMemberRepos.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid member Id:" + id));
	    
	    model.addAttribute("member", familyMember);
	    return "update-user";
	}
	
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, FamilyMemberEntity familyMember, 
      BindingResult result, Model model) {
        if (result.hasErrors()) {
            familyMember.setId(id);
            return "update-user";
        }
            
        familyMemberRepos.save(familyMember);
        return "redirect:/index";
    }
        
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        FamilyMemberEntity familyMember = familyMemberRepos.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        familyMemberRepos.delete(familyMember);
        return "redirect:/index";
    }
    // additional CRUD methods
}