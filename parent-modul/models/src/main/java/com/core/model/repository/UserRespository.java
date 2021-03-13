package com.core.model.repository;

import com.core.model.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRespository extends JpaRepository<User, Long> {

    @Query(value = "select u from User u left join u.roles where u.username=:username")
    Optional<User> findByUserNameWithRoles(@Param("username") String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}
