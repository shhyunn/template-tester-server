package codenine.template_tester.tag.repository;

import codenine.template_tester.tag.entity.Tag;
import codenine.template_tester.tag.entity.TagType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {

    List<Tag> findByType(TagType type); //findBy필드명

    boolean existsByNameAndType(String name, TagType type);
}