package com.example.mall.repository;

import com.example.mall.POJO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {


    Boolean existsUserByUsername(String username);

    Boolean existsUserByUsernameAndPassword(String username, String password);

    User findUserByUsernameAndPassword(String username, String password);

    @Query("select distinct u from User u where u.Id = ?1")
    User findOneById(Long id);
}
