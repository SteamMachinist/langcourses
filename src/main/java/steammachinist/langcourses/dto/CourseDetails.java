package steammachinist.langcourses.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDetails {
    private Long id;
    private Language language;
    private CourseLevel level;
    private CourseIntensity intensity;
    private CourseType type;
}
