grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/dbconsole/**',      filters: 'none'],
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

grails {
	plugin {
		springsecurity {
			rest {
				token {
					storage {
						jwt {
							secret = 'foobar123'*4 //<1>
						}
					}
				}
				oauth {
					frontendCallbackUrl = { String tokenValue -> "http://localhost:8080/successfullyLoggedIn/index#token=${tokenValue}" } //<2>
					google {
						client = org.pac4j.oauth.client.Google2Client //<3>
						key = '731659565932-kthaahfrddtfdggqj6s1tn4bmp5rvhub.apps.googleusercontent.com' //<4>
						secret = '729PGWdY-s6pgPcJlbP6SUoL' //<5>
						scope = org.pac4j.oauth.client.Google2Client.Google2Scope.EMAIL_AND_PROFILE //<6>
						defaultRoles = [] //<7>
					}
				}
			}
		}
	}
}

grails.plugin.springsecurity.providerNames = ['anonymousAuthenticationProvider'] // <8>
