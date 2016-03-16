
package com.dub.skoolie.business.service.usr.security.impl;

import com.dub.skoolie.business.service.usr.security.AppUserDetailsService;
import com.jcraft.jsch.Logger;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W.
 */
@Service("dBUserDetailsServiceImpl")
public class DBUserDetailsServiceImpl  extends JdbcDaoImpl implements AppUserDetailsService {
    
    @Autowired
    private DataSource skooliecoreDataSource;
    
    @PostConstruct
    public void init() {
        super.setDataSource(skooliecoreDataSource);
    }
    
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        //A lot more logic will need to go here, maybe change the jdbc query for an User object
        // Need to put a login audit log here, something to increase user login attempts, and lockout the user if they have # attempts
        super.setDataSource(skooliecoreDataSource);
        super.setEnableAuthorities(true);
        super.setEnableGroups(true);
        super.setUsersByUsernameQuery("select USERNAME,PASSWORD,ENABLED from USR_USER where USERNAME=?");
        super.setAuthoritiesByUsernameQuery("select USERNAME, ROLE from USR_USER_ROLE where USERNAME=?");
        super.setGroupAuthoritiesByUsernameQuery("select UUG.ID, G.`GROUP`, UGR.`ROLE` FROM USR_USER_GROUP UUG JOIN USR_GROUPS G ON UUG.`GROUP_ID` = G.`GROUP` JOIN USR_GROUP_ROLES UGR ON UGR.`GROUP_ID` = G.`GROUP` WHERE UUG.`USERNAME` = ?");
        UserDetails user =  super.loadUserByUsername(string);
        Date exp = (Date)getJdbcTemplate().queryForObject("SELECT EXPIRATION FROM USR_USER WHERE USERNAME=?", new Object[] { string }, Date.class);
        if(exp == null || exp.after(new Date())) {
            if(isFirstLogin(user.getUsername())) {
                //do something crazy like go through a first time login workflow
                
            }
            return user;
        } else {
            throw new CredentialsExpiredException(string + " Has Expired");
        }
    }
    
    protected Boolean isFirstLogin(String username) {
        Integer cnt = getJdbcTemplate().queryForObject("SELECT count(*) FROM USR_USER WHERE USERNAME=? AND FIRST_LOGIN = TRUE", Integer.class, username);
        return cnt != null && cnt > 0;
    }

}
