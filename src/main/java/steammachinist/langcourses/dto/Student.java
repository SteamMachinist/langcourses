package steammachinist.langcourses.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long id;
    private String name;
    private Set<CourseDetails> applications;
    private Set<Course> courses;
}
