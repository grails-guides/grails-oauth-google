package demo

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured

class SuccessfullyLoggedInController {

    SpringSecurityService springSecurityService //<1>

    static allowedMethods = [
            index: 'GET'
    ]

    @Secured('isAuthenticated()')
    def index() {
        final oauthAttributes = springSecurityService?.principal?.userProfile?.attributes //<2>
        flash.message = "${oauthAttributes?.displayName ?: 'You'} logged in successfully with a gmail address ${oauthAttributes?.emails?.email?.get(0) ?: 'N/A'}"
        redirect controller: 'book', action: 'index'
    }
}