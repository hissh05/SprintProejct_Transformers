package com.cg.onlinevegetablestore.entity;

import java.util.Date;

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
@Table(name="order_details")

public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orderdetails_id")
	private Long detailsId;
	
	@Column(name = "order_status", nullable = false)
	private String order_status;
	
	@Column(name = "total_price", nullable = false)
	private double tPrice;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "address")
	private String address;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "order_id")
	private Order order;

	public OrderDetails() {
		super();
	}

	public Long getOrderDetailsId() {
		return detailsId;
	}

	public void setOrderDetailsId(Long orderDetailsId) {
		this.detailsId = orderDetailsId;
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
	
	public OrderDetails(Long detailsId, String order_status, double tPrice, Date date, String address, Order order) {
		super();
		this.detailsId = detailsId;
		this.order_status = order_status;
		this.tPrice = tPrice;
		this.date = date;
		this.address = address;
		
		this.order = order;
		}

	@Override
	public String toString() {
		return "OrderDetails [DetailsId=" + detailsId + ", order_status=" + order_status + ", tPrice=" + tPrice
				+ ", date=" + date + ", address=" + address + ", order=" + order + "]";
	}
}