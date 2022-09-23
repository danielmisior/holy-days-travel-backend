package com.backend.holydaystravel.opentripmap.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Preview {
    private String source;
    private int height;
    private int width;
}
