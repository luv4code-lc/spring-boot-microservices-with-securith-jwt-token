package com.luv4code.users.service.api.repository;


import com.luv4code.users.service.api.data.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UserEntity, Long> {
}
