package org.example.repository;

import org.example.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    /**
     * @param password -> inner pass in database
     * @param username -> public user info
     * @return -> UserEntity -> after will be mapped to UserResponse in dto package
     */
    UserEntity findUserEntitiesByPasswordAndUsername(String password, String username);

}
