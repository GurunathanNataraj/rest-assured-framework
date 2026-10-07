# REST Assured API framework

Run the parallel TestNG suite:

```powershell
mvn clean test
```

## Select a suite

By default, Maven runs `src/test/resources/testng.xml` (all tests).
Override `suiteXmlFile` to select a suite without editing the POM:

```powershell
# Smoke: smoke-group tests, up to two methods at a time
mvn clean test "-DsuiteXmlFile=src/test/resources/testng-smoke.xml"

# Regression: regression-group tests, up to five methods at a time
mvn clean test "-DsuiteXmlFile=src/test/resources/testng-regression.xml"
```

The selected XML controls group selection and parallel settings. Quote the
complete `-D` argument in PowerShell. Existing environment/logging overrides can
be combined with suite selection. IntelliJ can still run each XML directly.

## Allure reporting

TestNG results, failures, timings, and data-provider parameters are written to
`target/allure-results`. Requests made through `RequestSpec` include request and
response HTML attachments. The report also records the environment, base URL, and
Java version. Each request gets a fresh reporting filter, including
when tests run in parallel. IntelliJ TestNG runs also generate results when their
working directory is the project root.

Open a test in Suites and expand Parameters to see `Execution start` and
`Execution end`. These use Allure's recorded start/stop timestamps, formatted in
the JVM's local time zone with milliseconds and a UTC offset. The lifecycle
listener adds them just before each result is written, including failures and
skips when timestamps are available. They are excluded from history comparisons.

Generate the HTML report:

```powershell
mvn allure:report
```

The report is generated at `target/site/allure-maven-plugin/index.html`. To view it through
a local web server, run:

```powershell
mvn allure:serve
```

Use `mvn clean test` for a new report run; running tests without cleaning accumulates
results. Generated artifacts stay under the Git-ignored `target` directory.

The templates hide authorization, cookie, and API-key headers and escape HTML.
Bodies and URLs are included as supplied. Login requests in `AuthManager` are not
attached; add body/query redaction before extending reporting to credentials or
token-bearing payloads. Console logging is controlled separately by config.

Integration follows the [Allure TestNG](https://allurereport.org/docs/testng/)
and [REST Assured](https://allurereport.org/docs/restassured/) documentation.
