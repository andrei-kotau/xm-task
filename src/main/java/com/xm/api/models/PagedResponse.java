package com.xm.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PagedResponse<T> {

    private int count;

    private String next;

    private String previous;

    private List<T> results;
}
