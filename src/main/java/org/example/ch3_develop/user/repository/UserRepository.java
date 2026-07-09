package org.example.ch3_develop.user.repository;

import jakarta.validation.constraints.NotBlank;
import org.example.ch3_develop.user.User;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(@NotBlank String email);
}
