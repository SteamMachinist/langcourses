package steammachinist.langcourses.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import steammachinist.langcourses.dto.CourseIntensity;
import steammachinist.langcourses.dto.CourseLevel;
import steammachinist.langcourses.dto.CourseType;

import java.util.Objects;

@Entity
@Table(name = "course_details")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "language_id")
    private LanguageEntity language;
    private CourseLevel level;
    private CourseIntensity intensity;
    private CourseType type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CourseDetailsEntity that = (CourseDetailsEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
