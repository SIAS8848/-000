package com.novel.novel.handler;

import com.novel.novel.common.exception.NovelException;
import com.novel.novel.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理器
 *
 *
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 自定义异常处理
     *
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(NovelException.class)
    public R msgExceptionHandler(HttpServletRequest request, NovelException ex){
        log.error("NovelException:",ex);
        return R.error(ex.getCode(), ex.getMsg());
    }

    /**
     * 处理全局异常(Exception)
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public R handleException(HttpServletRequest request, Exception e){
        log.error("Exception:",e);
        return R.error(500, "系统异常");
    }

}
