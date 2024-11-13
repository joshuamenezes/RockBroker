# Resources (Debugging)

### Intellij cant find the main class:
* https://stackoverflow.com/questions/10654120/error-could-not-find-or-load-main-class-in-intellij-ide
  * TLDR: `rm -rf .idea *.iml`

### Docker:
* General Guides: https://spring.io/guides/gs/spring-boot-docker
* Might need to increase timeout because sometimes spring doesn't wait 
* If application is acting weird: `docker-compose down && docker-compose up --build`
* To restart the database: `docker-compose down && docker volume rm rockbroker_database-volume`

### General Spring Boot
* [General Tutorial I've been following](https://www.youtube.com/watch?v=s0D1AvtvN4w&list=PLGRDMO4rOGcNLnW1L2vgsExTBg-VPoZHr&index=5&ab_channel=JavaGuides)
* [General Security Management](https://docs.spring.io/spring-security/reference/features/authentication/password-storage.html#authentication-password-storage-configuration)
* [Bypassing Security for Specific URLs](https://www.geeksforgeeks.org/spring-security-security-none-filters-none-access-permitall/)
* The service layer utilizes the repository (basic queries) to retrieve data

### Entity Management
* [Entity Column Docs](https://jakarta.ee/specifications/persistence/2.2/apidocs/javax/persistence/column)
* [Why we need a NoArgsConstructor in an entity](https://stackoverflow.com/questions/68314072/why-to-use-allargsconstructor-and-noargsconstructor-together-over-an-entity)
* [What is a DTO](https://stackoverflow.com/questions/1051182/what-is-a-data-transfer-object-dto)

### Postgres
* When initially launching the application, the postgres account did not initially exist, so I had to create it manually:
  * For manually debugging: CLI into the DB container, then launch psql: `psql -U postgres -d rockbroker`. 
  * The application gives global permissions to the postgres user using the [auto-load](https://stackoverflow.com/questions/38040572/spring-boot-loading-initial-data)
    * We can insert data the same way, just adding a `data.sql` file in addition.
* [Docker Setup w/ Postgres](https://www.youtube.com/watch?v=_Gdb-jK3Sr4&ab_channel=DanVega)
* Static docs on [config](https://hackernoon.com/using-postgres-effectively-in-spring-boot-applications)
* 

### Maven
* To add dependencies, go to the pom.xml file, and rebuild the project to make sure the compiler knows about the new dependencies
* Can change the version of app / dependency file
* TODO: Lookup versioning for dependency file

### Organization
* Add javadocs (above all methods and any annotations) with /**
* [Logging](https://medium.com/@psdevraye/best-practices-for-exception-logging-in-spring-boot-real-time-examples-5139607103aa)

### Deployment
* [AWS](https://www.youtube.com/watch?v=GGPPkUcHleQ&ab_channel=DanVega)

### Frontend Integration
* https://www.youtube.com/watch?v=pYaamz6AyvU&ab_channel=DaveGray

### CICD:
* https://www.youtube.com/watch?v=PvwOxdyvSsg&ab_channel=lemoncode21
* https://www.youtube.com/watch?app=desktop&v=UtEHSngmdHA&ab_channel=BoualiAli