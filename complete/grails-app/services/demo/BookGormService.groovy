package demo

import grails.gorm.transactions.ReadOnly
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic

@CompileStatic
class BookGormService {

    @CompileDynamic
    @ReadOnly
    List<BookImage> findAll() {
        Book.where {}.projections {
            property('id')
            property('image')
        }.collect { def rowResult ->
            new BookImage(id: rowResult[0] as Long, image: rowResult[1])
        }
    }
}