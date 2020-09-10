package io.start.product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="product")
public class Product 
{
	@Id
	private int id;
	private String name;
	private int ownerid;
	
	public Product() {
		super();
	}

	public Product(int id, String name, int ownerId) 
	{
		super();
		this.id = id;
		this.name = name;
		this.ownerid = ownerId;
	}

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

	public int getOwnerId() {
		return ownerid;
	}

	public void setOwnerId(int ownerId) {
		this.ownerid = ownerId;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", ownerId=" + ownerid + "]";
	}
	
	
	
	
	
	
}
