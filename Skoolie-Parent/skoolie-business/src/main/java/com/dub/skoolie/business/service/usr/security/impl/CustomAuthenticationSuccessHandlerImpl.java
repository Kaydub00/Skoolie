
package com.dub.skoolie.business.service.usr.security.impl;

import java.io.IOException;
import java.util.Set;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 *
 * @author Kevin W.
 */
public class CustomAuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(javax.servlet.http.HttpServletRequest hsr, javax.servlet.http.HttpServletResponse hsr1, Authentication a) throws IOException, javax.servlet.ServletException {
        //Right here I need to send users to specific locations depending on their role
        Set<String> roles = AuthorityUtils.authorityListToSet(a.getAuthorities());
        if(roles.contains("ROLE_SYSTEM")){
            hsr1.sendRedirect("/testpage");
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
