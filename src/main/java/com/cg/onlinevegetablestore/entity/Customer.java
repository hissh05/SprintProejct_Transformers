package com.cg.onlinevegetablestore.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String Email;
	
	@Column(name = "address", nullable = false)
	private String Address;
	
	

	public Customer() {
		super();
	}
	
	

	public Customer(String userName, String Password, String Email, String Address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.Password = Password;
		this.MobileNo = MobileNo;
		this.Email = Email;
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
		return Email;
	}



	public void setEmail(String email) {
		Email = email;
	}



	public String getAddress() {
		return Address;
	}



	public void setAddress(String address) {
		Address = address;
	}
	
	public Long getMobileNo() {
		return MobileNo;
	}
	
	public void setMobileNo(Long MonileNo) {
		MobileNo = MobileNo;
	}



	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", userName=" + userName + ",Password ="+ Password +", MobileNo =" + MobileNo +", Email="
				+ Email + ",Address =" +Address+ "]";
	}

	

	
	
	
}
