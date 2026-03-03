package codenine.template_tester.tag.controller;

import codenine.template_tester.tag.dto.*;
import codenine.template_tester.tag.dto.request.TagCreateRequest;
import codenine.template_tester.tag.dto.request.TagUpdateRequest;
import codenine.template_tester.tag.dto.response.TagResponse;
import codenine.template_tester.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/tags")
public class TagAdminController {

    private final TagService tagService;

    @PostMapping
    public TagResponse create(@RequestBody TagCreateRequest request) {
        return TagResponse.from(tagService.create(request));
    }

    @GetMapping
    public List<TagResponse> findAll() {
        return tagService.findAll()
                .stream()
                .map(TagResponse::from)
                .toList();
    }

    @PutMapping("/{id}")
    public TagResponse update(
            @PathVariable Long id,
            @RequestBody TagUpdateRequest request
    ) {
        return TagResponse.from(tagService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tagService.delete(id);
    }
}
