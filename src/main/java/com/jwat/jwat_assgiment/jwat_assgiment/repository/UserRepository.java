package com.jwat.jwat_assgiment.jwat_assgiment.repository;

import com.jwat.jwat_assgiment.jwat_assgiment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
