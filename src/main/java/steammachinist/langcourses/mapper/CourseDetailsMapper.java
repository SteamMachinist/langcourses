package steammachinist.langcourses.mapper;

import org.mapstruct.Mapper;
import steammachinist.langcourses.dto.CourseDetails;
import steammachinist.langcourses.entity.CourseDetailsEntity;

@Mapper(componentModel = "spring")
public interface CourseDetailsMapper {
    CourseDetailsEntity toCourseDetailsEntity(CourseDetails course);

    CourseDetails toCourseDetails(CourseDetailsEntity courseDetailsEntity);
}
