package com.harry.repository;

import com.harry.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstagramUserRepository extends CrudRepository<UserModel, Long> {

    Optional<UserModel> findByUserName(String userName);
}
