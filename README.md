# Booleans - Guide for Final Project

## Website

- Click [HERE](https://booleans-final-webapp.herokuapp.com/) to access the website for the Final Project.
- Click [HERE](https://booleans-website.herokuapp.com/) to access the website for the Mini Labs. (This website is also linked within the Final Project website.)
![image](https://user-images.githubusercontent.com/71394490/121955760-2e510100-cd15-11eb-959e-a8a4ef93598f.png)

## Project Plan

Click [here](https://docs.google.com/document/d/1_egHgpKx7FtzuqQB7QGcD1Rdo_Stov1bfvrn3Qzmf-4/edit?usp=sharing) to access the Booleans' Project Plan.

## IMPORTANT VIDEOS - PLEASE WATCH

- [Video- README OVERVIEW](https://drive.google.com/file/d/1OQCaiv97v1ktgTIg-wIIiwx8G4MBMupi/view?usp=sharing) (Watch this video BEFORE DOING ANYTHING ELSE to make it easier to review our project!)
- [Video - How It's Made](https://drive.google.com/file/d/1ptYBPoI1IACoIhgClX-U3eWJB8clpEs2/view?usp=sharing)
- [Video - Task Manager Application Demonstration](https://drive.google.com/file/d/1rxTxYQyPzfnBiotH_6NXh3-tJcouQ0mi/view?usp=sharing)

## Other Repositories Used

NOTE: We used other repositories to make the organization of our project much easier.

- [Calculator Repository](https://github.com/AdityaS1426/SpringBootCalculator)
- [Calendar Generator Repository](https://github.com/AdityaS1426/CalendarSetUpTest)
- [Task Manager Repository](https://github.com/AdityaS1426/TaskManager)

## Theme

As high school students with constant work, it's no surprise we struggle to find the tools we need to succeed or stay organized on a daily basis. So, our team, the Booleans, decided to combat such an issue through the creation of a website. This website aims to help students go through their daily lives with ease. Students will be able to access a calculator, view a calendar, generate tasks to keep track of their work, etc.

## Key User Interactions

###### User Interactions for Task Manager

- The user has the option to choose which type of user to log in as. (Admin or Regular User)
![image](https://user-images.githubusercontent.com/71394490/121964863-05366d80-cd21-11eb-94dd-d6391438b917.png)
- As an admin, the use can make certain decisions, like viewing a list of tasks, viewing a list of users, asigning a task, creating a new task, etc.
![image](https://user-images.githubusercontent.com/71394490/121965159-78d87a80-cd21-11eb-857a-018d9b2440aa.png)
- As a regular user, there are less decisions possible. Thes include viewing the list of tasks, viewing a list of users, creating a new task, etc.
![image](https://user-images.githubusercontent.com/71394490/121965488-f1d7d200-cd21-11eb-9fad-6139053a8d68.png)
- The user can click on Check Boxes to determine the completion of a task. If logged in as a regular user, the user can only check the boxes pertaining to their assigned tasks. (Since I'm logged in as Ann, a regular user, I can only check the box that corresponds with the task I'm responsible for.)
![image](https://user-images.githubusercontent.com/71394490/121965750-5dba3a80-cd22-11eb-934e-b859203566e3.png)
- However, the admin can check boxes for any task, as seen below.
![image](https://user-images.githubusercontent.com/71394490/121965843-86423480-cd22-11eb-8a14-e87ad6528a6f.png)
- The user can enter a task of their choosing into the fields in the "Create a New Task" option. They can enter a name, enter a description, set a date, etc.
![image](https://user-images.githubusercontent.com/71394490/121974448-3bc9b380-cd34-11eb-800b-19d796c019b1.png)

###### User Interactions for Calculator

- The user can choose to input any number into the fields provided.
- The user has various options to perform calculations, including Addition, Subtraction, Multiplication, Division, Fibonacci, Factorial, Square Root, & Power.
- The user has the option to Clear the fields.
![image](https://user-images.githubusercontent.com/71394490/121974774-fce82d80-cd34-11eb-8519-f8c7f2047e2d.png)

###### User Interactions for Calendar Generator

- The user can choose any year to input into the text field at the top. A corresponding calendar will be generated.
![image](https://user-images.githubusercontent.com/71394490/121974917-551f2f80-cd35-11eb-88c0-cf1d78d57b65.png)
- The date/day of the week of important holidays occurring in the user-inputted year will also be generated above the calendar.
![image](https://user-images.githubusercontent.com/71394490/121975003-85ff6480-cd35-11eb-8194-1f44c0c13232.png)

## Technicals for Project

- HOW IT WAS MADE

  - Spring Boot - The basic framework that allows our website to run.
  - Spring Security - Provides security for our application through the use of user-created accounts with passwords.
  - H2 Database - This is the type of database containing all the data for our application, from the profile information of the users to the tasks themselves.
  - Maven - This is the basic tool allowing us to create the web application.
  - Thymeleaf - This helps us format our application to look visually appealing. It's essential for the front-end aspect.
  - Bootstrap - Like Thymeleaf above, Bootstrap is primarily responsible for the front-end, but its focus is on the stylistic aspects.
  - jQuery - This framework makes it extremely simple to implement JavaScrip code in the applicatiion.

###### Technicals for Task Manager

- Click [HERE](https://drive.google.com/file/d/1rxTxYQyPzfnBiotH_6NXh3-tJcouQ0mi/view?usp=sharing) to watch the Demonstration Video for the Task Manager application portion of our website.
- We have a Security Configuration for the application, which is responsible for storing the Usernames & Passwords of the users. Via this file's use, the application will stay secure. Click [HERE](https://github.com/AdityaS1426/TaskManager/blob/master/src/main/java/com/booleans/taskmanagement/configuration/SecurityConfiguration.java) to access the code for this feature.
- We have various controllers for this application, but a couple of the most important controllers take care of the "Assign Tasks" feature of the application, the "Task List" portion of the application, & the "User List" portion of the application. Click [HERE](https://github.com/AdityaS1426/TaskManager/blob/master/src/main/java/com/booleans/taskmanagement/controller/AssignmentController.java) to view the code for the AssignmentController. Click [HERE](https://github.com/AdityaS1426/TaskManager/blob/master/src/main/java/com/booleans/taskmanagement/controller/TaskController.java) to view the code for the TaskController. Click [HERE](https://github.com/AdityaS1426/TaskManager/blob/master/src/main/java/com/booleans/taskmanagement/controller/UserController.java) to view the code for the UserController. (NOTE: As mentioned above, we have various other controllers which follow a similar format as the ones mentioned here. The other controllers can be found in the corresponding repositories.)
- We have a Java class containing the default data for the application. It contains all of the existing tasks, the descriptions of the tasks, the dates for the tasks, etc. It also includes information about the Users, such as profile information, their names, etc. Click [HERE](https://github.com/AdityaS1426/TaskManager/blob/master/src/main/java/com/booleans/taskmanagement/dataloader/InitialDataLoader.java) to view the code.
- We have Java files representing the Model aspect of our application's MVC structure, including [Role.java](https://github.com/AdityaS1426/TaskManager/blob/master/src/main/java/com/booleans/taskmanagement/model/Role.java), [Task.java](https://github.com/AdityaS1426/TaskManager/blob/master/src/main/java/com/booleans/taskmanagement/model/Task.java), & [User.java](https://github.com/AdityaS1426/TaskManager/blob/master/src/main/java/com/booleans/taskmanagement/model/User.java). These files contain the logic for the "Type of User" system for the application. (Admin vs. Regular User)
- We have Java "Repository" files that are in charge of storing the data the application will access from the web. These include [RoleRepository.java](https://github.com/AdityaS1426/TaskManager/blob/master/src/main/java/com/booleans/taskmanagement/repository/RoleRepository.java), [TaskRepository.java](https://github.com/AdityaS1426/TaskManager/blob/master/src/main/java/com/booleans/taskmanagement/repository/TaskRepository.java), & [UserRepository.java](https://github.com/AdityaS1426/TaskManager/blob/master/src/main/java/com/booleans/taskmanagement/repository/UserRepository.java).
- We have various ["Service" files](https://github.com/AdityaS1426/TaskManager/tree/master/src/main/java/com/booleans/taskmanagement/service), which are responsible for maintaining the security of the data, implementing the data correctly, managing the roles, etc.
- In order to make the CSS formatting for the Task Manager Application look professional, we used a Bootstrap template found on W3Schools. We modified the template in order to fit our needs. Click [HERE](https://github.com/AdityaS1426/TaskManager/blob/master/src/main/resources/static/css/flatly/bootstrap.css) to view the code.
- We created another CSS file for the miscellaneous portions on the application that the template did not account for. Click [HERE](https://github.com/AdityaS1426/TaskManager/blob/master/src/main/resources/static/css/mystyle.css) to view the code, in CSS.
- A JS file was created in order to formulate Widget Behavior/Ajax Controller Functionality to the application. Click [HERE](https://github.com/AdityaS1426/TaskManager/blob/master/src/main/resources/static/js/main.js) to view the code, in JS.
- Code was written in HTML to make the basic formatting for various forms on the application, such as the [Assignment Page](https://github.com/AdityaS1426/TaskManager/blob/master/src/main/resources/templates/forms/assignment.html), the [Task Editor Page](https://github.com/AdityaS1426/TaskManager/blob/master/src/main/resources/templates/forms/task-edit.html), & the [Create New Task Page](https://github.com/AdityaS1426/TaskManager/blob/master/src/main/resources/templates/forms/task-new.html). There are many other HTML files in the corresponding repository that follow a similar format to the ones linked here.

###### Technicals for Calculator

- There's a CalculatorController, which controls the mapping for the various different calculator functions. Click [HERE](https://github.com/AdityaS1426/SpringBootCalculator/blob/master/src/main/java/com/calculator/debugdatabandits/controllers/CalculatorController.java) to view the code.
- The OperationModel sets up the User Input fields for both the Simple & the Advanced Calculator. Click [HERE](https://github.com/AdityaS1426/SpringBootCalculator/blob/master/src/main/java/com/calculator/debugdatabandits/model/OperationModel.java) to view the code.
- The CalculateSimple.java file contains the logic for the functions in the calculator. Click [HERE](https://github.com/AdityaS1426/SpringBootCalculator/blob/master/src/main/java/com/calculator/debugdatabandits/service/CalculateSimple.java) to view the code.
- Finally, there's an HTML file that sets up the page layout for the Spring Boot Calculator, with fields for the user to enter values, the buttons for the various functions, & the display of the result. Click [HERE](https://github.com/AdityaS1426/SpringBootCalculator/blob/master/src/main/resources/templates/Calculator.html) to view the code.

###### Technicals for Calendar Generator

- The Date.java file was used to implement the algorithm for the correct dates to be set for each year. Click [HERE](https://github.com/AdityaS1426/BooleansCalendar/blob/master/src/main/java/com/booleans/calendar/Date.java) to see the Java algorithm/code for the dates of each year.
- A controller for the application, with a default set to the year 2021, along with mapping for user-inputted years, was created. Click [HERE](https://github.com/AdityaS1426/BooleansCalendar/blob/master/src/main/java/com/booleans/calendar/CalendarController.java#L14-L79) to view the code, in Java, for this functionality. Hash Maps/2D Arrays are used to format the dates.
- Exceptions of the algorithm to account for the holidays were implemented in the controller. Click [HERE](https://github.com/AdityaS1426/BooleansCalendar/blob/master/src/main/java/com/booleans/calendar/CalendarController.java#L81-L121) to view the code, in Java, for the holidays.
- HTML code was created to format the Calendar Generator, with a user-input form, bullet list of holidays, & tables to represent each month of the year. Click [HERE](https://github.com/AdityaS1426/BooleansCalendar/blob/master/src/main/resources/templates/calendar.html) to view the code, in HTML.
- Some basic CSS formatting was done to make the application appealing to the eye. Click [HERE](https://github.com/AdityaS1426/BooleansCalendar/blob/master/src/main/resources/static/styles.css) to view the CSS code.

## Back-End Database

- An H2 Database was primarily utilized for the Task Manager Application, with IntelliJ's built-in functionality.
- [Role.java](https://github.com/AdityaS1426/TaskManager/blob/master/src/main/java/com/booleans/taskmanagement/model/Role.java), [Task.java](https://github.com/AdityaS1426/TaskManager/blob/master/src/main/java/com/booleans/taskmanagement/model/Task.java), & [User.java](https://github.com/AdityaS1426/TaskManager/blob/master/src/main/java/com/booleans/taskmanagement/model/User.java) are part of the Model in MVC framework, so they're responsible for setting up the various columns in the tables contained within the database.
- [InitialDataLoader.java](https://github.com/AdityaS1426/TaskManager/blob/master/src/main/java/com/booleans/taskmanagement/dataloader/InitialDataLoader.java) is responsible for implementing the default data to be displayed in the Task Manager Application.
- The above allow for the presence of the "Task List" & "User List" in the Task Manager Application, like seen in the picture below.
![image](https://user-images.githubusercontent.com/71394490/122083780-036ab980-cdb6-11eb-8ee9-880f91341e13.png)

## Something Fun the User Can Do on the Website

- The user can visit our [Calendar Generator](https://calendar-set-up-test.herokuapp.com/).
- They can enter the year in which they were born.
- They can find the day of their birth to figure out which day of the week they were born!

## Mini Labs - How to Access

- Our Mini Labs can be accessed by clicking on the "Mini Labs" tab on the "navigation bar" at the top of our [Project Website](https://booleans-final-webapp.herokuapp.com/) or by directly accessing the [Mini Labs Website](https://booleans-website.herokuapp.com/labs).
- After reaching the Mini Labs Website, hover the mouse over each team member's name to see a drop-down list of the various Mini Labs. These can be clicked to be accessed.

NOTE: All of the labs below can also be accessed from the Mini Labs Website. They were linked here for Mr. M's grading convenience.

###### Neil Sahai's Mini Labs

- [Factorials!](https://booleans-website.herokuapp.com/labs/Neil/dafact)
- [Inheritance](https://booleans-website.herokuapp.com/labs/Neil/inheritance)
- [3 Sorts](https://booleans-website.herokuapp.com/labs/Neil/Sorts)
- [Linked List](https://booleans-website.herokuapp.com/labs/Neil/LinkedList)

###### Praveen Natarajan's Mini Labs

- [Factorial](https://booleans-website.herokuapp.com/labs/Praveen/dafact)
- [Car Inheritance](https://booleans-website.herokuapp.com/labs/Praveen/Car)
- [Sorts](https://sortcsa.herokuapp.com/)
- [LinkedList](https://booleans-website.herokuapp.com/labs/Praveen/LinkedList)

###### Aditya Surapaneni's Mini Labs

- [Recursion](https://spring-boot-calculator.herokuapp.com/calculator)
- [Inheritance](https://inheritance-lab.herokuapp.com/inheritance)
- [Sorts](https://sort-lab.herokuapp.com/sort)
- [LinkedList](https://linked-list-lab.herokuapp.com/linked-list)

###### Yasaswi Singamneni's Mini Labs

- [Recursion](https://java-minilab.herokuapp.com/calculator)
- [Sorts](https://csa-sorts.herokuapp.com/)
- [LinkedList](https://booleans-website.herokuapp.com/labs/Yasaswi/LinkedList)

###### Vihan Jayaraman's Mini Labs

- [Recursion - Frog River](https://booleans-website.herokuapp.com/labs/Vihan/RiverRecursion)
- [Sorts](https://booleans-website.herokuapp.com/labs/Vihan/Sorts)
- [Inheritance](https://booleans-website.herokuapp.com/labs/Vihan/Inheritance)

## Mini Labs - Code Modeling/Technicals

###### Aditya Surapaneni

- Click [HERE](https://github.com/AdityaS1426/BooleansCalendar/issues/51) to view the technicals of my Mini Labs. It leads to an Issue, which contains explanations of technicals/links to imporant code for each of my Mini Labs. The MVC framework for each of my Mini Labs is also explained.

## Journals and Project Credits
Contributor | GitHub Link | 
----------- | ----------- |
Neil Sahai | [@Neil-Sahai](https://github.com/Neil-Sahai) | 
Aditya Supraneni | [@AdityaS1426](https://github.com/AdityaS1426) | 
Praveen Natarajan | [@PNatarajan123](https://github.com/PNatarajan123) | 
Yasaswi Singamneni | [@YasaswiS](https://github.com/YasaswiS) |
Vihan Jayaraman | [@VihanJ](https://github.com/VihanJ) |
