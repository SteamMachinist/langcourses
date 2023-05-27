package steammachinist.langcourses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import steammachinist.langcourses.entity.LanguageEntity;

public interface LanguageRepository extends JpaRepository<LanguageEntity, Long> {
}
