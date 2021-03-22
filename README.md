# AspireTest

## 1. Execute Test
### If run by IDE (recommend)
- Install IntelliJ IDE or another that can run the test (https://www.jetbrains.com/idea/download/#section=windows)
- Open IDE, load libraries by Maven, go to src/test/java/test/, right click on RegistrationTest.java, click Run to run test cases

### For run by Maven
- Install Maven and set environment variable (https://maven.apache.org/download.cgi)
- Open cdm, go to project path and excute command "mvn test"

Note: you can change data in src/test/java/data/userInfo.csv

## 2. Test case flow
1. Register new account, input OTP -> Verify that system redirect to "Register Completed" page
2. Fill user detail, register business -> Verify that system redirect to Identification Verification page
3. Upload image -> Upload success, system redirect to last page

## 3. Project Information
- Project is build in jdk 15, Chrome brower version 89
- UI framework: Selenium
- Test framework: testNG
- Report: ExtentReport
- Page Object Model
- Data Driven: change data in CSV file
- Report: report is exported after execution and store at src/test/java/reports
