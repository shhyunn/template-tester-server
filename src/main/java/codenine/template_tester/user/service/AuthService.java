package codenine.template_tester.user.service;

import codenine.template_tester.global.exception.BaseException;
import codenine.template_tester.user.dto.request.LoginRequest;
import codenine.template_tester.user.dto.request.SignupRequest;
import codenine.template_tester.user.dto.response.AuthResponse;
import codenine.template_tester.user.entity.User;
import codenine.template_tester.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    // 회원가입
    public AuthResponse signup(SignupRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("이미 존재하는 이메일");
        }

        User user = new User(
                request.getEmail(),
                request.getUsername(),
                request.getPassword()
        );

        User saved = userRepository.save(user);

        return new AuthResponse(
                saved.getId(),
                saved.getEmail(),
                saved.getUsername()
        );
    }

    // 로그인

    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new BaseException("존재하지 않는 사용자입니다.", HttpStatus.NOT_FOUND));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new BaseException("비밀번호가 일치하지 않습니다.", HttpStatus.UNAUTHORIZED);
        }

        return new AuthResponse(
                user.getId(),
                user.getEmail(),
                user.getUsername()
        );
    }

    // 로그아웃 (JWT 전이라 의미 없음)
    public void logout() {
        // 나중에 JWT blacklist or session 처리
    }
}
