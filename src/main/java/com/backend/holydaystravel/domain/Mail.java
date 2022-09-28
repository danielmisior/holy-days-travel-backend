package com.backend.holydaystravel.domain;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public final class Mail {
    private final String mailTo;
    private final String subject;
    private final String message;
}
