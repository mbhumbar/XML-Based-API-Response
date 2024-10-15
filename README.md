Take Request as JSON fomrat and sent the response as XML Fomrat 

Following are the steps to convert JSON Request into the XML Format. 


#1. add the following dependency in the pom.xml file
   <!-- Jackson Dependency for JSON -->
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
		</dependency>

		<dependency>
			<groupId>com.fasterxml.jackson.dataformat</groupId>
			<artifactId>jackson-dataformat-xml</artifactId>
		</dependency>
		<dependency>
			<groupId>com.fasterxml.jackson.dataformat</groupId>
			<artifactId>jackson-dataformat-xml</artifactId>
		</dependency>

2. create request class and response class
   public class UserRequest {
    private int userId;
    private String name;
    private int age;
    private String email;

  } 
  @JacksonXmlRootElement(localName = "response")
  public class UserResponse {
    private String status
    private int userId;
    private String name;
    private int age;
    private String email;
  }

genereate getter and setter method for the above classes.

3. create the restController class and add the following method
@RestController
public class UserController {

    @GetMapping("/")
    public String showMessage() {
        return "this is the spring boot application";
    }

    // accept JSON and return XML
    @PostMapping(value = "/user",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public UserResponse getUserInfo(@RequestBody UserRequest userRequest) {
        //create response based on the request data
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(userRequest.getUserId());
        userResponse.setStatus("success");
        userResponse.setEmail(userRequest.getEmail());
        userResponse.setAge(userRequest.getAge());
        userResponse.setName(userRequest.getName());
        return userResponse;
    }
}

Result: 
Request
{
  "userId": 12345,
  "name": "Anil",
  "age": 28,
  "email": "anil@gmail.com"
}

Reponse: 
<response>
    <status>success</status>
    <userId>12345</userId>
    <name>anil</name>
    <age>28</age>
    <email>anil@gmail.com</email>
</response>


