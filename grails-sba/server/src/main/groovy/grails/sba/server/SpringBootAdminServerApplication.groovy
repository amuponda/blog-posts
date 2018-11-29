package grails.sba.server

import de.codecentric.boot.admin.config.EnableAdminServer
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@EnableAdminServer
@SpringBootApplication
class SpringBootAdminServerApplication {

	static void main(String[] args) {
		SpringApplication.run SpringBootAdminServerApplication, args
	}
}
