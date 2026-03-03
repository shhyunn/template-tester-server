package codenine.template_tester.platform.service;

import codenine.template_tester.platform.dto.request.PlatformCreateRequest;
import codenine.template_tester.platform.dto.request.PlatformUpdateRequest;
import codenine.template_tester.platform.entity.Platform;
import codenine.template_tester.platform.repository.PlatformRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PlatformService {

    private final PlatformRepository platformRepository;

    // ✅ create
    public Platform create(PlatformCreateRequest request) {

        if (platformRepository.existsByName(request.getName())) {
            throw new IllegalArgumentException("이미 존재하는 플랫폼입니다.");
        }

        Platform platform = new Platform(request.getName());
        return platformRepository.save(platform);
    }

    // ✅ update
    public Platform update(Long id, PlatformUpdateRequest request) {

        Platform platform = platformRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Platform not found"));

        platform.update(request.getName());

        return platform; // dirty checking으로 자동 update
    }

    // ✅ delete
    public void delete(Long id) {

        if (!platformRepository.existsById(id)) {
            throw new IllegalArgumentException("Platform not found");
        }

        platformRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Platform> findAll() {
        return platformRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Platform findById(Long id) {
        return platformRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Platform not found"));
    }
}