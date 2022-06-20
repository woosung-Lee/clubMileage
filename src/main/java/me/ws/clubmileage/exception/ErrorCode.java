package me.ws.clubmileage.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum  ErrorCode {

    NOTEMPTY_CONTENT(400, "CM001", "Content is mandatory."),
    DUPLICATE_REVIEW(409, "CM002", "A review has already been registered.");

    private int status;
    private String code;
    private String message;
    private String detail;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
