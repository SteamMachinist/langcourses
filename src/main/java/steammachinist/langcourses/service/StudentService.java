package steammachinist.langcourses.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import steammachinist.langcourses.dto.Student;
import steammachinist.langcourses.mapper.StudentMapper;
import steammachinist.langcourses.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public List<Student> getAll() {
        return studentRepository.findAll().stream().map(studentMapper::toStudent).collect(Collectors.toList());
    }

    public Student getById(Long id) {
        return studentRepository.findById(id).map(studentMapper::toStudent).orElseThrow(EntityNotFoundException::new);
    }

    public void add(Student student) {
        studentRepository.save(studentMapper.toStudentEntity(student));
    }

    public void update(Long id, Student student) {
        Student old = getById(id);
        old.setName(student.getName());
        old.setApplications(student.getApplications());
        old.setCourses(student.getCourses());
        studentRepository.save(studentMapper.toStudentEntity(old));
    }

    public void delete(Long id) {
        studentRepository.delete(studentMapper.toStudentEntity(getById(id)));
    }
}
