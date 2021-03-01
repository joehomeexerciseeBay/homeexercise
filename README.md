# homeexercise
 This is the core service to check whether the seller or the item 
 is eligible to use the new shipping service provided by eBay platform.
 This service also provides admin features to modify the configurable rules.
 
 Project clone and setup instructions:
 Download and unzip the source repository or clone the repository using the command:
 
 git clone https://github.com/joehomeexerciseeBay/homeexercise.git
 
 Once cloned build project using the gradle wrapper command from /homeexercise folder. You will see a file .gradlew at this folder location.
 
 ./gradlew build
 
 This will download the dependencies from maven central. Make sure firewall is not blocking access to internet.
 
 After the project is built, use below gradle command to run the springboot application at port 8080:
 
 ./gradlew bootRun 
 
 Once succesfully started type the url in a browser:
 
 http://localhost:8080/swagger-ui.html
 
 This will list down the following apis 
 
 AdminController
   1) /api/admin/enrollsellertoshippingprogram (To enroll a seller to the shipping program)
   2) /api/admin/changeminimumprice (Change shipping program's minimum price)
   3) /api/admin/addcategorytoshippingprogram (Add a new category to the shipping program
   4) /api/admin/getminimumprice (Get Minimum price for an item to be eligible for the shipping program)
   5) /api/admin/getallsellers (Get list of all sellers enrolled to the shipping program)
   6) /api/admin/getallpreapprovedcategories (Get list of all preapproved categories for the shipping program)
   7) /api/admin/dischargesellerfromshippingprogram (Discharge a seller from the shipping program)
   8) /api/admin/deletecategoryfromshippingprogram (Delete category from the shipping program)


 ItemEligibilityController
   1) /api/item/eligible (Check if an item is eligible for the shipping program)

As an alternate these apis can be called directly from browser also.
I strongly recommend to use swagger-ui to have better user experience.

Database:

Java In-memory h2 database is used. During start up table create scripts are run and sample data set inserted.

Logging:

slf4j is used for logging. Using AOP the method entry and exit logs are logged to console. All methods are annotated using a custom annotation to achieve this.

Exception Handling:

Customized ResponseEntityExceptionHandler is created which will handle all application exceptions generated
by the service during request handling.


   
