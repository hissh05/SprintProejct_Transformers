package com.cg.onlinevegetablestore.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="order_details")

public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orderdetails_id")
	private Long DetailsId;
	
	@Column(name = "order_status", nullable = false)
	private String order_status;
	
	@Column(name = "total_price", nullable = false)
	private double tPrice;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "address")
	private String address;
	
//	@Column(name="product_list")
//	private List<String> plist;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "order_id")
	private Order order;

	public OrderDetails() {
		super();
	}

	public Long getOrderDetailsId() {
		return DetailsId;
	}

	public void setOrderDetailsId(Long orderDetailsId) {
		this.DetailsId = orderDetailsId;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public double getTprice() {
		return tPrice;
	}

	public void setTprice(double tprice) {
		tPrice = tprice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setOrder(Order order2) {
		// TODO Auto-generated method stub
		this.order = order2;
		
	}

	@Override
	public String toString() {
		return "OrderDetails [DetailsId=" + DetailsId + ", order_status=" + order_status + ", tPrice=" + tPrice
				+ ", date=" + date + ", address=" + address + ", order=" + order + "]";
	}

//	public List<String> getPlist() {
//		return plist;
//	}
//
//	public void setPlist(List<String> plist) {
//		this.plist = plist;
//	}


	
	
}
