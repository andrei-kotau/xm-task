package com.xm.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Film {
    private String title;

    @JsonProperty("episode_id")
    private int episodeId;

    @JsonProperty("opening_crawl")
    private String openingCrawl;

    private String director;

    private String producer;

    @JsonProperty("release_date")
    private Date releaseDate;

    private List<String> characters;

    private List<String> planets;

    private List<String> starships;

    private List<String> vehicles;

    private List<String> species;

    private Date created;

    private Date edited;

    private String url;

    public List<String> getCharactersIds() {
        var ids = new ArrayList<String>();

        getCharacters().forEach(ch -> {
            var choppedUrl = StringUtils.chop(ch);
            ids.add(choppedUrl.substring(choppedUrl.lastIndexOf("/") + 1));
        });

        return ids;
    }
}
