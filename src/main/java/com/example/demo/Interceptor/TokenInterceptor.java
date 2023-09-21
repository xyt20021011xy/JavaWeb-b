package com.example.demo.Interceptor;

import com.example.demo.Util.JwtToken;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在此处编写验证Token的逻辑
        if(!(handler instanceof HandlerMethod))
            return true;
        // 例如从请求头中获取Token，并进行验证
        String token = request.getHeader("Authorization");
        try{
            // 验证成功
            Claims claims = JwtToken.parseJWT(token);
            String username = claims.get("username").toString();
            log.info("username:{}",username);
            return true;
        }catch (Exception e){
            // 验证失败
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json"); // 设置响应类型为JSON
            response.setCharacterEncoding("UTF-8"); // 设置响应编码为UTF-8
            // 返回错误信息
            String errorMessage = "token验证失败";
            response.getWriter().write(errorMessage);
            return false;
        }
    }


}
