package com.tekup.coco.repository;

import com.tekup.coco.Dto.UserDto;
import com.tekup.coco.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
    Optional<User> findByEmail(String email);

    // Optional<User> findById(UserDto userId);
}
