# Flink-Test-Automation-Framework

## About 
###### This Test Automation framework is design to test all UI web applications based on selenium 4.0
###### it Support test excution using Chrome , Edge and Firefox 
###### it support parallel test execution
###### it Support reading data frome external files (JSON, Properties)
###### it support browser configuration easly
###### By Khaled M. Farh, Software Test Automation Engineer For Flink QA Task
###### E-mail: Khaled.Farh@gmail.com

## Frameworks inside  
###### Selnium - TestNG -  Web Driver Manager - Json Simple - Log4j

## The Framework Design Patterns
###### In this Framework I have used java and test automation design patterns to produce a clear, readable, reliable and reusable framework 
###### mainly I used SOLID principles beside Fluent Builder design pattern, Factory Design pattern and finally page object patterns

## The Framework Structure 
![alt text](https://i.ibb.co/9cFYDWb/Php-Travel.png)

## How To use the framework 
###### 1. clone the project and open it using any IDE 
###### 2. Make sure to have JAVA 8+ 
###### 3. Make sure to insall Chrome, Edge and Firefox
###### 4. Navaigate to:  src/test/java/org/uiframework/weathershoppertests/TestBase.java in the project to configure the tests
###### 5. By using the configuration paramter : 
          * Configure the browser type by: .setBrowser(BrowserType.EDGE) its an enum change it 
          * Configure the browser size by: .setBrowserCustomDimensions(BrowserSize.MAX) for Max or Min or By: setBrowserCustomDimensions(BrowserWidth,BrowserHeight)
          * Configure the browser mode by: .setWindowType(ExecutionPrivacy.PUBLIC) Pbulic/Private for incognoito mode
          * Configure the browser mode by: .setWindowType(ExecutionPrivacy.PUBLIC) Pbulic/Private for incognoito mode
          * Configure the execution mode by: .setExecutionMode(ExecutionMode.HEADFULL) HEADFULL/HEADLESS for silent execution
###### 6.Test classes: src/test/java/org/uiframework/testsuites/weathershoppertests
        * The tests are dsigned in POM module so each page has its owen test class as well as we have an E2E class wich contains the assgined task. 
   
###### 7. Test Suite: src/test/java/org/uiframework/testsuites/testng.xml 
        * as i am using the testng i created the test suite using testng.xml with parrall execution and i integrated it with maven POM
        * so, you can execute the suite by reight click and run or by maven command nvm test




