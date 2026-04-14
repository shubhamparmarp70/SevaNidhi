package org.example.sevanidhi.audit;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.example.sevanidhi.dto.LoginRequest;
import org.example.sevanidhi.dto.RegisterRequest;
import org.example.sevanidhi.service.AuditService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class AuditAspect {

    private final AuditService auditService;

    public AuditAspect(AuditService auditService) {
        this.auditService = auditService;
    }

    @AfterReturning("execution(* org.example.sevanidhi.service.impl.AuthServiceImpl.login(..))")
    public void logLogin(JoinPoint joinPoint) {

        LoginRequest loginRequest = (LoginRequest) joinPoint.getArgs()[0];
        String username = loginRequest.getEmail();

        String ip = getClientIp();

        auditService.log(username, "User Login", ip);
    }

    @AfterReturning("execution(* org.example.sevanidhi.service.impl.AuthServiceImpl.register(..))")
    public void logRegistration(@org.jetbrains.annotations.NotNull JoinPoint joinPoint) {

        RegisterRequest registerRequest = (RegisterRequest) joinPoint.getArgs()[0];
        String username = registerRequest.getEmail();

        String ip = getClientIp();

        auditService.log(username, "User Registered", ip);
    }

    private String getClientIp() {
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        if (attributes == null) {
            return "UNKNOWN";
        }

        HttpServletRequest request = attributes.getRequest();
        return request.getRemoteAddr();
    }

}