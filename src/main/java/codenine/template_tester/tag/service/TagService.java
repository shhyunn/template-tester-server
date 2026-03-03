package codenine.template_tester.tag.service;

import codenine.template_tester.tag.dto.request.TagCreateRequest;
import codenine.template_tester.tag.dto.request.TagUpdateRequest;
import codenine.template_tester.tag.entity.Tag;
import codenine.template_tester.tag.entity.TagType;
import codenine.template_tester.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TagService {

    private final TagRepository tagRepository;

    //create
    public Tag create(TagCreateRequest request) {

        if (tagRepository.existsByNameAndType(request.getName(), request.getType())) {
            throw new IllegalArgumentException("이미 존재하는 태그입니다.");
        }

        Tag tag = new Tag(request.getName(), request.getType());
        return tagRepository.save(tag);
    }

    //update
    public Tag update(Long id, TagUpdateRequest request) {
        Tag tag = findById(id);

        tag.update(request.getName(), request.getType());

        return tag;
    }

    //delete
    public void delete(Long id) {
        tagRepository.deleteById(id);
    }

    //타입에 따른 태그 찾기
    @Transactional(readOnly = true)
    public List<Tag> getTagsByType(TagType type) {
        return tagRepository.findByType(type);
    }

    //모든 Tag 리스트 찾기
    @Transactional(readOnly = true)
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    //id에 따른 Tag 찾기
    @Transactional(readOnly = true)
    public Tag findById(Long id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tag not found"));
    }

}
