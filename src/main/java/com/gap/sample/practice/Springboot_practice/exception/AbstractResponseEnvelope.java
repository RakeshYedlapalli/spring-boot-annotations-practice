package com.gap.sample.practice.Springboot_practice.exception;

import lombok.*;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractResponseEnvelope {
    protected int httpStatus;
    protected String requestId;
}
