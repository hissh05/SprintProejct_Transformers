package com.cg.onlinevegetablestore.entity;

//import javax.persistence.CascadeType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cg.onlinevegetablestore.entity.Order;

@Entity
@Table(name="customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_Id", nullable = false)
	private Long userId;
	
	@Column(name="user_name", nullable = false)
	private String userName;
	
	@Column(name = "password", nullable = false)
	private String Password;
	
	@Column(name = "mobile_no", nullable = false)
	private Long MobileNo;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "address", nullable = false)
	private String Address;
	
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Order> orders = new ArrayList<Order>();
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	//generate getter and setters for orders
	public List<Order> getOrder() {
		return orders;
	}

	public void setOrder(List<Order> orders) {
		this.orders = orders;
	}
	
	

	public Customer(Long userId,String userName, String Password,Long MobileNo, String email, String Address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.Password = Password;
		this.MobileNo = MobileNo;
		this.email = email;
		this.Address = Address;
	}


	

	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return Password;
	}



	public void setPassword(String password) {
		Password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		email = email;
	}



	public String getAddress() {
		return Address;
	}



	public void setAddress(String address) {
		Address = address;
	}
	
	public Long getmobileNo() {
		return MobileNo;
	}
	
	public void setMobileNo(Long mobileNo) {
		MobileNo = mobileNo;
	}
	
	
	



	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", userName=" + userName + ",Password ="+ Password +", MobileNo =" + MobileNo +", Email="
				+ email + ",Address =" +Address+ "]";
	}

	

	
	
	
}
