package demo

import grails.gorm.services.Query
import grails.gorm.services.Service
import groovy.transform.CompileStatic

@CompileStatic
@Service(BookPageView)
interface BookPageViewDataService {
    abstract void delete(Serializable id)

    abstract BookPageView save(Long bookId, String bookName, Integer views)

    abstract BookPageView findByBookId(Long bookId)

    @Query("update ${BookPageView b} set ${b.views} = $viewsParam where $b.bookId = $bookIdParam")
    abstract Number updateViews(Long bookIdParam, Integer viewsParam)

    @Query("select $b.views from ${BookPageView b} where $b.bookId = $bookIdParam")
    abstract List<Integer> findViewsByBookId(Long bookIdParam)
}