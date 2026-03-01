package codenine.template_tester.global.response;

import codenine.template_tester.global.response.BaseResponse;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ApiResponses({

        @ApiResponse(
                responseCode = "200",
                description = "로그인 성공",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = BaseResponse.class),
                        examples = @ExampleObject(
                                name = "success",
                                value = """
                                {
                                  "success": true,
                                  "data": {
                                    "userId": 1,
                                    "email": "test@test.com",
                                    "username": "tester"
                                  },
                                  "message": null
                                }
                                """
                        )
                )
        ),

        @ApiResponse(
                responseCode = "401",
                description = "비밀번호 불일치",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = BaseResponse.class),
                        examples = @ExampleObject(
                                name = "password mismatch",
                                value = """
                                {
                                  "success": false,
                                  "data": null,
                                  "message": "비밀번호가 일치하지 않습니다."
                                }
                                """
                        )
                )
        ),

        @ApiResponse(
                responseCode = "404",
                description = "사용자 없음",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = BaseResponse.class),
                        examples = @ExampleObject(
                                name = "user not found",
                                value = """
                                {
                                  "success": false,
                                  "data": null,
                                  "message": "존재하지 않는 사용자입니다."
                                }
                                """
                        )
                )
        )
})
public @interface AuthApiResponse {
}