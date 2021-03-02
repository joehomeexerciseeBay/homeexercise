# homeexercise
 This is the core service to check whether the seller or the item 
 is eligible to use the new shipping service provided by eBay platform.
 This service also provides admin features to modify the configurable rules.
 
 ## Project clone and setup instructions:
 * Download and unzip the source repository or clone the repository using the command:
 
       git clone https://github.com/joehomeexerciseeBay/homeexercise.git
 
 * Once cloned or unzipped, build project using the gradle wrapper command from /homeexercise folder. You will see a file **gradlew** at this folder location.
 
  * If using git bash or mac terminal or linux terminal use command: 
  
        ./gradlew build
 
  * If using windows cmd prompt use: 
  
        gradlew build
 
 **NOTE**: Tested application in windows and mac but not in linux machine.
 
 build command downloads the dependencies from maven central. Make sure firewall is not blocking access to internet.
 
* After the project is built, use below gradle command to run the springboot application at port 8080:
 
 * If using git bash or mac terminal or linux terminal use command: 
 
       ./gradlew bootRun
 
 * If using windows cmd prompt use: 
 
       gradlew bootRun
 
* Once application is started type the url in a browser:
 
      http://localhost:8080/swagger-ui.html
 
 This will list down the following apis:
 
 ### AdminController
   * /api/admin/enrollsellertoshippingprogram (To enroll a seller to the shipping program)
   * /api/admin/changeminimumprice (Change shipping program's minimum price)
   * /api/admin/addcategorytoshippingprogram (Add a new category to the shipping program
   * /api/admin/getminimumprice (Get Minimum price for an item to be eligible for the shipping program)
   * /api/admin/getallsellers (Get list of all sellers enrolled to the shipping program)
   * /api/admin/getallpreapprovedcategories (Get list of all preapproved categories for the shipping program)
   * /api/admin/dischargesellerfromshippingprogram (Discharge a seller from the shipping program)
   * /api/admin/deletecategoryfromshippingprogram (Delete category from the shipping program)


 ### ItemEligibilityController
   * /api/item/eligible (Check if an item is eligible for the shipping program)

As an alternate these apis can be called directly from browser too.

**NOTE:** I strongly recommend using swagger-ui to have better user experience.

## Database:

Java In-memory h2 database is used. During start up table create scripts are run and sample data set inserted.

## Logging:

slf4j is used for logging. Using AOP the method entry and exit logs are logged to console. All methods are annotated using a custom annotation to achieve this.

## Exception Handling:

Customized ResponseEntityExceptionHandler is created which will handle all application exceptions generated
by the service during request handling.

## Toolset:
 1) JDK 13.0.2. Should be backwards compatible
 2) Spring Boot v2.4.3
 3) Spring v5.3.4
 4) Hibernate v5.4.28 (Spring data JPA defaults to hibernate ORM)
 5) springdoc-openapi-ui v1.5.4 (includes swagger-ui support)

## Documentation:

 swagger-ui
 
## DataModel:
 
 The datamodel has 3 tables
  1) Seller (SellerId and SellerName)
  2) Category (CategoryId and CategoryName)
  3) Price (MinimumPrice)

## System Design:

 Maintained a simple design with Controller, service and repository pattern. DTO pattern used. 2 controller classes created (ItemEligibilityController and AdminController).
 
## Performance:

Since In-memory database is used cache is not implemented. However if a seperate DB is used cache can be implemented to improve performance.

## Maintainability:

Code is modularized and proper class level and method level comments included. Loose coupling of components enables easy modification of code.



   
