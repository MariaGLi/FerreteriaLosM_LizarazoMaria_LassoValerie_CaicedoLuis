package com.toolshare.toolshare.Infraestructure.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toolshare.toolshare.Domain.Users;
@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
    Optional<Users> findByUsername(String username);
}
