package demo

import grails.gorm.services.Service

interface IBookFavouriteDataService {
    BookFavourite save(Long bookId, String username)
}

@Service(BookFavourite)
abstract class BookFavouriteDataService implements IBookFavouriteDataService {

    List<Long> findBookFavouriteBookId(String usernameParam) {
        BookFavourite.where {
            username == usernameParam
        }.projections {
            property('bookId')
        }.list()
    }
}