// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'demo.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'demo.UserRole'
grails.plugin.springsecurity.authority.className = 'demo.Role'
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
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

//tag::oauthConfig[]
grails {
	plugin {
		springsecurity {
			rest {
				oauth {
					frontendCallbackUrl = { String tokenValue -> "http://localhost:8080/successfullyLoggedIn/index#token=${tokenValue}" } //<1>
					google {
						client = org.pac4j.oauth.client.Google2Client //<2>
						key = '731659565932-kthaahfrddtfdggqj6s1tn4bmp5rvhub.apps.googleusercontent.com' //<3>
						secret = '729PGWdY-s6pgPcJlbP6SUoL' //<4>
						scope = org.pac4j.oauth.client.Google2Client.Google2Scope.EMAIL_AND_PROFILE //<5>
						defaultRoles = [] //<6>
					}
				}
			}
		}
	}
}
//end::oauthConfig[]
