
package com.dub.skoolie.business.service.usr.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Kevin W.
 */
public class AuthenticationProviderImpl implements AuthenticationProvider {
    
    @Autowired
    private DaoAuthenticationProvider dbAuthenticationProvider;

    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {
        String username = a.getPrincipal().toString();
        try {
            return dbAuthenticationProvider.authenticate(a);
        } catch (UsernameNotFoundException e) {
            throw e;
        } catch (AuthenticationException ae) {
            throw ae;
        }
        
    }

    @Override
    public boolean supports(Class<?> type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
