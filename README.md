# Orange Labs Web Automation Task

# Google_Play_Test_Automation

### A Test Automation Script that automate the search for a specific application on Google play; the test scenario steps is traced by  a report.

It is a fully automated script the completly automates the process of Searching for a an app on the goole play store , and validating the use of some functionalties 

## what does the script do

Automation testing for searching for an app (TED APP) on  ("https://play.google.com/store")

1-Open Google play website , Assert That the url navigated to the correct website..

2-Select Apps tab from left side menu and assert you are in the correct page. 

3-Click on Category and then Select Education and Assert that you are in the Page

4-Search for TED app by typing in the search bar then clicking search button

5- Press on TED app icon and assert that you are in the page.

6-Genrating customized reports including screenshots and video records for Testcases includes Status (pass/fail) of all test cases 

## Page Object Model (POM)

* This project build based on page object model technique , where each web page in the application, there should be a corresponding Page Class. 
This Page class will identify the WebElements of that web page and also contains Page methods which perform operations on those WebElements.

## Built With
* JAVA                      - Programming Language

* Selenium                  -WebDriver

* TestNG                    -testing framework

* Maven                     -software project management and comprehension tool

* Extent Reporting          -Extent Reporting Framework

* AUTtest Recorder          -Video Recording framework

* No hard coding            - Any used data is provided through config.properties file

## How to use it

- First you have to add AUTtestRecorder jar file to your local repository (Because it doesnot have an online maven dependcy)
  
  * You can find the jar file on the project folder (ATUTestRecorder_2.1.jar) copy the path of the jar file. open the Terminal copy the     below command
  
```
mvn install:install-file -Dfile={Path}/ATUTestRecorder_2.1.jar -DgroupId=org.aut.tm -DartifactId=cxf-bundle -Dversion=2.7.3 -Dpackaging=jar
```
  
- And then just open your command prompt and navigate to the directory where the project files are  , and then type these two command     lines

```
mvn clean
mvn test
```


## Reports
* Report include

- Number of total executed test cases 

- Number of passed TestCases

- Number of Failed TestCases

- Total time taken 

- Pass percentage

- Screen Shots

- Video Records

## Reports Results Samples

<img src="https://imgur.com/GsPZ30h.png" width="80%">


<img src="https://imgur.com/iRK2wqx.png" width="80%">



## TestCases Execution

- https://imgur.com/hZIBT7o

![Imgur](https://i.imgur.com/KsXR7gC.gif)
