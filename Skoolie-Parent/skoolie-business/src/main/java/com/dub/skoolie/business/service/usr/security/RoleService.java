
package com.dub.skoolie.business.service.usr.security;

import com.dub.skoolie.structures.usr.security.RoleBean;
import java.util.List;

/**
 *
 * @author Kevin W
 */
public interface RoleService {

    public List<RoleBean> getAllRoles();
    
    public RoleBean getRole(String id);
}
