package com.example.demo.exception;

/**
 * 찾을 수 없는 요청이 발생한 예외를 던집니다.
 */
public class NotFoundException extends RuntimeException {

    /**
     * 지정된 상세 메시지로 새 NotFoundException을 구성합니다.
     *
     * @param message 상세 메시지
     */
    public NotFoundException(String message) {
        super(message);
    }
}
