package com.xm.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
    private String name;
    private String height;

    public int getHeightAsInt() {
        try {
            return Integer.parseInt(height);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
