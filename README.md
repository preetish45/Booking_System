# Booking_System
All the files used in the framework are placed in the src/test/java folder

 Framework folder structure:
The folder structure for this framework are built based around the below packages
Automation.Booking_System
baseClass
feature
RUtility

Automation.Booking_System :All the test cases are placed in the CucumberTestCases.java file under the Automation.Booking_System package
baseClass:  contains commonMethods.java file and pagePropertiesjava file
 commonMethods.java is used to hold all the common methods used in the test cases thereby increasing code reusability
 pageProperties.java file contains the properties of the elements on the booking.com. A page model approach in order to store the properties for each page.
 
 feature: this package contains the Booking_Testcases.feature file which has all the test cases written in Gherkin language
 
utility: This package contains the testData.java file and TestRunner.java file
The testData.java file is used to hold all the test data used in the test cases
The TestRunner.java file is the file used to run the test cases

Steps to run the test cases:

In order to run the test cases below steps to be followed
Right click on pom.xml and select run as Maven clean and then select run as Maven install- This will install the dependencies for this project
Once the dependcies are downloaded go to the TestRunner.java file located in the utility package and right click on TestRunner.java file
Run as junit test and the test should be able to run.
