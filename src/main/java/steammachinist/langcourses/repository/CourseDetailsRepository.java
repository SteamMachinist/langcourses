package steammachinist.langcourses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import steammachinist.langcourses.entity.CourseDetailsEntity;

public interface CourseDetailsRepository extends JpaRepository<CourseDetailsEntity, Long> {
}
