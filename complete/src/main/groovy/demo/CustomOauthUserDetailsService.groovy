package demo

import grails.plugin.springsecurity.rest.oauth.OauthUser
import grails.plugin.springsecurity.rest.oauth.OauthUserDetailsService
import groovy.transform.CompileStatic
import org.pac4j.core.profile.CommonProfile
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException

@CompileStatic
class CustomOauthUserDetailsService implements OauthUserDetailsService {

    OauthUser loadUserByUserProfile(CommonProfile userProfile, Collection<GrantedAuthority> defaultRoles)
            throws UsernameNotFoundException {
        new OauthUser(userProfile.id, 'N/A', defaultRoles, userProfile)
    }

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null
    }
}
