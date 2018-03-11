import demo.JwtCookieTokenReader
beans = {
    tokenReader(JwtCookieTokenReader) {
        cookieName = 'foo'
    }
}
