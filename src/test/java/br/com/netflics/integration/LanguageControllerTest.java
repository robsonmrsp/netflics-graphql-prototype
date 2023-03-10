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
import br.com.netflics.model.Language;
import br.com.netflics.fixture.FixtureUtils;
import br.com.six2six.fixturefactory.Fixture;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql("classpath:init-data-Language.sql")
public class LanguageControllerTest {

	@Autowired
	TestRestTemplate testRestTemplate;

	private static final String URL = "/rs/crud/languages";

	@BeforeAll
	public static void setUp() {
		FixtureUtils.init();
	}

	@BeforeEach
	public void before() {
	}

	@Test
	public void testAddLanguage() throws Exception {

		Language language = Fixture.from(Language.class).gimme("novo");
		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Language> responseEntity = withBasicAuth.postForEntity(URL, language, Language.class);

		HttpStatus status = responseEntity.getStatusCode();
		Language resultLanguage = responseEntity.getBody();

		assertEquals("Incorrect Response Status: ", HttpStatus.CREATED, status);
		assertNotNull("A not null gender should be returned: ", resultLanguage);
		assertNotNull("A not null gender identifier should be returned:", resultLanguage.getId());
	}

	@Test
	public void testGetLanguage() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Language> responseEntity = withBasicAuth.getForEntity(URL + "/{id}", Language.class, new Integer(1));

		HttpStatus status = responseEntity.getStatusCode();
		Language resultLanguage = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);
		assertNotNull("A not null gender should be returned: ", resultLanguage);
		assertEquals("A id gender == 1 must be returned: ", resultLanguage.getId(), new Integer(1));
	}

	@Test
	public void testGetPagerLanguage() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Pager> responseEntity = withBasicAuth.getForEntity(URL, Pager.class);

		HttpStatus status = responseEntity.getStatusCode();
		Pager<Language> resultPagerLanguage = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);
		assertNotNull("A not null gender should be returned: ", resultPagerLanguage);
	}

	@Test
	public void testGetLanguageNotExist() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Language> responseEntity = withBasicAuth.getForEntity(URL + "/{id}", Language.class, new Long(100));

		HttpStatus status = responseEntity.getStatusCode();
		Language resultLanguage = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.NOT_FOUND, status);
		assertNull(resultLanguage);
	}

	@Test
	public void testGetLanguageByParameter() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Pager<Language>> responseEntity = withBasicAuth.exchange(URL + "?code={code}", HttpMethod.GET, null, new ParameterizedTypeReference<Pager<Language>>() {}, "code language1");
		Pager<Language> languages = responseEntity.getBody();
		HttpStatus status = responseEntity.getStatusCode();

		languages.getItems().forEach(new Consumer<Language>() {
			@Override
			public void accept(Language language) {
				assertEquals("A not null Language should be returned white the 'name' = 'code language1'", language.getCode(), "code language1");
			}
		});

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);
		assertTrue("A Array of Language should be returned ", languages.getItems().size() > 0);
	}
	
	@Test
	public void testUpdateLanguage() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		Language language = Fixture.from(Language.class).gimme("novo");
		language.setId(1);

		HttpEntity<Language> requestEntity = new HttpEntity<Language>(language);

		ResponseEntity<Language> responseEntity = withBasicAuth.exchange(URL + "/{id}", HttpMethod.PUT, requestEntity, Language.class, new Integer(1));

		HttpStatus status = responseEntity.getStatusCode();

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);

	}

	@Test
	public void testDeleteLanguage() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Boolean> responseEntity = withBasicAuth.exchange(URL + "/{id}", HttpMethod.DELETE, null, Boolean.class, new Integer(1));

		HttpStatus status = responseEntity.getStatusCode();

		ResponseEntity<Language> responseTesteDelete = withBasicAuth.getForEntity(URL + "/{id}", Language.class, new Integer(1));

		HttpStatus responseTesteDeleteStatus = responseTesteDelete.getStatusCode();
		Language resultLanguage = responseTesteDelete.getBody();

		assertEquals("Incorrect Response Status after delete the language id = 1", HttpStatus.NOT_FOUND, responseTesteDeleteStatus);
		assertNull(resultLanguage);

		assertEquals("Incorrect Response Status", HttpStatus.NO_CONTENT, status);

	}
	
	@TestConfiguration
	static class MyTestConfig {

	}
}
//generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21