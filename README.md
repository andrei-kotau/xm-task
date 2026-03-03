Taks done as part of Inteview for XM company. August 2025.

**Common Information:**

There are 2 configuration files in the project: `prod-browser-settings.json` and `prod-test-settings.json`

Two main properties are:</br>

1) `browser` possible values are: edge, firefox, chrome.</br>
2) `screenResolution` possible values are: 1024x768, 800x600 or leave empty to maximize the screen. Empty value is used by default.

**How To Run:**

UI test can be launched directly from XmTest.java or via `test-suite.xml` from resources folder

**Issues with schema endpoint of StarWars API:**

StarWars /schema API returns 404, please read more details with example in `com.xm.tests.SWApiTest.swSchemaTest`

**Logs:**

To get more logs change log4j2.xml to `<Configuration status="DEBUG">`</br>
If you want more logs in API tests uncomment `.log(LogDetail.ALL)` everywhere in `SWApiRestClient`

<br/><br/>
**Tasks:**

Task #1 (UI), Resource: xm.com, Tools: Java AND Selenium</br>
Automate next use case to run in three different browser’s screen resolution:

1) Maximum (supported by your display)
2) 1024x768
3) 800x600

Use Case:

1. Open Home page (make any check here if needed).
2. Click the <Research and Education> link located at the top menu (make any check here if needed).
3. Click <Economic Calendar> link in the opened menu (make any check here if needed).
4. Select <Today> on Slider and check that the date is correct.
5. Select <Tomorrow> on Slider and check that the date is correct.
6. Select <Next Week> on Slider and check that the date is correct.
7. Click <Educational Videos> link under <Research and Education>
8. Click the Lesson 1.1 “Introduction to the Financial Markets.”
9. Educational video should play for a minimum of 5 seconds

Task #2 (API), Resource: https://swapi.dev/, Java and Rest Assured
Endpoints examples - find in site tutorial

Use Cases 1:

1. Find the film with latest release date.
2. Using previous response (1) find the tallest person among the characters that were part of that film.
3. Find the tallest person ever played in any Star Wars film.
   Use Cases 2:
1. Create contract test (Json schema validation)  for /people API.

At the end: send us link to the public repo with tasks