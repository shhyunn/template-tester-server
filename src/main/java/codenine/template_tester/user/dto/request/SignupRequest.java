package codenine.template_tester.user.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class SignupRequest {

    @Schema(description = "이메일", example = "test@test.com")
    private String email;

    @Schema(description = "닉네임", example = "tester")
    private String username;

    @Schema(description = "비밀번호", example = "1234")
    private String password;
}
