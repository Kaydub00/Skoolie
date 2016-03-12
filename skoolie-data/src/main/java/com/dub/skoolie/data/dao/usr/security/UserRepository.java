
package com.dub.skoolie.data.dao.usr.security;

import com.dub.skoolie.data.entities.usr.security.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kevin W
 */
@Repository
@Transactional("skooliecoreTransactionManager")
public interface UserRepository extends CrudRepository<User, String> {

}
