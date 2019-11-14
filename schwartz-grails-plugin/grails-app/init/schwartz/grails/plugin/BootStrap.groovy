package schwartz.grails.plugin

class BootStrap {

    def quartzService
    def helloWorldJobService

    def init = { servletContext ->
        quartzService.triggerJob(helloWorldJobService.jobKey)
    }
    def destroy = {
    }
}
