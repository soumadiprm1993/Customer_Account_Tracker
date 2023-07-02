package SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Exceptions.*;
import SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Model.Account;
import SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Model.Customer;
import SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Repository.Account_Repo;
import SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Repository.Customer_Repo;

@Service
public class CAT_Service {
	
	@Autowired
	Account_Repo account_Repo;
	
	@Autowired
	Customer_Repo customer_Repo;
	
	
	public String indexPage() {
		return "Welcome To The Capstone Project For Java Back End Development Training";
	}
	
	public Customer createCustomer(Customer customerDetails) throws ResourceNotCreatedException {
		
		Customer customer = customer_Repo.save(customerDetails);
		return customer;
		
	}
	
	public Customer createAccount(int id, Set<Account> account) throws ResourceNotCreatedException, ResourceNotFoundException {
		if(customer_Repo.existsById(id)) {
			
			Customer customer = customer_Repo.findById(id).get();
			customer.setAccounts(account);
			
			Customer newCustomer = customer_Repo.save(customer);
			return newCustomer;
			
		}
		else {
			throw new ResourceNotFoundException("Customer Detail's not Found");
		}
		
	}
	
	public Customer getCustomerById(int id) throws ResourceNotFoundException {
		
		if(customer_Repo.existsById(id)) {
			Customer customer = customer_Repo.findById(id).get();
			return customer;
		}
		else {
			throw new ResourceNotFoundException("Account Detail's not Found");
		}
				
	}
	public List<Customer> getCustomer() throws ResourceNotFoundException {
		
		List<Customer> customer = customer_Repo.findAll();
		if(customer.isEmpty())
			throw new ResourceNotFoundException("Account's not Found");
		return customer;
				
	}
	
	public List<Customer> getCustomerByAnyField(String field, String value) throws ResourceNotFoundException {
		
		
		switch(field) {
		
		case "FirstName" : 
			List<Customer> customer = customer_Repo.findByfirstName(value);
			if(customer.isEmpty())
				throw new ResourceNotFoundException("Account's not Found");
			return customer;
		case "LastName" :
			customer = customer_Repo.findBylastName(value);
			if(customer.isEmpty())
				throw new ResourceNotFoundException("Account's not Found");
			return customer;
		case "Phone" :
			customer = customer_Repo.findByphone(Long.parseLong(value));
			if(customer.isEmpty())
				throw new ResourceNotFoundException("Account's not Found");
			return customer;
		case "Email" :
			customer = customer_Repo.findByemail(value);
			if(customer.isEmpty())
				throw new ResourceNotFoundException("Account's not Found");
			return customer;
		default :
			throw new ResourceNotFoundException("Wrong Input");
			
		}			
	}
	public Customer updateCustomerDetails(Customer editedCustomerDetails) throws ResourceNotFoundException {
	
		if(customer_Repo.existsById(editedCustomerDetails.getCustomerId())) {
		
			Customer customer = customer_Repo.findById(editedCustomerDetails.getCustomerId()).get();
			Set<Account> account = customer.getAccounts();
			editedCustomerDetails.setAccounts(account);
			customer = customer_Repo.save(editedCustomerDetails);
			return customer;
		}
		throw new ResourceNotFoundException("Account not exist");
	}
	public String deleteCustomerAccountByID(int id) throws ResourceNotFoundException {
		
		if(customer_Repo.existsById(id)) {
			customer_Repo.deleteById(id);
			return ("Customer Details Has Been Deleted :: Customer ID "+id);
		}
		else {
			throw new ResourceNotFoundException("Account's not Found");
		}
				
	}
	public String deleteCustomerAccount() {
		
		customer_Repo.deleteAll();
		return "All Customer Details Has Been Deleted";
				
	}
	public String fundTransfer(Long fromAccount, Long toAccount, double amount) throws ResourceNotFoundException
	{
		Account sender = account_Repo.getById(fromAccount);
		Account receiver = account_Repo.getById(toAccount);
		
		if(sender == null || receiver == null)
			throw new ResourceNotFoundException("Either Receiver or Sender account doesn't exist.");
		
		double senderBalance = sender.getaccountBalance();
		double receiverBalance = receiver.getaccountBalance();
		
		if(senderBalance > amount)
		{
			sender.setaccountBalance(senderBalance - amount);
			receiver.setaccountBalance(receiverBalance + amount);
			account_Repo.save(sender);
			account_Repo.save(receiver);
			
			return "Fund Transfer Successful";
		}
		else
			throw new ResourceNotFoundException("Insufficent Balance");
	}	
	
}
