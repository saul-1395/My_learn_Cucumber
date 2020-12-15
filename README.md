# Training project for testing web applications with using the  *"PageObject"* pattern.

## Applied technology:

##### <li>language: Java

##### <li>build automation tool: Maven

##### <li>frameworks: JUnit, Cucumber

##### <li>libraries: lombok, REST-assured

##### <li>testing website: <https://test.grinfer.com>


### This example shows how  BDD approach is implemented in testing. In this example used scenario described in features:

```Gherkin
Feature: Log In

  Scenario: Create user

    Then open "sign-up" page
    Then Click "Start Learning" button
    Then Input email
    Then Input first name
    Then Input last name
    Then Input password
    Then Click "Start Learning" button span
    Then Content "Start Teaching" button visible
    Then Check firstName field
    Then Check lastName field

  Scenario: Create user by Api
    Then Create user by api
    Then Login user by api
```  
#### Following the ***"Create user"*** scenario, the process of registering a new user is checked via the graphical interface. This test uses ***"PageObject"*** pattern. A page is an object that the program works with.

```Java
public class SigninPage {
    private SelenideElement loginInput = $(By.cssSelector("#email"));
    private SelenideElement passwordInput = $(By.cssSelector("#password"));
    private SelenideElement firstNameInput = $(By.cssSelector("#firstName"));
    private SelenideElement lastNameInput = $(By.cssSelector("#lastName"));
    private SelenideElement formFirstName = $(By.cssSelector("#form_firstName"));
    private SelenideElement formLastName = $(By.cssSelector("#form_lastName"));

    public void loginInput(String login) {        
        this.loginInput.val(login);
    }

    public void passwordInput(String password) {
        this.passwordInput.val(password);
    }

    public void firstNameInput(String firstName) {
        this.firstNameInput.val(firstName);
    }

    public void flastNameInput(String lastName) {        
        this.lastNameInput.val(lastName);
    }

    public String getFirstname(){
        return  formFirstName.getValue();
    }

    public String getLastname(){
        return  formLastName.getValue();
    }

}
```

#### But ***"Create user by Api"*** doesn't use GUI, for this reason this test run faster.

```Java
 public class AuthServiceImpl implements AuthService {
      
     @Override
     public User createUser(User user) {
         String url = "https://test.grinfer.com/api/auth/create";
         System.out.println(url);
         Response r = given().
                 contentType(ContentType.JSON).  
                 body(user).                     
                 post(url);                      
 
         if (r.statusCode() == 200) {
              return r.as(User.class);             
         }
         return null;
     }
 }

```
