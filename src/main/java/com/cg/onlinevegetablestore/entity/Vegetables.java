package com.cg.onlinevegetablestore.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vegetables")


public class Vegetables {
	@Id
	@Column(name = "vegetables_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vegetablesId;
	
//	@Column(name = "user_id")
//	private Long userId;
	
	@Column(name = "vegetables_name")
	private String vegetablesName;
	
	@Column(name = "vegetables_price")
	private float vegetablesPrice;
	
	
	
	public Vegetables() {
		// TODO Auto-generated constructor stubsu
		super();
	}

	public Vegetables(Long vegetablesId, String vegetablesName, float vegetablesPrice, String vegetablesQuantity) {
		super();
		this.vegetablesId = vegetablesId;
		this.vegetablesName = vegetablesName;
		this.vegetablesPrice = vegetablesPrice;
	}

	public Long getVegetablesId() {
		return vegetablesId;
	}

	public void setVegetablesId(Long vegetablesId) {
		this.vegetablesId = vegetablesId;
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
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "order_id")
	private Customer userId;


	@Override
	public String toString() {
		return "Vegetables [vegetablesId=" + vegetablesId + ", userId=" + userId + ", vegetablesName=" + vegetablesName
				+ ", vegetablesPrice=" + vegetablesPrice + "]";
	}
	
	
}