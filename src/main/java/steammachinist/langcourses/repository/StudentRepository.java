package steammachinist.langcourses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import steammachinist.langcourses.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
