package demo

import grails.testing.mixin.integration.Integration
import spock.lang.Specification

@Integration
class BookPageViewGormServiceIntegrationSpec extends Specification {

    BookPageViewGormService bookPageViewGormService
    BookPageViewDataService bookPageViewDataService

    def "test increments"() {
        expect:
        !bookPageViewDataService.findByBookId(2)

        when:
        bookPageViewGormService.increment(2, 'Practical Grails 3')
        BookPageView bookPageView = bookPageViewDataService.findByBookId(2)

        then:
        bookPageView
        bookPageViewDataService.findByBookId(2).views == 1

        when:
        bookPageViewGormService.increment(2, 'Practical Grails 3')
        bookPageView = bookPageViewDataService.findByBookId(2)

        then:
        bookPageView
        bookPageViewDataService.findByBookId(2).views == 2

        cleanup:
        bookPageViewDataService.delete(bookPageView.id)
    }
}
