package com.cg.onlinevegetablestore.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order{
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="order_id")
		
		private Long orderId;
		
		@Column(name = "userId")
		private Long userId;
		
		@Column(name = "amount")
		private double amount;
		
//		@Column(name = "product_list")
//		private List<String> product_list;
//		
		@Column(name = "order_date")
		private Date orderDate;
		
		@Column(name = "order_Address")
		private String orderAddress;

		public Order() {
			super();
		}
		
		

		public Order(Long orderId, Long userId, double amount, Date orderDate, String orderAddress) {
			super();
			this.orderId = orderId;
			this.userId = userId;
			this.amount = amount;
//			this.product_list = product_list;
			this.orderDate = orderDate;
			this.orderAddress = orderAddress;
		}



		public String getOrderAddress() {
			return orderAddress;
		}


		public void setOrderAddress(String orderAddress ) {
			this.orderAddress= orderAddress;
		}


		public Long getOrderId() {
			return orderId;
		}

		public void setOrderId(Long orderId) {
			this.orderId = orderId;
		}

		public Long getCustomerId() {
			return userId;
		}

		public void setCustomerId(Long customerId) {
			this.userId = customerId;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		
		public Date getOrderDate() {
			return orderDate;
		}


		public void setOrderDate(Date orderDate) {
			this.orderDate = orderDate;
		}


		@Override
		public String toString() {
			return "Order [orderId=" + orderId + ", customerId=" + userId + ", amount=" + amount 
					+ ", orderDate=" + orderDate + ", OrderAddress=" + orderAddress + "]";
		}



}