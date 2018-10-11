# teach-tony-sb
Teach tony spring boot and other stuff

## CRUD Homework

Tony I want you to implement a rest based server for storing course information for a school.  Right now we will hardcode the school id to 1.

Right now a course will have a subject and a room number.  Both can be stored as strings for now. The rest endpoints you need to implement are:

```
POST /school/1/course

input json examle:
{
	"subject": "Science",
	"room": "100"
}

output json example:
{
	"courseId": 5,
	"schoolId": 1,
	"subject": "Science",
	"room": "100"
}
```

```
GET /school/1/course/{courseId}

No input json

output json example:
{
	"courseId": 5,
	"schoolId": 1,
	"subject": "Science",
	"room": "100"
}
```

```
Put /school/1/course/{courseId}

input json example:
{
	"courseId": 5,
	"schoolId": 1,
	"subject": "Science",
	"room": "100"
}

no output json
```

```
Delete /school/1/course/{courseId}

no input json

no output json
```
The above rest endpoints should be defined in a controller (like the DemoController).  You will need to create a courseDTO object that matches the above json.  Look at our previous demo examples using the DemoDTO.  The courseDTO will need to be converted to a course entity object for you to store the data in the database.


You will need to write sql to create a database table to store this information.  Look at the schema.sql script under src/main/resources.  You will need to make an entity object that matches the columns in the database table.  Look at the src/main/java/com/icims/tony/demo/DemoEntity and the existing demo table to see how this works.  You will also need to create a repository class the same way we did with the DemoRepository.
NOTE: The schema.sql script will run every time at server startup.  You can either have it delete and re-create your database table every time its run, or ignore it if its already created.  I leave that to you, though one might make more sense than the other depending on what stage of development you are at the time.


To get started I recommend creating a new package under src/main/java and calling it com.icims.tony.school.  Create packages for your different class types the same way we did for demo (you will at least need controller, dto, entities, and repositories for this).  Your goal is to get the test DemoApplicationTest under src/test/java/com/icims/tony/demo to fully pass (assuming I wrote everything correctly).  You can run the test by right clicking the class and selecting run as junit, the console should provide the output of what occured.  Don't forget to start up your docker containers before running the test! And you can always manually test the server by using postman to hit the api endpoints and running : ./mvnw spring-boot:run from powershell to start the server.

