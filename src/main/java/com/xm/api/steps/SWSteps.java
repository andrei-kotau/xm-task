package com.xm.api.steps;

import com.xm.api.models.Film;
import com.xm.api.models.PagedResponse;
import com.xm.api.models.Person;
import com.xm.api.restclients.SWApiRestClient;
import io.restassured.common.mapper.TypeRef;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SWSteps {

    private final SWApiRestClient swRestClient = new SWApiRestClient();

    /**
     * @return list of films sorted by 'release date' in descending order (FIRST one - the LATEST one)
     */
    public List<Film> getAllFilmsSortedByReleaseDate() {
        log.info("Get all films sorted by released date");

        var films = getAllFilms().getResults();
        films.sort(Comparator.comparing(Film::getReleaseDate).reversed());
        return films;
    }

    public PagedResponse<Film> getAllFilms() {
        log.info("Get all available SW films");
        var filmsResponse = swRestClient.getFilms();
        assertThat(filmsResponse.statusCode()).isEqualTo(200);

        var films = swRestClient.getFilms().as(new TypeRef<PagedResponse<Film>>() {
        });
        log.debug("Total films count is {}", films.getCount());
        return films;
    }

    /**
     * @return list of people sorted by 'height' in descending order (FIRST one - the TALLEST one)
     */
    public List<Person> getPeopleSortedByHeight(List<String> peopleIds) {
        log.info("Get people sorted by Height");

        var people = getPeople(peopleIds);
        people.sort(Comparator.comparingInt(Person::getHeightAsInt).reversed());
        return people;
    }

    public List<Person> getPeople(List<String> peopleIds) {
        log.info("Get people by IDs list provided");

        var people = new ArrayList<Person>();
        peopleIds.forEach(id -> {
            var personResponse = swRestClient.getPerson(id);
            assertThat(personResponse.statusCode()).isEqualTo(200);

            people.add(swRestClient.getPerson(id).as(Person.class));
        });
        log.debug("Got {} people in total", people.size());
        return people;
    }

    public List<Person> getAllPeopleSortedByHeight() {
        log.info("Get all SW people and characters sorted by Height");

        var people = getAllPeople();
        people.sort(Comparator.comparingInt(Person::getHeightAsInt).reversed());
        return people;
    }

    public List<Person> getAllPeople() {
        log.info("Get all SW people and characters");

        var allPeoplePaged = swRestClient.getAllPeople().as(new TypeRef<PagedResponse<Person>>() {
        });
        var allPeople = new ArrayList<>(allPeoplePaged.getResults());
        while (allPeoplePaged.getNext() != null) {
            allPeoplePaged = swRestClient.getResponseByUrl(allPeoplePaged.getNext()).as(new TypeRef<>() {
            });
            allPeople.addAll(allPeoplePaged.getResults());
        }
        log.debug("Got {} SW people in total", allPeople.size());
        return allPeople;
    }
}
