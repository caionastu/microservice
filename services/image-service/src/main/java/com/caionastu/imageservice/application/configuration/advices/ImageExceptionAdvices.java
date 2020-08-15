package com.caionastu.imageservice.application.configuration.advices;

import com.caionastu.core.advices.AdviceHandler;
import com.caionastu.core.advices.ExceptionAdvices;
import com.caionastu.core.error.ErrorBlock;
import com.caionastu.imageservice.application.ErrorKeys;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Mono;

@RestControllerAdvice
@Component
public class ImageExceptionAdvices extends ExceptionAdvices {

    public ImageExceptionAdvices(AdviceHandler adviceHandler) {
        super(adviceHandler);
    }

    @ExceptionHandler(WebExchangeBindException.class)
    public Mono<ResponseEntity<ErrorBlock>> webExchangeBindExceptionHandler(WebExchangeBindException exception) {
        return adviceHandler.handleWebExchangeBindException(exception, ErrorKeys.Common.ENTITY_FAIL_REQUIREMENT);
    }

}
