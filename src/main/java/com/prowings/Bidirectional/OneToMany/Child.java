package com.prowings.Bidirectional.OneToMany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Child {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@ManyToOne

	@JoinColumn(name = "parent_id")
	private Parent parent;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Parent getParent() {
		return parent;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

}
