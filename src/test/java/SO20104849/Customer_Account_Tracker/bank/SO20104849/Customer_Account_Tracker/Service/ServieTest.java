package SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Model.Customer;

@WebMvcTest(CAT_Service.class)
public class ServieTest {

	@MockBean
	private CAT_Service cat_service;
	
	@Test
	@Order(1)
	public void getCustomer() throws Exception {
		
		List<Customer> customer = Arrays.asList(
				new Customer(1,"Demo","DEMO",1234567890,"demo@demo.com", null),
				new Customer(2,"Support","SUPPORT",987654321,"support@support.com", null));
		Mockito.when(cat_service.getCustomer()).thenReturn(customer);
		
		List<Customer> customerResult = cat_service.getCustomer();
		
		assertEquals("Demo", customerResult.get(0).getFirstName());
		assertEquals("DEMO", customerResult.get(0).getLastName());
		assertEquals(1234567890, customerResult.get(0).getPhone());
		assertEquals("demo@demo.com", customerResult.get(0).getEmail());
		assertEquals("Support", customerResult.get(1).getFirstName());
		assertEquals("SUPPORT", customerResult.get(1).getLastName());
		assertEquals(987654321, customerResult.get(1).getPhone());
		assertEquals("support@support.com", customerResult.get(1).getEmail());
		
	}
	
}
