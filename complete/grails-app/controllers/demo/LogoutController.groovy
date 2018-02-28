package demo

import org.springframework.security.core.context.SecurityContextHolder

class LogoutController {

    static allowedMethods = [
            index: 'GET'
    ]

    def index() {
        flash.message = 'You have logged out'
        SecurityContextHolder.clearContext()
        redirect controller: 'book', action: 'index'
    }
}
