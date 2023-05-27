package steammachinist.langcourses.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import steammachinist.langcourses.dto.Language;
import steammachinist.langcourses.service.LanguageService;

import java.util.List;

@RestController()
@RequestMapping("/languages")
@RequiredArgsConstructor
public class LanguageController {
    private final LanguageService languageService;

    @GetMapping
    public List<Language> getAll() {
        return languageService.getAll();
    }

    @GetMapping("/{id}")
    public Language getById(@PathVariable Long id) {
        return languageService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody Language language) {
        languageService.add(language);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Language language, Long id) {
        languageService.update(id, language);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        languageService.delete(id);
    }
}
