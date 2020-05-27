This a basic tutorial to show how to reload micronaut applications using gradle continous build. The project has one controller `src/main/groovy/com/example/HelloController.groovy` containing a simple method that return a String.

## File Changed Event
To test the firing of the FileChangeEvent 
1. Set this config to false is application.yml
```
micronaut.io.watch.restart: false
```
2. Run `./gradlew run`
3. Change the String returned in the `greeting()` method of HelloController and save
4. The `FileChangedEvent` should fire and be reflected in the logs

## Application Reload
To test the application reload
1. Run `./gradlew run -t`
2. Change the String returned in the greeting() method of HelloController and save
3. The server should stop and restart automatically

## Related Blog Post
[Micronaut application reloading](https://www.amuponda.com/2020/05/27/micronaut-application-reloading/)

 
