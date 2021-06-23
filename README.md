# Employee Directory WebApp in Spring Boot
A web app developed in Spring Boot, and features CRUD operations on a Employee entity, and uses Spring Boot Data JPA for all DB operations.

The application uses *Thymeleaf* as template engine, and also some bootstrap css styles for a simple, yet intuitive web application.

**Update**

Login/logout feature is added recently, using *Spring Security with Thymeleaf*(Thymeleaf Security).  
The app also features showing and hiding some options in list of employees page, based on the logged-in user role.

### Demo of app working in local server

When logging in with different users, the list of employees page shows and hides the options based on the role.
* Can only view list of employees with "Employee" role. 
* Can add and update employee with "Manager" role. 
* Can add, update and delete employee with "Admin" role.  
 
![](https://github.com/Divya0319/employee-dir-webApp-spring-boot/blob/master/screencaptures/different-users-login.gif)  

Adding a new employee, when logged-in with "Manager" role  
![](https://github.com/Divya0319/employee-dir-webApp-spring-boot/blob/master/screencaptures/add-employee.gif)  

      
Updating an employee, when logged-in with "Manager" role  
![](https://github.com/Divya0319/employee-dir-webApp-spring-boot/blob/master/screencaptures/update-employee.gif)  

 Deleting an employee, when logged-in with "Admin" role  
![](https://github.com/Divya0319/employee-dir-webApp-spring-boot/blob/master/screencaptures/delete-employee.gif)  

Access denied to add a new employee, when logged-in with "Employee" role  
![](https://github.com/Divya0319/employee-dir-webApp-spring-boot/blob/master/screencaptures/access-denied-employee-role.gif)
