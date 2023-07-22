package com.adgile.controller;

import com.adgile.exceptions.BusinessException;
import com.adgile.exceptions.ErrorCode;
import com.adgile.util.ApiResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

	private static final Logger logger = LogManager.getLogger(ExceptionController.class);

	@ExceptionHandler(BusinessException.class)
	public ApiResponse<Object> handleBusinessException(BusinessException e) {

		final ErrorCode errorCode = e.getErrorCode();

		logger.error("BusinessException 발생");

		return ApiResponse.error(String.valueOf(errorCode.getCode()), errorCode.getMessage());
	}
}
