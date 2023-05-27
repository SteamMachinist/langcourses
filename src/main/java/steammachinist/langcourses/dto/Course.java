package steammachinist.langcourses.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private Long id;
    private CourseDetails details;
    private Set<Student> students;
    private Double cost;
    private LocalDate start;
    private LocalDate finish;
}
