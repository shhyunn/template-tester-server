package codenine.template_tester.platform.controller;

import codenine.template_tester.platform.dto.request.PlatformCreateRequest;
import codenine.template_tester.platform.dto.request.PlatformUpdateRequest;
import codenine.template_tester.platform.dto.response.PlatformResponse;
import codenine.template_tester.platform.entity.Platform;
import codenine.template_tester.platform.service.PlatformService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/platforms")
public class PlatformController {

    private final PlatformService platformService;

    // ✅ Create
    @Operation(summary = "플랫폼 생성", description = "플랫폼을 생성합니다.")
    @PostMapping
    public PlatformResponse create(@RequestBody PlatformCreateRequest request) {
        Platform platform = platformService.create(request);
        return PlatformResponse.from(platform);
    }

    // ✅ Read - 단건 조회
    @Operation(summary = "플랫폼 조회", description = "플랫폼을 조회합니다.")
    @GetMapping("/{id}")
    public PlatformResponse findById(@PathVariable Long id) {
        return PlatformResponse.from(platformService.findById(id));
    }

    // ✅ Read - 전체 조회
    @Operation(summary = "플랫폼 전체 조회", description = "플랫폼 전체 목록을 조회합니다.")
    @GetMapping
    public List<PlatformResponse> findAll() {
        return platformService.findAll()
                .stream()
                .map(PlatformResponse::from)
                .toList();
    }

    // ✅ Update
    @Operation(summary = "플랫폼 갱신", description = "플랫폼 정보를 갱신합니다.")
    @PutMapping("/{id}")
    public PlatformResponse update(
            @PathVariable Long id,
            @RequestBody PlatformUpdateRequest request
    ) {
        Platform platform = platformService.update(id, request);
        return PlatformResponse.from(platform);
    }

    // ✅ Delete
    @Operation(summary = "플랫폼 삭제", description = "플랫폼을 삭제합니다.")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        platformService.delete(id);
    }
}
