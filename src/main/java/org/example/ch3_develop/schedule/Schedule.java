package org.example.ch3_develop.schedule;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.ch3_develop.BaseEntity;
import org.example.ch3_develop.user.User;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "schedules")

public class Schedule extends BaseEntity {


    //id, title, content, 작성/수정일
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 10, nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(length = 200, nullable = false)
    private String content;


    public Schedule(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
