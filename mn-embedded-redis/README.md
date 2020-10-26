## Embedded redis and micronaut

This small project serves to show how to use an embedded redis instance for tests. 
It contains a single test spec `MnEmbeddedRedisSpec` which create and reads a key in the redis server (database 0).
To test run the command `./gradlew test` which as expected will not need you redis server to be running for it to pass. 

The related blog post can be found [here.](https://www.amuponda.com/2020/10/26/how-to-use-an-embedded-redis-server-with-micronaut/)

