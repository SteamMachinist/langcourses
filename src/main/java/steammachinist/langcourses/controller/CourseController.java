package steammachinist.langcourses.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import steammachinist.langcourses.dto.Course;
import steammachinist.langcourses.service.CourseService;

import java.util.List;

@RestController()
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable Long id) {
        return courseService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody Course course) {
        courseService.add(course);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Course course, Long id) {
        courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        courseService.delete(id);
    }
}
