/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.data.dao.usr.security;

import com.dub.skoolie.data.entities.usr.security.PasswordResetToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kevinw
 */
@Repository
@Transactional("skooliecoreTransactionManager")
public interface PasswordResetTokenRepository extends CrudRepository<PasswordResetToken, Long> {
    
}
