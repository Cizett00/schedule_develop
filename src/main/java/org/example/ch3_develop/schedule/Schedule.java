package org.example.ch3_develop.schedule;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.ch3_develop.BaseEntity;

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
    @Column(nullable = false)
    private String name;
    @Column(length = 200, nullable = false)
    private String content;

    public Schedule(String title, String name, String content) {
        this.title = title;
        this.name = name;
        this.content = content;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
