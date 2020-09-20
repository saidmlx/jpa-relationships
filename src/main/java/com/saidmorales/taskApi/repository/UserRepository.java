package com.saidmorales.taskApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.saidmorales.taskApi.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
