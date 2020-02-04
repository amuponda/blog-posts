package grails3.hibernate.spec

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Student {

    String name
    BigDecimal grade
    Classroom classroom

    static constraints = {
        classroom nullable: true
    }
}
