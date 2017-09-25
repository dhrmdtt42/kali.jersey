Problem Statement
An object store accessible via REST APIs.

Project Description:-
This is an REST Web Service project in which Data can be accessed or modified via REST API of jersey from the database. A user can request through single URL to the server and server will send the response with HTTP status and data will be JSON format.
Tools for Implementation of Project:-
•	Eclipse
•	 Postman (which is a REST client where a user can send request (GET, POST, PUT, DELETE) through URL)

Implementation of Project:-
First, create a server run time for Tomcat 8.0 on Eclipse. This is the Web container for your RESTful Web application. Then create a dynamic Web application named "Jersey," and specify the target run time to be Tomcat 8.0.  
Now that you have set up the environment you are ready to develop your first REST service, which simply says "Hello" to the client.
To do this, you need to direct all the REST requests to the Jersey container by defining a servlet dispatcher in the application's web.xml file. Besides declaring the Jersey servlet, it also defines an initialization parameter indicating the Java package that contains the resources.

Project Configuration:-
   -> Data Base Configuration
         In package (kali.jersey) we have a database connection class in which we have to configure the database by database connection          URL and password.
         for example ("jdbc:mysql://localhost:9001/frshep","root","8778")
         after that we have to create a table in database named "user_details", in user_details table we have to create two column named            "name" and "pass"
   -> after database connection we have to make a "war" file by "maven install" for deploying the project on server(could be jetty, apache tomcat)
 
 
 
Communicating URL’s:

Request

http://localhost:8080/jersey/webapi/register (to register new user)
calling http method and data attached with URL : method Post, data ("name":"dharam","pass":"9879sflkh")

Response

  if registration successfull then user will get HTTP status 202 and registerd
  if registration unsuccessfull then user will get HTTP status 402 not registerd



Request


•http://localhost:8080/jersey/webapi/retrive
 calling http method and data attached with URL : method Get, data ("name":"dharam","pass":"9879sflkh")
 
 Response
 
 
  if data found successfully then user will get ("name":"dharam","pass":"9879sflkh")
  if retrieval unsuccessfully then user will get HTTP status 404 user does not exist.
  


Request


•http://localhost:8080/jersey/webapi/update
 calling http method and data attached with URL : method Post, data ("name":"dharam","pass":"9879sflkh", "newUserName":"sanju","pass":"9865sdfa")
 for deletion we provide same data via post method, data ("name":"dharam","pass":"9879sflkh")
 
 Response
 
 if data found successfully then user will get updated data("name":"sanju","pass":"9865sdfa") and with message Successfully updatedor Deleted.
 if  unsuccessfull then user will get HTTP status 404 user does not exist.
  
  

