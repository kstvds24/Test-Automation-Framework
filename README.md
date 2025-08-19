# Java Test Automation Framework

This is a Java-based Test Automation Framework. 

The framework is designed for scalability, maintainability, and ease of execution. 

It supports data-driven testing, cloud execution with LambdaTest, and generates detailed Extent Reports and Log4j logs.


## 🚀 About Me
Hi, My name is Kaustav Das and I have 10 years of experience in Automation Testing using technologies like Selenium WebDriver, RestAssured, Appium.

My major expertise is in java programming language.


## Authors

- [@kstvds24](https://github.com/kstvds24)
- Email Address: kstvds61@gmail.com


## 🔗 Links

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/kaustav-das-200710116/)



## Prerequisites

Before running this framework ensure the following software is installed in your system

- Java11 - Make sure Java is installed in your system and the JAVA_HOME variable is set
- Maven - Make sure Maven is installed in your system and added to the system path
- Download Link: https://maven.apache.org/download.cgi


Features

✅ Cross-browser testing (Chrome, Firefox, Edge, etc.)

✅ Run tests locally or on LambdaTest

✅ Headless execution for faster test runs

✅ Data-driven tests using CSV/Excel/JSON

✅ Centralized logging with Log4j

✅ Interactive ExtentReports (report.html)

✅ Easy execution via Maven CLI with parameters



🚀 Tech Stack

Language: Java 11

Test Framework: TestNG

Build Tool: Maven

Data Handling:

OpenCSV – CSV-based data-driven testing

Gson – JSON parsing

Apache POI – Excel support

Java Faker – Fake test data generation

Logging & Reporting:

Log4j – Logging

ExtentReports – Test execution reports

Cloud Execution: LambdaTest

Headless Mode: Enabled for faster execution


## Setup Instructions

**Clone the Repository:**

```bash
   git clone https://github.com/kstvds24/Test-Automation-Framework.git

   cd Test-Automation-Framework
  
```

**Running tests on Lambda Test:**

```bash
   mvn clean test -Dbrowser=chrome -DisHeadLess=true -DisLambdaTest=true -X
  
```

**Running tests on Chrome Browser on Local Machine in Headless Mode:**

```bash
   mvn clean test -Dbrowser=chrome -DisHeadLess=true -DisLambdaTest=false -X
  
```

📊 Reports & Logs

After execution, you will find:

Extent Report: /report.html

Logs: inside logs/ directory

Open report.html in a browser for a detailed execution summary.

## Integrated the Project with Github Actions
This Automation Framework is Integrated with Github Actions
This tests will execute automatically at 11:30PM IST every single day
The Reports will be archived in gh-pages branch
You can view the html report at:
https://kstvds24.github.io/Test-Automation-Framework/report.html
