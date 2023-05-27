package steammachinist.langcourses.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import steammachinist.langcourses.dto.Language;
import steammachinist.langcourses.mapper.LanguageMapper;
import steammachinist.langcourses.repository.LanguageRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LanguageService {
    private final LanguageRepository languageRepository;
    private final LanguageMapper languageMapper;

    public List<Language> getAll() {
        return languageRepository.findAll().stream().map(languageMapper::toLanguage).collect(Collectors.toList());
    }

    public Language getById(Long id) {
        return languageRepository.findById(id).map(languageMapper::toLanguage).orElseThrow(EntityNotFoundException::new);
    }

    public void add(Language language) {
        languageRepository.save(languageMapper.toLanguageEntity(language));
    }

    public void update(Long id, Language language) {
        Language old = getById(id);
        old.setName(language.getName());
        languageRepository.save(languageMapper.toLanguageEntity(old));
    }

    public void delete(Long id) {
        languageRepository.delete(languageMapper.toLanguageEntity(getById(id)));
    }
}
