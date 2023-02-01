package com.cg.onlinevegetablestore.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "custId", nullable = false)
	private Long customerId;
	
	@Column(name="name", nullable = false)
	private String name;
	
	
	@Column(name = "email", nullable = false)
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	private String email;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "mobile_number", nullable = false)
	@Pattern(regexp="(^$|[0-9]{10})")
	private double mobileNumber;
	
	@Column(name = "order_id")
	private long orderId;

	public Customer() {
		super();
	}
	
	

	public Customer(String name, String email, String username, String password) {
		super();
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.mobileNumber = 0;
		this.orderId = 0;
	}



	public Customer(String name, String email, String username, String password, int mobileNumber, long orderId) {
		super();
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.orderId = orderId;
	}


	

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(double mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ",, email="
				+ email + ", username=" + username + ", password=" + password + ", mobileNumber=" + mobileNumber
				+ ", orderId=" + orderId + "]";
	}
	
	
}