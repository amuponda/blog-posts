## How To Run The App

1. clone the repo
2. cd into root folder
3. Build app to test local run
```bash
./gradlew stage
heroku local web
```
### Manual deployment to heroku 
4. Create an an app on your own heroku account
```bash
heroku login
heroku create
```
5. Change ```appName``` in ```build.gradle``` heroku config block to the one created above
```bash
heroku {
    appName = "arcane-waters-80691" /*REPLACE THIS WITH YOUR OWN APP NAME*/
    jdkVersion = "1.8"
    buildpacks = ["heroku/jvm"]
    processTypes(web: "java -Dserver.port=\$PORT \$JAVA_OPTS -jar build/server-${project.version}.jar".toString())
}
```
6. Add and commit ```build.gradle``` file:
```bash
git add build.gradle
git commit -m"Changed the app name"
```
7. Deploy to heroku
```bash
git push heroku master
```
### Deploy using [heroku gradle plugin](https://github.com/heroku/heroku-gradle)
```bash
/.gradlew deployHeroku
```

## Related Blog Post:
[Deploying a grails vue app to heroku using gradle]( https://www.amuponda.com/2018/11/06/deploying-a-grai…oku-using-gradle/)
