## How to Assmeble a grails-vue app into a single executable jar
1. Execute the following commands:
```bash
./gradlew assembleServerAndClient

java -jar build/server-0.1.jar

# Grails application running at http://localhost:8080 in environment: production
```
2. Browse to http://localhost:8080 to see the vue app

## Related Blog Post:
[Combining the Grails Vue profile projects into a single jar](https://www.amuponda.com/2018/10/28/combining-the-gr…nto-a-single-jar/)
