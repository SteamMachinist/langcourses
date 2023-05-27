package steammachinist.langcourses.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import steammachinist.langcourses.dto.CourseDetails;
import steammachinist.langcourses.mapper.CourseDetailsMapper;
import steammachinist.langcourses.repository.CourseDetailsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseDetailsService {
    private final CourseDetailsRepository courseDetailsRepository;
    private final CourseDetailsMapper courseDetailsMapper;

    public List<CourseDetails> getAll() {
        return courseDetailsRepository.findAll().stream().map(courseDetailsMapper::toCourseDetails).collect(Collectors.toList());
    }

    public CourseDetails getById(Long id) {
        return courseDetailsRepository.findById(id).map(courseDetailsMapper::toCourseDetails).orElseThrow(EntityNotFoundException::new);
    }

    public void add(CourseDetails courseDetails) {
        courseDetailsRepository.save(courseDetailsMapper.toCourseDetailsEntity(courseDetails));
    }

    public void update(Long id, CourseDetails courseDetails) {
        CourseDetails old = getById(id);
        old.setLanguage(courseDetails.getLanguage());
        old.setLevel(courseDetails.getLevel());
        old.setIntensity(courseDetails.getIntensity());
        old.setType(courseDetails.getType());
        courseDetailsRepository.save(courseDetailsMapper.toCourseDetailsEntity(old));
    }

    public void delete(Long id) {
        courseDetailsRepository.delete(courseDetailsMapper.toCourseDetailsEntity(getById(id)));
    }
}
