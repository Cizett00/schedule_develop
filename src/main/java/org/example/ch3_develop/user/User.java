package org.example.ch3_develop.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.ch3_develop.BaseEntity;
import org.example.ch3_develop.schedule.Schedule;

@Entity
@Getter
@Table(name="users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void update(String email){
        this.email = email;
    }
}
