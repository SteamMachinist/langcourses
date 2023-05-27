package steammachinist.langcourses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import steammachinist.langcourses.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}
