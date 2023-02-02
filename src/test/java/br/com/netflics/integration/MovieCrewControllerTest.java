/** generated: 1 de fev de 2023 23:43:21 **/
package br.com.netflics.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.function.Consumer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.netflics.core.persistence.pagination.Pager;
import br.com.netflics.model.MovieCrew;
import br.com.netflics.fixture.FixtureUtils;
import br.com.six2six.fixturefactory.Fixture;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql("classpath:init-data-MovieCrew.sql")
public class MovieCrewControllerTest {

	@Autowired
	TestRestTemplate testRestTemplate;

	private static final String URL = "/rs/crud/movieCrews";

	@BeforeAll
	public static void setUp() {
		FixtureUtils.init();
	}

	@BeforeEach
	public void before() {
	}

	@Test
	public void testAddMovieCrew() throws Exception {

		MovieCrew movieCrew = Fixture.from(MovieCrew.class).gimme("novo");
		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<MovieCrew> responseEntity = withBasicAuth.postForEntity(URL, movieCrew, MovieCrew.class);

		HttpStatus status = responseEntity.getStatusCode();
		MovieCrew resultMovieCrew = responseEntity.getBody();

		assertEquals("Incorrect Response Status: ", HttpStatus.CREATED, status);
		assertNotNull("A not null gender should be returned: ", resultMovieCrew);
		assertNotNull("A not null gender identifier should be returned:", resultMovieCrew.getId());
	}

	@Test
	public void testGetMovieCrew() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<MovieCrew> responseEntity = withBasicAuth.getForEntity(URL + "/{id}", MovieCrew.class, new Integer(1));

		HttpStatus status = responseEntity.getStatusCode();
		MovieCrew resultMovieCrew = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);
		assertNotNull("A not null gender should be returned: ", resultMovieCrew);
		assertEquals("A id gender == 1 must be returned: ", resultMovieCrew.getId(), new Integer(1));
	}

	@Test
	public void testGetPagerMovieCrew() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Pager> responseEntity = withBasicAuth.getForEntity(URL, Pager.class);

		HttpStatus status = responseEntity.getStatusCode();
		Pager<MovieCrew> resultPagerMovieCrew = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);
		assertNotNull("A not null gender should be returned: ", resultPagerMovieCrew);
	}

	@Test
	public void testGetMovieCrewNotExist() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<MovieCrew> responseEntity = withBasicAuth.getForEntity(URL + "/{id}", MovieCrew.class, new Long(100));

		HttpStatus status = responseEntity.getStatusCode();
		MovieCrew resultMovieCrew = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.NOT_FOUND, status);
		assertNull(resultMovieCrew);
	}

	@Test
	public void testGetMovieCrewByParameter() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Pager<MovieCrew>> responseEntity = withBasicAuth.exchange(URL + "?job={job}", HttpMethod.GET, null, new ParameterizedTypeReference<Pager<MovieCrew>>() {}, "job movieCrew1");
		Pager<MovieCrew> movieCrews = responseEntity.getBody();
		HttpStatus status = responseEntity.getStatusCode();

		movieCrews.getItems().forEach(new Consumer<MovieCrew>() {
			@Override
			public void accept(MovieCrew movieCrew) {
				assertEquals("A not null MovieCrew should be returned white the 'name' = 'job movieCrew1'", movieCrew.getJob(), "job movieCrew1");
			}
		});

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);
		assertTrue("A Array of MovieCrew should be returned ", movieCrews.getItems().size() > 0);
	}
	
	@Test
	public void testUpdateMovieCrew() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		MovieCrew movieCrew = Fixture.from(MovieCrew.class).gimme("novo");
		movieCrew.setId(1);

		HttpEntity<MovieCrew> requestEntity = new HttpEntity<MovieCrew>(movieCrew);

		ResponseEntity<MovieCrew> responseEntity = withBasicAuth.exchange(URL + "/{id}", HttpMethod.PUT, requestEntity, MovieCrew.class, new Integer(1));

		HttpStatus status = responseEntity.getStatusCode();

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);

	}

	@Test
	public void testDeleteMovieCrew() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Boolean> responseEntity = withBasicAuth.exchange(URL + "/{id}", HttpMethod.DELETE, null, Boolean.class, new Integer(1));

		HttpStatus status = responseEntity.getStatusCode();

		ResponseEntity<MovieCrew> responseTesteDelete = withBasicAuth.getForEntity(URL + "/{id}", MovieCrew.class, new Integer(1));

		HttpStatus responseTesteDeleteStatus = responseTesteDelete.getStatusCode();
		MovieCrew resultMovieCrew = responseTesteDelete.getBody();

		assertEquals("Incorrect Response Status after delete the movieCrew id = 1", HttpStatus.NOT_FOUND, responseTesteDeleteStatus);
		assertNull(resultMovieCrew);

		assertEquals("Incorrect Response Status", HttpStatus.NO_CONTENT, status);

	}
	
	@TestConfiguration
	static class MyTestConfig {

	}
}
//generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21