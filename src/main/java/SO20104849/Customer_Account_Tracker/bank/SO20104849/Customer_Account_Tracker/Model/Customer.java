package SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private int customerId;
	
	private String firstName;
	private String lastName;
	
	@Column(unique=true)
	private long phone;
	
	@Column(unique=true)
	private String email;
	
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
	@JoinTable(
			name = "customer_account",
			joinColumns=@JoinColumn(name="customerId")
			)
	private Set<Account> accounts;
		
	//default Constructor
	public Customer() {
		super();
	}

	//Parameterized Constructor
	public Customer(int customerId, String firstName, String lastName, long phone, String email,
			Set<SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Model.Account> accounts) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.accounts = accounts;
	}
//	
//	//Constructor used for Testing
//	public Customer(int customerId, String firstName, String lastName, long phone, String email) {
//		super();
//		this.customerId = customerId;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.phone = phone;
//		this.email = email;
//	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", phone="
				+ phone + ", email=" + email + ", accounts=" + accounts + "]";
	}
	
}
