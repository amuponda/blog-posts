package grails3.hibernate.spec

import groovy.transform.CompileStatic

@CompileStatic
class Classroom {

    String teacher
    static hasMany = [students: Student]
}
