#Project Title PeakWorkChallenge application

The main purpose of the application to store and get information about place:

There are 3 microservices:

#Services Description
1)coordinator-resolver-service
Get coordinates from third party "Nominatim" app() and push them to "pubsub"
api http://localhost:8080/reverse?lat={coordinate_One}?lot={coordinate_two}

2)inspector-service
http://localhost:8081 without api
give messages from "pubsub" with fixing intervals and save them to Database

3)searcher-service
give messages by Country from database
http://localhost:8082/searcher/{country}

#Deployment
"coordinator-resolver-service" is deployed to GCP using kubernetes cluster.
you can use it directly with the link: 
http://35.239.242.195:8085/reverse/?lat=60.229900&lon=11.166300

#What is needed to finish
What is needed for production:
1)Integrations Tests from developer side.
2)Swagger don't configure.
3)need to change variables in application.properties for production account
4)need to deploy on GCP other two microservices
5)need to code review from other developer.


#Author Slesar Alexander
