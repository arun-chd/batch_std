package com.entity;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="std_info")
public class student {
	
	@Id
	private int id;
	private String name;
	private String gender;
	private int marks;
	private String address;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public student(String name, String gender, String address) {
		super();
		this.id = new Random().nextInt(50);
		this.name = name;
		this.gender = gender;
		this.marks = new Random().nextInt(100);
		this.address = address;
	}
	public student() {
		super();
		
	}
	
	
	
	
	

}
