
package com.dub.skoolie.web.service.usr.security.impl;

import com.dub.skoolie.business.service.usr.security.UserService;
import com.dub.skoolie.business.service.usr.security.UserTypeService;
import com.dub.skoolie.structures.usr.security.UserBean;
import com.dub.skoolie.structures.usr.security.UserTypeBean;
import com.dub.skoolie.web.service.usr.security.UiUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kevin W.
 */
@Service
public class UiUserServiceImpl implements UiUserService {
    
    @Autowired
    UserService userServiceImpl;
    
    @Autowired
    UserTypeService userTypeServiceImpl;

    @Override
    public List<UserBean> getUsers() {
        return userServiceImpl.getAll();
    }

    @Override
    public UserBean getUser(String username) {
        return userServiceImpl.getByID(username);
    }

    @Override
    public void updateUser(UserBean user) {
        userServiceImpl.updateEntity(user);
    }

    @Override
    public void addUser(UserBean user) {
        userServiceImpl.addUser(user);
    }

    @Override
    public void deleteUserByUsername(String username) {
        userServiceImpl.deleteByID(username);
    }

    @Override
    public void deleteUser(UserBean user) {
        userServiceImpl.deleteEntity(user);
    }

    @Override
    public void enableUserByUsername(String username) {
        userServiceImpl.enableUser(username);
    }

    @Override
    public List<UserTypeBean> getUserTypes() {
        return userTypeServiceImpl.getAll();
    }
    
    

}
