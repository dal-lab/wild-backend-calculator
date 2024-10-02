package com.example.demo.exception;

/**
 * 응답 작성 중 발생한 예외를 나타냅니다.
 */
public class ResponseWriteException extends RuntimeException {

    /**
     * 지정된 상세 메시지로 새 ResponseWriteException을 구성합니다.
     *
     * @param message 상세 메시지
     */
    public ResponseWriteException(String message) {
       super(message);
    }
}
