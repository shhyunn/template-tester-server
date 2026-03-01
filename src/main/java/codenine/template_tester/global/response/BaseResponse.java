package codenine.template_tester.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseResponse<T> {

    private boolean success;
    private T data;
    private String message;

    // 성공 응답
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(true, data, null);
    }

    // 성공 + 메시지
    public static <T> BaseResponse<T> success(T data, String message) {
        return new BaseResponse<>(true, data, message);
    }

    // 실패 응답
    public static <T> BaseResponse<T> fail(String message) {
        return new BaseResponse<>(false, null, message);
    }
}
