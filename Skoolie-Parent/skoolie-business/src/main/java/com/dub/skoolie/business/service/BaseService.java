
package com.dub.skoolie.business.service;

import java.util.List;
import org.springframework.security.access.annotation.Secured;

/**
 *
 * @author Kevin W
 */
public interface BaseService<E, K> {
    
    //@Secured("ROLE_USER")
    public E getByID(K id);
    
    //@Secured("ROLE_USER")
    public List<E> getAll();

}