package demo

import grails.plugin.springsecurity.annotation.Secured
import groovy.transform.CompileStatic

@Secured('permitAll')
@CompileStatic
class BookController {

    static allowedMethods = [index: 'GET', show: 'GET']

    BookGormService bookGormService
    BookDataService bookDataService

    def index() {
        [bookList: bookGormService.findAll()]
    }

    def show(Long id) {
        [bookInstance: bookDataService.findById(id)]
    }

}