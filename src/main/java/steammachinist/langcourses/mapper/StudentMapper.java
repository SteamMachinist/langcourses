package steammachinist.langcourses.mapper;

import org.mapstruct.*;
import steammachinist.langcourses.dto.Student;
import steammachinist.langcourses.entity.StudentEntity;

@Mapper(componentModel = "spring",
        uses = {CourseDetailsMapper.class})
public interface StudentMapper {
    @DoIgnore
    default StudentEntity toStudentEntity(Student student) {
        return toStudentEntity(student, new CycleAvoidingMappingContext());
    }

    StudentEntity toStudentEntity(Student student, @Context CycleAvoidingMappingContext context);

    @DoIgnore
    default Student toStudent(StudentEntity studentEntity) {
        return toStudent(studentEntity, new CycleAvoidingMappingContext());
    }

    Student toStudent(StudentEntity studentEntity, @Context CycleAvoidingMappingContext context);
}
