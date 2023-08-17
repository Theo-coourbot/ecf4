package com.authentification.authentification.repository;

import com.authentification.authentification.entity.UserApp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAppRepository extends CrudRepository<UserApp,Integer> {
    Optional<UserApp> findByPseudo(String pseudo);
}
