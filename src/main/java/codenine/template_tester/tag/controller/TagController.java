package codenine.template_tester.tag.controller;
import codenine.template_tester.tag.dto.request.TagCreateRequest;
import codenine.template_tester.tag.dto.request.TagUpdateRequest;
import codenine.template_tester.tag.dto.response.TagResponse;
import codenine.template_tester.tag.service.TagService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tags")
public class TagController {

    private final TagService tagService;

    @Operation(summary = "태그 생성", description = "태그를 생성합니다.")
    @PostMapping
    public TagResponse create(@RequestBody TagCreateRequest request) {
        return TagResponse.from(tagService.create(request));
    }

    @Operation(summary = "태그 목록 반환", description = "태그 목록을 반환합니다.")
    @GetMapping
    public List<TagResponse> findAll() {
        return tagService.findAll()
                .stream()
                .map(TagResponse::from)
                .toList();
    }

    @Operation(summary = "태그 갱신", description = "태그 정보를 갱신합니다.")
    @PutMapping("/{id}")
    public TagResponse update(
            @PathVariable Long id,
            @RequestBody TagUpdateRequest request
    ) {
        return TagResponse.from(tagService.update(id, request));
    }

    @Operation(summary = "태그 삭제", description = "태그를 삭제합니다.")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tagService.delete(id);
    }
}
