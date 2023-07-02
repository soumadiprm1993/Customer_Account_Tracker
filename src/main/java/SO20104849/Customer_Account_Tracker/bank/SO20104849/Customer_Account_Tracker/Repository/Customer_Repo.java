package SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Model.Customer;

@Repository
public interface Customer_Repo  extends JpaRepository<Customer, Integer>{
	
	List<Customer> findByfirstName(String fName);
	List<Customer> findBylastName(String lName);
	List<Customer> findByphone(long l);
	List<Customer> findByemail(String email);

}
