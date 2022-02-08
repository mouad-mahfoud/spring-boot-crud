package com.demo.app.ws.dto.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class AddAgencyRequest {

    @NotNull
    String name;

    @NotNull
    @Positive
    int cityId;
}
