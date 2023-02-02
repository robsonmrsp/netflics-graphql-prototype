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
import br.com.netflics.model.MovieCast;
import br.com.netflics.fixture.FixtureUtils;
import br.com.six2six.fixturefactory.Fixture;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql("classpath:init-data-MovieCast.sql")
public class MovieCastControllerTest {

	@Autowired
	TestRestTemplate testRestTemplate;

	private static final String URL = "/rs/crud/movieCasts";

	@BeforeAll
	public static void setUp() {
		FixtureUtils.init();
	}

	@BeforeEach
	public void before() {
	}

	@Test
	public void testAddMovieCast() throws Exception {

		MovieCast movieCast = Fixture.from(MovieCast.class).gimme("novo");
		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<MovieCast> responseEntity = withBasicAuth.postForEntity(URL, movieCast, MovieCast.class);

		HttpStatus status = responseEntity.getStatusCode();
		MovieCast resultMovieCast = responseEntity.getBody();

		assertEquals("Incorrect Response Status: ", HttpStatus.CREATED, status);
		assertNotNull("A not null gender should be returned: ", resultMovieCast);
		assertNotNull("A not null gender identifier should be returned:", resultMovieCast.getId());
	}

	@Test
	public void testGetMovieCast() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<MovieCast> responseEntity = withBasicAuth.getForEntity(URL + "/{id}", MovieCast.class, new Integer(1));

		HttpStatus status = responseEntity.getStatusCode();
		MovieCast resultMovieCast = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);
		assertNotNull("A not null gender should be returned: ", resultMovieCast);
		assertEquals("A id gender == 1 must be returned: ", resultMovieCast.getId(), new Integer(1));
	}

	@Test
	public void testGetPagerMovieCast() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Pager> responseEntity = withBasicAuth.getForEntity(URL, Pager.class);

		HttpStatus status = responseEntity.getStatusCode();
		Pager<MovieCast> resultPagerMovieCast = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);
		assertNotNull("A not null gender should be returned: ", resultPagerMovieCast);
	}

	@Test
	public void testGetMovieCastNotExist() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<MovieCast> responseEntity = withBasicAuth.getForEntity(URL + "/{id}", MovieCast.class, new Long(100));

		HttpStatus status = responseEntity.getStatusCode();
		MovieCast resultMovieCast = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.NOT_FOUND, status);
		assertNull(resultMovieCast);
	}

	@Test
	public void testGetMovieCastByParameter() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Pager<MovieCast>> responseEntity = withBasicAuth.exchange(URL + "?characterName={characterName}", HttpMethod.GET, null, new ParameterizedTypeReference<Pager<MovieCast>>() {}, "characterName movieCast1");
		Pager<MovieCast> movieCasts = responseEntity.getBody();
		HttpStatus status = responseEntity.getStatusCode();

		movieCasts.getItems().forEach(new Consumer<MovieCast>() {
			@Override
			public void accept(MovieCast movieCast) {
				assertEquals("A not null MovieCast should be returned white the 'name' = 'characterName movieCast1'", movieCast.getCharacterName(), "characterName movieCast1");
			}
		});

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);
		assertTrue("A Array of MovieCast should be returned ", movieCasts.getItems().size() > 0);
	}
	
	@Test
	public void testUpdateMovieCast() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		MovieCast movieCast = Fixture.from(MovieCast.class).gimme("novo");
		movieCast.setId(1);

		HttpEntity<MovieCast> requestEntity = new HttpEntity<MovieCast>(movieCast);

		ResponseEntity<MovieCast> responseEntity = withBasicAuth.exchange(URL + "/{id}", HttpMethod.PUT, requestEntity, MovieCast.class, new Integer(1));

		HttpStatus status = responseEntity.getStatusCode();

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);

	}

	@Test
	public void testDeleteMovieCast() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Boolean> responseEntity = withBasicAuth.exchange(URL + "/{id}", HttpMethod.DELETE, null, Boolean.class, new Integer(1));

		HttpStatus status = responseEntity.getStatusCode();

		ResponseEntity<MovieCast> responseTesteDelete = withBasicAuth.getForEntity(URL + "/{id}", MovieCast.class, new Integer(1));

		HttpStatus responseTesteDeleteStatus = responseTesteDelete.getStatusCode();
		MovieCast resultMovieCast = responseTesteDelete.getBody();

		assertEquals("Incorrect Response Status after delete the movieCast id = 1", HttpStatus.NOT_FOUND, responseTesteDeleteStatus);
		assertNull(resultMovieCast);

		assertEquals("Incorrect Response Status", HttpStatus.NO_CONTENT, status);

	}
	
	@TestConfiguration
	static class MyTestConfig {

	}
}
//generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21