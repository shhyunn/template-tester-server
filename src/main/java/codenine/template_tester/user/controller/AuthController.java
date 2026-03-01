package codenine.template_tester.user.controller;
import codenine.template_tester.global.response.AuthApiResponse;
import codenine.template_tester.global.response.BaseResponse;
import codenine.template_tester.user.dto.request.LoginRequest;
import codenine.template_tester.user.dto.request.SignupRequest;
import codenine.template_tester.user.dto.response.AuthResponse;
import codenine.template_tester.user.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "회원가입", description = "새로운 유저를 생성합니다.")
    @PostMapping("/signup")
    public AuthResponse signup(@RequestBody SignupRequest request) {
        return authService.signup(request);
    }

    @Operation(summary = "로그인", description = "로그인합니다.")
    @AuthApiResponse
    @PostMapping("/login")
    public BaseResponse<AuthResponse> login(
            @RequestBody LoginRequest request
    ) {
        return BaseResponse.success(authService.login(request));
    }

    @Operation(summary = "로그아웃", description = "로그아웃합니다.")
    @PostMapping("/logout")
    public void logout() {
        authService.logout();
    }
}
