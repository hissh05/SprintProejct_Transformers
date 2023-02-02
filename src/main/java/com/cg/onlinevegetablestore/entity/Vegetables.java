package com.cg.onlinevegetablestore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vegetables")


public class Vegetables {
	@Id
	@Column(name = "vegetables_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vegetablesId;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "vegetables_name")
	private String vegetablesName;
	
	@Column(name = "vegetables_price")
	private float vegetablesPrice;
	
	@Column(name = "vegetables_Quantity")
	private String vegetablesQuantity;
	
	public Vegetables() {
		// TODO Auto-generated constructor stub
	}

	public Vegetables(Long userId, String vegetablesName, float vegetablesPrice, String vegetablesQuantity) {
		super();
		this.userId = userId;
		this.vegetablesName = vegetablesName;
		this.vegetablesPrice = vegetablesPrice;
		this.vegetablesQuantity = vegetablesQuantity;
	}

	public Long getVegetablesId() {
		return vegetablesId;
	}

	public void setVegetablesId(Long vegetablesId) {
		this.vegetablesId = vegetablesId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getVegetablesName() {
		return vegetablesName;
	}

	public void setVegetablesName(String vegetablesName) {
		this.vegetablesName = vegetablesName;
	}

	public float getVegetablesPrice() {
		return vegetablesPrice;
	}

	public void setVegetablesPrice(float vegetablesPrice) {
		this.vegetablesPrice = vegetablesPrice;
	}

	public String getVegetablesQuantity() {
		return vegetablesQuantity;
	}

	public void setVegetablesQuantity(String vegetablesQuantity) {
		this.vegetablesQuantity = vegetablesQuantity;
	}
	
}