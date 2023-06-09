# Wikipedia mobile autotests
Tests were developed as part of a training project

## Tools and technologies
![This is an image](/media/Java.png)
![This is an image](/media/appium.png)
![This is an image](/media/androidstudio.png)
![This is an image](/media/Gradle.png)
![This is an image](/media/Rest-Assured.png)
![This is an image](/media/Intelij_IDEA.png)
![This is an image](/media/Github.png)
![This is an image](/media/JUnit5.png)
![This is an image](/media/Jenkins.png)
![This is an image](/media/Allure_Report.png)
![This is an image](/media/AllureTestOps.png)
![This is an image](/media/Telegram.png)


## What's interesting?

* Configuration with Owner library for local and remote run with Browserstack
* Parametrized build
* Custom Listener
* Allure integration
* Telegram notifications

## How to run 

Local run:
```gradle clean test -Denv=local```

Remote run:
```gradle clean test -Denv=remote```

And set up enviroment variables BROWSERSTACK_USER and BROWSERSTACK_KEY

You can run the readymade build [here.](https://jenkins.autotests.cloud/job/C16-sw_tata_mobile_wiki_tests/)

## Analyzing results :bookmark_tabs:

### [Allure report:](https://jenkins.autotests.cloud/job/C16-sw_tata_mobile_wiki_tests/4/allure/#suites)

![This is an image](/media/Screenshot_2.png)

### Telegram notification:

![This is an image](/media/Screenshot_1.png)

### Example video attachment:

![video](media/video.gif)
