package io.start.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "customers")
public class Customer 
{
	@Id
	//@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String name;
	private String surname;
	
	
	
	 
	public Customer() {
		super();
	}


	public Customer( String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}


	public Customer(int id, String name, String surname) 
	{
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
	}
	
	
	public int getId() 
	{
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getSurname() 
	{
		return surname;
	}
	public void setSurname(String surname) 
	{
		this.surname = surname;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}
	
	
	
	
	
	
}
