package Exercises.E5_D9.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Blog {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String category;
    @Column
    private String title;
    @Column
    private String cover;
    @Column
    private String content;
    @Column
    private int readTime;
    @ManyToOne
    private Author author;
}
