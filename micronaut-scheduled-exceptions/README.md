## Summary

This is a simple micronaut project to show how you can implement custome exception handling when a scheduled task fails. The project has a job, `HelloWorldJob` that executes every 10s. The job throws an exception that is handled by the custom exception handler, `HelloWorldTaskExceptionHandler`.

## How to run the app
1. cd into the project folder
2. Run the command: ```./gradlew run```

## Blog Post
[Handle exceptions in micronaut scheduled tasks](https://www.amuponda.com/2019/12/29/handle-exceptions-in-micronaut-scheduled-tasks) Is the blog post related to this project.
