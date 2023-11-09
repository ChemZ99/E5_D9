package Exercises.E5_D9.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table
public class Author {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String email;
    @Column
    private LocalDate birth;
    @Column
    private String avatar;
    @OneToMany(mappedBy = "author")
    private List<Blog> blogs;
}
