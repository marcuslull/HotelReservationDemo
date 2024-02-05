# Hotel Reservation Demo
A Spring Boot, Angular, and dockerized hotel reservation demo application.
* Java (17)
* Maven (3.8.6)
* Spring Boot (parent 2.7.2)
  * Spring Web
  * Spring Data JPA
  * Spring Boot DevTools
  * H2
  * Lombok
* Angular (14.1.0)
* Docker (23.0.5)

![An image of the hotel registration demo app showing the main page of a fictitious hotel and reservation form.](/images/ScreenshotHotel.png "An image of the hotel registration demo app")

## Description
This demonstration app was the final project for an Advanced Java course. It's intended purpose was to show familiarity
with Spring Boot, Angular, and Docker as well as profiles multithreading and internationalization. The application uses
Angular on the frontend and spring web to expose endpoints along with data JPA and an in memory H2 database.  
  
Functionally, the application demonstrates the main page of a fictitious hotel allowing patrons to book a room. Once dates
are chosen the customer is given room options where a room can be reserved. Upon selecting a room for a given date that room
is then removed from the list of available rooms so as not to be presented to another customer.  
  
In addition to the reservation system a couple of demo threads examples are shown which would reflect the chosen language 
of the visitor. The notification section demonstrates time zone conversion.  
  
This application is containerized using Docker and can be run locally. However, some steps are required to generate dependencies
for the first run.

NOT FOR PRODUCTION USE!

## Usage
1. Clone the project to your local machine
2. Update the Angular dependencies by navigating to the src/main/UI folder and running: npm install
3. Package the fat jar by running the Maven package lifecycle
4. Run the docker file.
5. Navigate to http://localhost:8080