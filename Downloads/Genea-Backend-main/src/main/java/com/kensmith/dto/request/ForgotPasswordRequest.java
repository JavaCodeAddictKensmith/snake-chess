package com.kensmith.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ForgotPasswordRequest {
    private String email;
}
