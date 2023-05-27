package steammachinist.langcourses.mapper;

import org.mapstruct.Mapper;
import steammachinist.langcourses.dto.Language;
import steammachinist.langcourses.entity.LanguageEntity;

@Mapper(componentModel = "spring")
public interface LanguageMapper {
    LanguageEntity toLanguageEntity(Language language);

    Language toLanguage(LanguageEntity languageEntity);
}
