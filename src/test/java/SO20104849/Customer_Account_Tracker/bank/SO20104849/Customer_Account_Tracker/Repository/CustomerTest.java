package SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Repository;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Model.Customer;


public class CustomerTest {
	
	@Autowired
	Customer_Repo customer_repo;
	
	@Before
	public void createCustomer() throws Exception {
		List<Customer> customer = Arrays.asList(
				new Customer(1,"Demo","DEMO",1234567890,"demo@demo.com", null),
				new Customer(2,"Support","SUPPORT",987654321,"support@support.com", null));
		customer_repo.saveAll(customer);
	}
	
	@After
	public void deleteCustomer() throws Exception {
		customer_repo.deleteAll();
	}
	
	@Test
	@Order(1)
	public void getCustomer() throws Exception {
		
		List<Customer> customerResult = customer_repo.findAll();
		assertEquals(2, customerResult.size());
		
	}

}
