package demo

import grails.gorm.transactions.Transactional
import groovy.transform.CompileStatic

@CompileStatic
class BookPageViewGormService {

    BookPageViewDataService bookPageViewDataService

    @Transactional
    void increment(Long bookId, String bookName) {
        List<Integer> views = bookPageViewDataService.findViewsByBookId(bookId)
        if ( !views) {
            bookPageViewDataService.save(bookId, bookName, 1)
        } else {
            bookPageViewDataService.updateViews(bookId, (views.first() + 1))
        }
    }
}