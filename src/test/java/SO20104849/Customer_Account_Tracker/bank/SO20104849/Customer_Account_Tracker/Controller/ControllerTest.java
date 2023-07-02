package SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Controller;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.gson.Gson;

import SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Model.Customer;

import SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Service.CAT_Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;


@WebMvcTest(CAT_Controller.class)
public class ControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CAT_Service cat_service;
	
	@Test
	@Order(1)
	public void getCustomer() throws Exception {
		
		RequestBuilder request;
		List<Customer> customer = Arrays.asList(
				new Customer(1,"Demo","DEMO",1234567890,"demo@demo.com", null),
				new Customer(2,"Support","SUPPORT",987654321,"support@support.com", null));
		Mockito.when(cat_service.getCustomer()).thenReturn(customer);
		
		request = MockMvcRequestBuilders
				.get("/getCustomer")
				.accept(MediaType.APPLICATION_JSON);
		
		String expectedResult= "[{customerId : 1, firstName : Demo, lastName : DEMO, phone : 1234567890, email : demo@demo.com},{customerId : 2, firstName : Support, lastName : SUPPORT, phone : 987654321, email : support@support.com}]";
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json(expectedResult))
				.andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());	
		
	}
	@Test
	@Order(2)
	public void createCustomer() throws Exception {
	
		RequestBuilder request;
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setFirstName("Demo");
		customer.setLastName("DEMO");
		customer.setPhone(1234567890);
		customer.setEmail("demo@demo.com");
		
		
		Mockito.when(cat_service.createCustomer(Mockito.any(Customer.class))).thenReturn(customer);
		
		Gson gson = new Gson();
		
		request = MockMvcRequestBuilders
				.post("/create/customer")
				.content(gson.toJson(customer))
				.contentType(MediaType.APPLICATION_JSON);
		
		String expectedResult= "{customerId : 1, firstName : Demo, lastName : DEMO, phone : 1234567890, email : demo@demo.com}";
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isCreated())
				.andExpect(content().json(expectedResult))
				.andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());	
		
	}

}
