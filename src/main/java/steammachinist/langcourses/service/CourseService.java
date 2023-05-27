package steammachinist.langcourses.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import steammachinist.langcourses.dto.Course;
import steammachinist.langcourses.mapper.CourseMapper;
import steammachinist.langcourses.repository.CourseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public List<Course> getAll() {
        return courseRepository.findAll().stream().map(courseMapper::toCourse).collect(Collectors.toList());
    }

    public Course getById(Long id) {
        return courseRepository.findById(id).map(courseMapper::toCourse).orElseThrow(EntityNotFoundException::new);
    }

    public void add(Course course) {
        courseRepository.save(courseMapper.toCourseEntity(course));
    }

    public void update(Long id, Course course) {
        Course old = getById(id);
        old.setDetails(course.getDetails());
        old.setStudents(course.getStudents());
        old.setCost(course.getCost());
        old.setStart(old.getStart());
        old.setFinish(old.getFinish());
        courseRepository.save(courseMapper.toCourseEntity(old));
    }

    public void delete(Long id) {
        courseRepository.delete(courseMapper.toCourseEntity(getById(id)));
    }
}
