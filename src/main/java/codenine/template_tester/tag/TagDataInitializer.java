package codenine.template_tester.tag;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import codenine.template_tester.tag.entity.Tag;
import codenine.template_tester.tag.entity.TagType;
import codenine.template_tester.tag.repository.TagRepository;

@Configuration
@RequiredArgsConstructor
public class TagDataInitializer {

    private final TagRepository tagRepository;

    @Bean
    public ApplicationRunner initTags() {
        return args -> {

            if (tagRepository.count() > 0) {
                return; // 이미 데이터 있으면 안 넣음
            }

            tagRepository.save(new Tag("python", TagType.LANGUAGE));
            tagRepository.save(new Tag("java", TagType.LANGUAGE));
            tagRepository.save(new Tag("c", TagType.LANGUAGE));
            tagRepository.save(new Tag("c++", TagType.LANGUAGE));
            tagRepository.save(new Tag("javascript", TagType.LANGUAGE));
        };
    }
}