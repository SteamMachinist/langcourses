package steammachinist.langcourses.mapper;

import org.mapstruct.Mapper;
import steammachinist.langcourses.dto.Course;
import steammachinist.langcourses.entity.CourseEntity;

@Mapper(componentModel = "spring",
        uses = {CourseDetailsMapper.class, StudentMapper.class})
public interface CourseMapper {
    CourseEntity toCourseEntity(Course course);

    Course toCourse(CourseEntity courseEntity);
}
