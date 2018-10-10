package com.amuponda.multipledatasources

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {
    @Autowired
    UserDao dao

    @RequestMapping("/create/db1")
    def createDb1User() {
        Long userId = dao.insertIntoDbOne()
        return userId
    }

    @RequestMapping("/create/db2")
    def createDb2User() {
        Long userId = dao.insertIntoDbTwo()
        return userId
    }
}
