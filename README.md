* REST End points

	HomePage
		http://localhost:8080/
		
	Customer:
		http://localhost:8080/create/customer													[Add New Customer]
			Sample Input:
				{
					"firstName":"Demo",
					"lastName":"DEMO",
					"phone":1234567890,
					"email":"demo@demo.com"
				}
				
	Account:
		http://localhost:8080/create/account													[Add New Account]	
			Sample Input:
				{
					"customerId": 1,
					"accounts":[{
						"accountType":"Current",
						"accountBalance":800000.0
					}]
				}
					
		http://localhost:8080/getCustomerById/{id}											[Get Customer & Account Details by ID]
		http://localhost:8080/getCustomer													[Get All Customer & Accounts Details]
		http://localhost:8080/getCustomerByAnyField/FirstName/{fName}						[Get Customer & Account Details by First Name]
		http://localhost:8080/getCustomerByAnyField/LastName/{lName}						[Get Customer & Account Details by Last Name]
		http://localhost:8080/getCustomerByAnyField/Phone/{phone}				   			[Get Customer & Account Details by Phone No.]
		http://localhost:8080/getCustomerByAnyField/Email/{email}							[Get Customer & Account Details by Email]
				
		http://localhost:8080/customer/update												[Edit/Update Customer Details]
		http://localhost:8080/deleteCustomerAccountByID/{id}								[Delete Customer Details By Id]
		http://localhost:8080/deleteCustomerAccount											[Delate All Customer Details]
		http://localhost:8080/account/transfer/{fromAccount}/{toAccount}/{amount}			[Transfer Money From one Account To Another Account If Enough Fund Exist]