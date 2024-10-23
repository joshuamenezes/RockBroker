# Resources (Debugging)

### Intellij cant find the main class:
* https://stackoverflow.com/questions/10654120/error-could-not-find-or-load-main-class-in-intellij-ide
  * TLDR: `rm -rf .idea *.iml`

### Docker (yes its getting its own section):
* Might need to increase timeout because sometimes spring doesn't wait 

### General Spring Boot
* [General Tutorial I've been following](https://www.youtube.com/watch?v=s0D1AvtvN4w&list=PLGRDMO4rOGcNLnW1L2vgsExTBg-VPoZHr&index=5&ab_channel=JavaGuides)
* [General Security Management](https://docs.spring.io/spring-security/reference/features/authentication/password-storage.html#authentication-password-storage-configuration)
* [Bypassing Security for Specific URLs](https://www.geeksforgeeks.org/spring-security-security-none-filters-none-access-permitall/)

### Entity Management
* [Entity Column Docs](https://jakarta.ee/specifications/persistence/2.2/apidocs/javax/persistence/column)
* [Why we need a NoArgsConstructor in an entity](https://stackoverflow.com/questions/68314072/why-to-use-allargsconstructor-and-noargsconstructor-together-over-an-entity)
* [What is a DTO](https://stackoverflow.com/questions/1051182/what-is-a-data-transfer-object-dto)

### Postgres
* When initially launching the application, the postgres account did not initially exist, so I had to create it manually:
  * For manually debugging: CLI into the DB container, then launch psql: `psql -U postgres -d rockbroker`. 
  * The application gives global permissions to the postgres user using the [auto-load](https://stackoverflow.com/questions/38040572/spring-boot-loading-initial-data)
    * We can insert data the same way, just adding a `data.sql` file in addition.

### Maven
* To add dependencies, go to the pom.xml file, and rebuild the project to make sure the compiler knows about the new dependencies
* Can change the version of app / dependency file
* TODO: Lookup versioning for dependency file

### Organization
* Add javadocs (above all methods and any annotations) with /**
* 