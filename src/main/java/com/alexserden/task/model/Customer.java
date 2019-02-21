package com.alexserden.task.model;

import javax.persistence.*;

@Entity
public class Customer {
	private long id;	 
	private String firstName;	
	private String lastName;
	private String description;

    public Customer() {
    }

	public Customer(String firstName, String lastName, String description) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
	}

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

    @Column(name = "firstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

    @Column(name = "lastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

    @Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}





}
