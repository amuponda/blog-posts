package grails3.hibernate.spec

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional

@Transactional
@GrailsCompileStatic
class StudentService {

    List<Student> findStudentsWithGradeAbove(BigDecimal grade) {
        Student.findAllByGradeGreaterThanEquals(grade)
    }
}
