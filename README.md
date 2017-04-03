This is REST project based on JDK 8 with out using SRPING. 
It uses :
- Jetty from command line (main() method), 
- Jersey (JAX-RS), 
- Hibernate, 
- H2 database in memory, 
- maven, 
- JUnit & Jersey test framework for testing REST.
- Logback-classic

It was created in Eclipse Neon 3 as maven project.

Logging level is TRACE. You can change it if u need in the logback.xml file.
	
Building: 
You need maven. I use version 3.3.9.
> mvn clean install 

How to run project: 

> java -jar RestTest-0.0.1-SNAPSHOT.jar


Server starts at http://localhost:8888
Status page http://localhost:8888/status 

REST interfaces : 

GET http://localhost:8888/user/{id}

PUT http://localhost:8888/user/add/{id}/{money} 

PUT http://localhost:8888/user/move/{idFrom}/{money}/{idTo} 
	
 # revolut

 mailto: abn.java _AT_ gmail _dot- com