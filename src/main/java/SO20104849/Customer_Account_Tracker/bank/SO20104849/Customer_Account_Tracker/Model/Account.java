package SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Parameter;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Model.Account;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Sequencial")
	@GenericGenerator(name="Sequencial",
						strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",
						parameters= {
								@Parameter(name="initial_value", value="1000")
						})
	@Column(unique=true)
	private long accountNo;
	private String accountType;	
	private double accountBalance;

	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "accounts", fetch = FetchType.LAZY)
	@JsonIgnore
	
	private Set<Customer> customer;

	//default Constructor
	public Account() {
		super();
	}
	
	//Parameterized Constructor
	public Account(long accountNo, String accountType, double accountBalance, Set<Customer> customer) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.customer = customer;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getaccountBalance() {
		return accountBalance;
	}

	public void setaccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Set<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(Set<Customer> customer) {
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountType=" + accountType + ", accountBalance=" + accountBalance
				+ ", customer=" + customer + "]";
	}

}
