package com.academiapro.cms.entiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    private Day day;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private SchoolClass schoolClass;

    @ManyToOne
    private Teacher teacher;

    @OneToMany(mappedBy = "lesson")
    private List<Exam> exams;

    @OneToMany(mappedBy = "lesson")
    private List<Assignment> assignments;

    @OneToMany(mappedBy = "lesson")
    private List<Attendance> attendances;
}
