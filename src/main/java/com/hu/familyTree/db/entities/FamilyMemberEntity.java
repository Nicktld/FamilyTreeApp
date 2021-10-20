package com.hu.familyTree.db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "FAMILY_MEMBER")
public class FamilyMemberEntity {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name="SEQ_GEN_FAMILY_MEMBER", sequenceName="FAMILY_MEMBER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN_FAMILY_MEMBER")
	private Long id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "GENDER")
	private String gender;

	protected FamilyMemberEntity() {}

	public FamilyMemberEntity(String firstName, String lastName, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return String.format("FamilyMember[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
