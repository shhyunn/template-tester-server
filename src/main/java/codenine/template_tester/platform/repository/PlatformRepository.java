package codenine.template_tester.platform.repository;
import codenine.template_tester.platform.entity.Platform;
import codenine.template_tester.tag.entity.TagType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository extends JpaRepository<Platform, Long> {
    boolean existsByName(String name);
}

//기본 제공
//Optional<Platform> findById(Long id);
//List<Platform> findAll();
//List<Platform> findAllById(Iterable<Long> ids);
//boolean existsById(Long id);
//boolean existsById(Long id);
//long count();