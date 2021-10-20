package com.hu.familyTree.db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "RELATION")
public class RelationEntity {
	
	@Id
	@Column(name = "ID")
	@SequenceGenerator(name="SEQ_GEN_RELATION", sequenceName="RELATION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN_RELATION")
	private Long id;
	
	@Column(name = "RELATION_NAME")
	private String relationName;
	
	@Column(name = "RELATION_NAME_VICE")
	private String relationNameVice;
	
	@Column(name = "PERSON1")
	private Long person1;
	
	@Column(name = "PERSON2")
	private Long person2;

	protected RelationEntity() {}

	public RelationEntity(String relationName, String relationNameVice, Long person1, Long person2) {
		this.relationName = relationName;
		this.relationNameVice = relationNameVice;
		this.person1 = person1;
		this.person2 = person2;
	}

	@Override
	public String toString() {
		return String.format("Relaton[Person1 '%s' is '%s' of Person2 '%s']", person1, relationName, person2);
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getRelationName() {
		return relationName;
	}
	
	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}
	
	public String getRelationNameVice() {
		return relationNameVice;
	}
	
	public void setRelationNameVice(String relationNameVice) {
		this.relationNameVice = relationNameVice;
	}
	
	public Long getPerson1() {
		return person1;
	}
	
	public void setPerson1(Long person1) {
		this.person1 = person1;
	}
	
	public Long getPerson2() {
		return person2;
	}
	
	public void setPerson2(Long person2) {
		this.person2 = person2;
	}
}
