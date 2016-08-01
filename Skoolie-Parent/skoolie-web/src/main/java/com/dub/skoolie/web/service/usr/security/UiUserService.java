
package com.dub.skoolie.web.service.usr.security;

import com.dub.skoolie.structures.usr.security.UserBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface UiUserService {
    
    public List<UserBean> getUsers();
    
    public UserBean getUser(String username);
    
    public void updateUser(UserBean user);
    
    public void addUser(UserBean user);
    
    public void deleteUserByUsername(String username);
    
    public void deleteUser(UserBean user);
    
    public void enableUserByUsername(String username);
    
    public List<String> getUserTypes();
    
    public void resetPassword(String username, String password);

    public UserBean getUserByEmail(String email);
    
    public void createUserResetToken(UserBean user);

}
