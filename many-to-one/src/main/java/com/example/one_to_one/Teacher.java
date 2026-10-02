package com.example.one_to_one;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId;

    private String teacherName;

    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
    private List<Subject> subjects;
}
