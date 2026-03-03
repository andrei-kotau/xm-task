package com.xm.tests;

import com.xm.api.restclients.SWApiRestClient;
import com.xm.api.steps.SWSteps;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SWApiTest {
    private final SWSteps swSteps = new SWSteps();

    @Test
    public void swApiTest() {

        log.info("Use case #1");
        log.info("Find the film with latest release date");

        var films = swSteps.getAllFilmsSortedByReleaseDate();
        assertThat(films.size()).isGreaterThan(0);

        var latestFilm = films.get(0);
        log.info("Latest film is '{}' and it was released in {}", latestFilm.getTitle(),
                new SimpleDateFormat("yyyy-MM-dd").format(latestFilm.getReleaseDate()));

        log.info("Use case #2");
        log.info("Using previous response find the tallest person among the characters that were part of that film");
        var peopleFromLatestFilm = swSteps.getPeopleSortedByHeight(latestFilm.getCharactersIds());
        assertThat(peopleFromLatestFilm.size()).isGreaterThan(0);

        var tallestPerson = peopleFromLatestFilm.get(0);
        log.info("Tallest person from '{}' is {} with height {}", latestFilm.getTitle(), tallestPerson.getName(),
                tallestPerson.getHeight());

        log.info("Use case #3");
        log.info("Find the tallest person ever played in any Star Wars film");
        var allSWCharacters = swSteps.getAllPeopleSortedByHeight();
        assertThat(allSWCharacters.size()).isGreaterThan(0);

        var tallestEverPerson = allSWCharacters.get(0);
        log.info("Tallest person in SW is {} with height {}", tallestEverPerson.getName(), tallestEverPerson.getHeight());
    }

    @Test
    public void swSchemaTest() {
        log.info("Create contract test (Json schema validation)  for /people API");

        // -------------------------------------------------------------------
        // schema is NOT available for SW api, following request returns 404
        // -------------------------------------------------------------------
        var response = new SWApiRestClient().getResponseByUrl("https://swapi.dev/api/people/schema");
        assertThat(response.statusCode()).isEqualTo(200);
    }
}
