package demo

import groovy.transform.CompileStatic

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