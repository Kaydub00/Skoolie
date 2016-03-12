
package com.dub.skoolie.business.service;

import org.springframework.security.access.annotation.Secured;

/**
 *
 * @author Kevin W
 */
public interface BaseCrudService<E,K> extends BaseService<E,K> {

    //@Secured("ROLE_ADMIN")
    public void updateEntity(E entity);
    
    //@Secured("ROLE_ADMIN")
    public void deleteEntity(E entity);
    
    //@Secured("ROLE_ADMIN")
    public void deleteByID(K id);
    
    
}