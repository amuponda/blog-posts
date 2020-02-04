package grails3.hibernate.spec

import grails.config.Config
import grails.test.hibernate.HibernateSpec
import grails.testing.services.ServiceUnitTest
import org.grails.config.PropertySourcesConfig
import org.grails.orm.hibernate.cfg.Settings
import org.springframework.boot.env.PropertySourcesLoader
import org.springframework.core.env.MapPropertySource
import org.springframework.core.env.MutablePropertySources
import org.springframework.core.io.DefaultResourceLoader
import org.springframework.core.io.ResourceLoader
import spock.lang.Specification

class StudentServiceSpec extends HibernateSpec implements ServiceUnitTest<StudentService>{

    List<Class> getDomainClasses() { [Student] }

    def 'test find students with grades above'() {
        when: 'students are already stored in db'
        Student.saveAll(
                new Student(name: 'Nirav', grade: 91),
                new Student(name: 'Sergio', grade: 95),
                new Student(name: 'Jeff', grade: 93),
        )

        then:
        Student.count() == 3

        when: 'service is called to search'
        List<Student> students = service.findStudentsWithGradeAbove(92)

        then: 'students are found with appropriate grades'
        students.size() == 2
        students[0].name == 'Sergio'
        students[0].grade == 95
        students[1].name == 'Jeff'
        students[1].grade == 93
        hibernateDatastore.dataSource.connection.metaData.URL == 'jdbc:mariadb://localhost/school'
    }

    /**
     * @return The configuration
     */
    @Override
    Map getConfiguration() {
        [
                dataSource: [
                        dbCreate: "update",
                        driverClassName: "org.mariadb.jdbc.Driver",
                        dialect: "org.hibernate.dialect.MySQL5InnoDBDialect",
                        username: "root",
                        password: "",
                        url: "jdbc:mariadb://localhost/school"
                ]
        ]
    }
}
