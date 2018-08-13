
Solution : 

List of Tables Created - Used Spring H2 -InMemoryDatabase : After starting the project open localhost:8080/h2 to view the database 

1) CAR - To get the details of the car . Endpoints to get the car by ID and get the complete list of cars 
   -- If the status of the car is available , users can select and bid for the car 
     CAR ID will be the primary key 

2) CUSTOMERS - To maintain the list of customers details. Enpoints to add , update or delete the customers . 
     CUSTOMER ID will be the primary key 

3) BID - To maintain the bid details after the user posts the bid .
     BID ID will be the primary key 



List of Endpoints :

1) /customers/addCustomer -> Add a new customer 

2) /customers/updateCustomer --> Update a new customer 

3) /customers/deleteCustomer --> delete a customer 

4) /car (GET) --> Get complete list of cars with the status 

5)/car/avaiable/{availability} --> Get the list of cars by status 

6) /car (POST) --> add a car 

7) /car/{id} ---> get a car by ID 

8) /bidding/postBid --> Post a bid on a car 

9) /bidding/bidId --> Get the bid response based on bid ID 

10) /bidding/cardID/status ->change the status of the CAR from available to sold 

11) /bidding/hightest/carID --> get the highest bid 



	 



