package SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Controller;


import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Service.CAT_Service;
import SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Exceptions.ResourceNotCreatedException;
import SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Exceptions.ResourceNotFoundException;
import SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Model.Customer;

@RestController
public class CAT_Controller {
	
	@Autowired
	CAT_Service cat_service;
	
	@GetMapping("/")
	public String indexPage() {
		return cat_service.indexPage();
	}
	@PostMapping("/create/customer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customerDetails) throws ResourceNotCreatedException {
		
		Customer createdCustomer = cat_service.createCustomer(customerDetails);
		return new ResponseEntity<Customer>(createdCustomer,HttpStatus.CREATED);	
	}
	@PostMapping("/create/account")
	public ResponseEntity<Customer> createAccount(@RequestBody Customer accountDetails) throws ResourceNotCreatedException, ResourceNotFoundException {
		
		Customer createdAccount = cat_service.createAccount(accountDetails.getCustomerId(), accountDetails.getAccounts());
		return new ResponseEntity<Customer>(createdAccount,HttpStatus.CREATED);
		
	}
	@GetMapping("/getCustomerById/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int id) throws ResourceNotFoundException {
		Customer customer = cat_service.getCustomerById(id);
		return new ResponseEntity<Customer>(customer,HttpStatus.FOUND);
	}
	@GetMapping("/getCustomer")
	public List<Customer> getCustomer() throws ResourceNotFoundException {
		List<Customer> customer = cat_service.getCustomer();
		return customer;
	}
	@GetMapping("/getCustomerByAnyField/FirstName/{fName}")
	public List<Customer> getCustomerByfirstName(@PathVariable("fName") String fName) throws ResourceNotFoundException {
		List<Customer> customer = cat_service.getCustomerByAnyField("FirstName", fName);
		return customer;
	}
	@GetMapping("/getCustomerByAnyField/LastName/{lName}")
	public List<Customer> getCustomerBylastName(@PathVariable("lName") String lName) throws ResourceNotFoundException {
		List<Customer> customer = cat_service.getCustomerByAnyField("LastName", lName);
		return customer;
	}
	@GetMapping("/getCustomerByAnyField/Phone/{phone}")
	public List<Customer> getCustomerByPhone(@PathVariable("phone") String phone) throws ResourceNotFoundException {
		List<Customer> customer = cat_service.getCustomerByAnyField("Phone", phone);
		return customer;
	}
	@GetMapping("/getCustomerByAnyField/Email/{email}")
	public List<Customer> getCustomerByEmail(@PathVariable("email") String email) throws ResourceNotFoundException {
		List<Customer> customer = cat_service.getCustomerByAnyField("Email", email);
		return customer;
	}
	@PutMapping("/customer/update")
	public Customer updateCustomerDetails(@RequestBody Customer editedCustomerDetails) throws ResourceNotFoundException {
		Customer customer = cat_service.updateCustomerDetails(editedCustomerDetails);
		return customer;
	}
	@DeleteMapping("/deleteCustomerAccountByID/{id}")
	public ResponseEntity<String> deleteCustomerAccountByID(@PathVariable int id) throws ResourceNotFoundException {
		String msg = cat_service.deleteCustomerAccountByID(id);
		return  new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	@DeleteMapping("/deleteCustomerAccount")
	public ResponseEntity<String> deleteCustomerAccount() {
		String msg = cat_service.deleteCustomerAccount();
		return  new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	@PutMapping("/account/transfer/{fromAccount}/{toAccount}/{amount}")
	public ResponseEntity<String> transferFunds(@PathVariable long fromAccount, @PathVariable long toAccount, @PathVariable double amount) throws ResourceNotFoundException
	{
		String msg = cat_service.fundTransfer(fromAccount, toAccount, amount);
		return new ResponseEntity<String>(msg,HttpStatus.OK);	
	}
}
