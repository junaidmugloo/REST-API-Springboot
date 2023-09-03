package com.example.demo.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Students {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
	private Integer id;
    private String Name, Address;
    private int rollNo;
	
	public Students(String name, String address, int rollNo,Integer id) {
		super();
		this.id = id;
		this.Name = name;
		this.Address = address;
		this.rollNo = rollNo;
	}
	public Students() {
		
	}

	public void setId(Integer id)
	{
		this.id=id;
	}
	public Integer getId()
	{
		return id;
	}
	public String getName() {
		return this.Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getAddress() {
		return this.Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
    
    
}
