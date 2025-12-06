

<img alt="demoqa" src="media/logos/demoqa-logo.webp" width="50%" >

## **[DemoQA](https://demoqa.com/automation-practice-form) automation project**


## Content:

- <a href="#tools"> Tools used</a>
- <a href="#cases"> Test Cases</a>
- <a href="#autotests"> Running autotests</a>
- <a href="#jenkins"> Jenkins Build</a>
- <a href="#allureReport"> Example of Allure Report</a>
- <a href="#allure"> Integration with Allure TestOps</a>
- <a href="#jira"> Integration with Jira</a>
- <a href="#telegram"> Telegram notifications</a>
- <a href="#video"> Video Example of Running Tests in Selenoid</a>

____

<a id="tools"></a>
## Tools used

  <p align="center">
<img width="7%" title="Java" src="media/icons/java-original.svg">
<img width="7%" title="gradle" src="media/icons/gradle-original.svg">
<img width="7%" title="JUnit5" src="media/icons/JUnit5.svg">
<img width="7%" title="intellij" src="media/icons/intellij-original.svg">
<img width="7%" title="Selenide" src="media/icons/Selenide.svg">
<img width="7%" title="Selenoid" src="media/icons/Selenoid.svg">
<img width="7%" title="Allure" src="media/icons/Allure.svg">
<img width="7%" title="AllureTestOps" src="media/icons/AllureTestOps.svg">
<img width="7%" title="GitHub" src="media/icons/GitHub.svg">
<img width="7%" title="Jira" src="media/icons/Jira.svg">
<img width="7%" title="Jenkins" src="media/icons/Jenkins.svg">
<img width="7%" title="Telegram" src="media/icons/Telegram.svg">

---

The tests are written in the <code>Java</code> language using the [Selenide](https://selenide.org/) testing framework, and the build tool is <code>Gradle</code>.

<code>JUnit 5</code> is employed as the framework for modular testing. [Selenoid](https://aerokube.com/selenoid/) is used to run tests remotely.

Tests can be run remotely from <code>Jenkins</code>. After the test run is completed, a report is generated in Allure and sends the results to <code>Telegram</code> using a bot. Integration with <code>Allure TestOps</code> and <code>Jira</code> is also implemented.

Contents of the Allure report for each test case include:

* Test steps and the results of their execution.
* A screenshot of the page on the last step (providing a visual analysis of test failure reasons).
* Page Source (allowing to open the page source in a new tab to investigate the cause of test failure).
* Browser console logs.
* Video recording of the test execution.

---
<a id="cases"></a>
## :male_detective: Test Cases

Automated tests:
* Verify successful registration with minimal data
* Verify that user cannot submit form with short phone number
* Verify successful registration in the form
* Verify that user can select multiple subjects
* Verify that registration fails without a phone number

Manual test:
* Validation of Mandatory Fields on Practice Form
* Validate that the Mobile Number field does not accept non-numeric characters



---
<a id="autotests"></a>
## :arrow_forward: Running autotests

### Running autotests from the terminal

#### Local run from the project root directory
Сommand for running positive cases:
```
gradle clean positive_test 
```
Сommand for running negative cases:
```
gradle clean negative_test 
```
Сommand for running all cases:
```
gradle clean all_tests 
```

---
<a id="jenkins"></a>
## <img width="4%" style="vertical-align:bottom" title="Jenkins" src="media/icons/Jenkins.svg"> </a> Jenkins Build <a target="_blank"> </a>

To access Jenkins, registration on the [Jenkins](https://jenkins.autotests.cloud/) platform is required.

###  Build parameters in Jenkins:

- BROWSER (browser to run tests, default is chrome)
- BROWSER_VERSION (browser version, e.g. 120, 121, 127, 128)
- BROWSER_SIZE (browser window size, default is 1920×1080)
- TEST_TAG (set of tests to run: positive, negative, all_tests)




<p align="center">
<img title="Jenkins Build" src="media/screenshots/jenkins_parameters.png">
</p>

After the build is completed, in the <code>Build History</code> section, icons for <code>Allure Report</code> and <code>Allure TestOps</code> will appear next to the build number. Clicking on these icons will open a page with the generated HTML report and corresponding test documentation, respectively.

---

<a id="allureReport"></a>
## <img width="4%" style="vertical-align:middle" title="Allure report example" src="media/icons/Allure.svg"> </a> Allure report <a target="_blank" href="https://jenkins.autotests.cloud/job/C37-ArtemL999-12-demo-ready-project/5/allure/#suites/be3ff01935ee4ad128ab3fce2d07f389/67fbbbf881ef3e5b/">  example</a>

<p align="center">
<img title="Allure report" src="media/screenshots/allureReport.png">
</p>


---

<a id="allure"></a>
## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="media/icons/AllureTestOps.svg"> </a> Integration with  <a target="_blank" href="https://allure.autotests.cloud/project/4042/dashboards"> Allure TestOps </a>


On the Dashboard in <code>Allure TestOps</code>, you can see statistics on the number of tests: how many of them are added and executed manually, and how many are automated. New tests, as well as the results of the test run, are received through integration with each build execution.

 ---

<p align="center">
<img title="Allure TestOps DashBoard" src="media/screenshots/allureTestOps.png">
</p>

<p align="center">
<img title="Allure TestOps Tests" src="media/screenshots/testCasesInAllureTestOps.png">
</p>

 ---

<a id="jira"></a>
## <img width="4%" style="vertical-align:middle" title="Jira" src="media/icons/Jira.svg"> </a> Integration with <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-1551"> Jira </a>


Integration of <code>Allure TestOps</code> with <code>Jira</code> is implemented. The task displays which test cases were written as part of the task and the results of their execution.

<p align="center">
<img title="Jira Task" src="media/screenshots/jiraIntegration.png">
</p>

---

<a id="telegram"></a>
## <img width="4%" style="vertical-align:middle" title="Telegram" src="media/icons/Telegram.svg"> Telegram notifications

After the build is completed, the Telegram bot created in <code>Telegram</code> automatically processes and sends a message with the test run report to a specifically configured chat.

<p align="center">
<img width="70%" title="Telegram Notification" src="media/screenshots/telegramNotification.png">
</p>

<a id="video"></a>

## <img width="4%" style="vertical-align:middle" title="Selenoid" src="media/icons/Selenoid.svg"> Video Example of Running Tests in Selenoid

In the Allure reports, for each test, not only a screenshot but also a video of the test execution is attached.

<p align="center">
  <img title="Selenoid Video" src="media/video/TestVideo.gif">
</p>























