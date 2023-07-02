package SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SO20104849.Customer_Account_Tracker.bank.SO20104849.Customer_Account_Tracker.Model.Account;

@Repository
public interface Account_Repo extends JpaRepository<Account, Long>{

}
