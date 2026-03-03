package codenine.template_tester.platform.dto.response;

import codenine.template_tester.platform.entity.Platform;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlatformResponse {

    private Long id;
    private String name;

    public static PlatformResponse from(Platform platform) {
        return new PlatformResponse(
                platform.getId(),
                platform.getName()
        );
    }
}