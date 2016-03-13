
package com.dub.skoolie.business.service.usr.security;

import com.dub.skoolie.business.service.BaseCrudService;
import com.dub.skoolie.structures.usr.security.UserBean;
import org.springframework.security.access.annotation.Secured;

/**
 *
 * @author Kevin W
 */
public interface UserService extends BaseCrudService<UserBean,String>{
    
    public void addUser(UserBean user);
    
    //@Secured("ROLE_ADMIN")
    public void enableUser(String username);
    
    //@Secured("ROLE_ADMIN")
    public void deactivateUser(String username);
    
}