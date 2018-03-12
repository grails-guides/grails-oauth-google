import demo.JwtCookieTokenReader
//tag::cookieClearingImport[]
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler
//end::cookieClearingImport[]
beans = {
    tokenReader(JwtCookieTokenReader) {
        cookieName = 'foo'
    }
    //tag::cookieClearing[]
    cookieClearingLogoutHandler(CookieClearingLogoutHandler, ['jwt'])
    //end::cookieClearing[]
}
