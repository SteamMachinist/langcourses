package steammachinist.langcourses.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import steammachinist.langcourses.dto.Student;
import steammachinist.langcourses.service.StudentService;

import java.util.List;

@RestController()
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody Student student) {
        studentService.add(student);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Student student, Long id) {
        studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}
