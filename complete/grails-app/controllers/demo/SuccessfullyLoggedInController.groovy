package demo

class SuccessfullyLoggedInController {
    def index() {
        flash.message = 'You logged in successfully with google'
        redirect controller: 'book'
    }
}