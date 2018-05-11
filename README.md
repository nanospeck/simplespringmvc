# simplespringmvc
Simple Spring MVC

How the Project was Done
 
I have worked in Spring mvc projects before. So I set up a basic spring with a ‘hello world’ controller first ( no xmls, only annotations and classes ).Then I integrated the json data call into the controller from service layer (first hardcoded and read from a file in local and then made it a url call later. After that I added another controller exclusive for Rest endpoint.

Then I referred  Spring in Action 4.0  book (from manning) to implement spring security and also logout functionality.
Username :admin Passoword :admin
URLS:

Page with list of atms -  http://localhost:8080/BackbaseApp/home Rest endpoint - http://localhost:8080/BackbaseApp/atms?city=ABC
IDE USED:  Eclipse Luna

##INSTRUCTION TO RUN##
I have added an embedded tomcat to the project. Hence, you can run this project directly by running the command:
mvn tomcat7:run

##Overview##

* Create a Java web application based on the standard servlet spec   [DONE]
* The web application should provide a REST api to create a list of ING ATMs in a given Dutch city and return a well formed JSON response  [DONE]
* The web application should invoke an external service to gather a super set of the data: https://www.ing.nl/api/locator/atms/  [  DONE]
* Use Spring and Maven. If you do not have experience in these frameworks, please feel free to use an alternative. [DONE]
Bonus features
* Create a page that shows the list of ING ATMs  [DONE]
* Secure the page with Spring security  [DONE]
* Unit tests using jUnit [ Skipped for now]
