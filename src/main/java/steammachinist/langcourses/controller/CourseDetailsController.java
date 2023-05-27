package steammachinist.langcourses.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import steammachinist.langcourses.dto.CourseDetails;
import steammachinist.langcourses.service.CourseDetailsService;

import java.util.List;

@RestController()
@RequestMapping("/courseDetails")
@RequiredArgsConstructor
public class CourseDetailsController {
    private final CourseDetailsService courseDetailsService;

    @GetMapping
    public List<CourseDetails> getAll() {
        return courseDetailsService.getAll();
    }

    @GetMapping("/{id}")
    public CourseDetails getById(@PathVariable Long id) {
        return courseDetailsService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody CourseDetails courseDetails) {
        courseDetailsService.add(courseDetails);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody CourseDetails courseDetails, Long id) {
        courseDetailsService.update(id, courseDetails);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        courseDetailsService.delete(id);
    }
}
