package steammachinist.langcourses.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "course")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseEntity {
    @ManyToOne
    @JoinColumn(name = "details_id")
    CourseDetailsEntity details;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany(mappedBy = "courses")
    @ToString.Exclude
    private Set<StudentEntity> students;

    private Double cost;
    private LocalDate start;
    private LocalDate finish;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CourseEntity that = (CourseEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
