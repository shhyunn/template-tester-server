package codenine.template_tester.global.exception;

import codenine.template_tester.global.response.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseResponse<Void>> handleLoginException(
            BaseException e
    ) {
        return ResponseEntity
                .status(e.getStatus())
                .body(BaseResponse.fail(e.getMessage()));
    }
}