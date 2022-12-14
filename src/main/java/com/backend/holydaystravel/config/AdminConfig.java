package com.backend.holydaystravel.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class AdminConfig {
    @Value("${admin.email}")
    private String adminEmail;
    @Value("${admin.name}")
    private String adminName;
}
