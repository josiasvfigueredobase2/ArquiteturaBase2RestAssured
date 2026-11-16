# Java REST Assured TestNG Template

This project contains REST API tests written with Java, REST Assured, and TestNG. The sample tests target the Swagger Petstore API.

## Requirements

- JDK 8 or later
- Apache Maven 3.6 or later
- Visual Studio Code (optional)

## Configure the project

1. Clone the repository and open its root folder, the one containing `pom.xml`.
2. Edit `globalParameters.properties` and set `environment` to `staging`. Select `dev` only after configuring its environment-specific values.
3. Replace placeholder values such as `xxx` with values for your environment. Do not commit credentials or tokens.

The supplied staging URL points to the public Swagger Petstore service. The tests create, update, query, and delete pet records there, so they require network access and should only be run against an environment where those changes are acceptable.

## Run tests with Maven

Download dependencies and run the complete test suite:

```shell
mvn test
```

Test reports are written under `target/reports`.

## Run tests in Visual Studio Code

1. Install the **Extension Pack for Java** (`vscjava.vscode-java-pack`). It includes **Test Runner for Java** (`vscjava.vscode-java-test`).
2. Install **Maven for Java** (`vscjava.vscode-maven`).
3. Open the project root in VS Code and wait for Java support to start.
4. In the Maven view, select **Load Maven Projects** so VS Code imports the dependencies and discovers the TestNG tests.
5. Run a test from the editor's **Run Test** link or from the **Testing** view.

If tests do not appear, confirm that Maven has loaded `pom.xml` and refresh the Testing view.
