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
import br.com.netflics.model.Keyword;
import br.com.netflics.fixture.FixtureUtils;
import br.com.six2six.fixturefactory.Fixture;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql("classpath:init-data-Keyword.sql")
public class KeywordControllerTest {

	@Autowired
	TestRestTemplate testRestTemplate;

	private static final String URL = "/rs/crud/keywords";

	@BeforeAll
	public static void setUp() {
		FixtureUtils.init();
	}

	@BeforeEach
	public void before() {
	}

	@Test
	public void testAddKeyword() throws Exception {

		Keyword keyword = Fixture.from(Keyword.class).gimme("novo");
		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Keyword> responseEntity = withBasicAuth.postForEntity(URL, keyword, Keyword.class);

		HttpStatus status = responseEntity.getStatusCode();
		Keyword resultKeyword = responseEntity.getBody();

		assertEquals("Incorrect Response Status: ", HttpStatus.CREATED, status);
		assertNotNull("A not null gender should be returned: ", resultKeyword);
		assertNotNull("A not null gender identifier should be returned:", resultKeyword.getId());
	}

	@Test
	public void testGetKeyword() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Keyword> responseEntity = withBasicAuth.getForEntity(URL + "/{id}", Keyword.class, new Integer(1));

		HttpStatus status = responseEntity.getStatusCode();
		Keyword resultKeyword = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);
		assertNotNull("A not null gender should be returned: ", resultKeyword);
		assertEquals("A id gender == 1 must be returned: ", resultKeyword.getId(), new Integer(1));
	}

	@Test
	public void testGetPagerKeyword() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Pager> responseEntity = withBasicAuth.getForEntity(URL, Pager.class);

		HttpStatus status = responseEntity.getStatusCode();
		Pager<Keyword> resultPagerKeyword = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);
		assertNotNull("A not null gender should be returned: ", resultPagerKeyword);
	}

	@Test
	public void testGetKeywordNotExist() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Keyword> responseEntity = withBasicAuth.getForEntity(URL + "/{id}", Keyword.class, new Long(100));

		HttpStatus status = responseEntity.getStatusCode();
		Keyword resultKeyword = responseEntity.getBody();

		assertEquals("Incorrect Response Status", HttpStatus.NOT_FOUND, status);
		assertNull(resultKeyword);
	}

	@Test
	public void testGetKeywordByParameter() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Pager<Keyword>> responseEntity = withBasicAuth.exchange(URL + "?name={name}", HttpMethod.GET, null, new ParameterizedTypeReference<Pager<Keyword>>() {}, "name keyword1");
		Pager<Keyword> keywords = responseEntity.getBody();
		HttpStatus status = responseEntity.getStatusCode();

		keywords.getItems().forEach(new Consumer<Keyword>() {
			@Override
			public void accept(Keyword keyword) {
				assertEquals("A not null Keyword should be returned white the 'name' = 'name keyword1'", keyword.getName(), "name keyword1");
			}
		});

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);
		assertTrue("A Array of Keyword should be returned ", keywords.getItems().size() > 0);
	}
	
	@Test
	public void testUpdateKeyword() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		Keyword keyword = Fixture.from(Keyword.class).gimme("novo");
		keyword.setId(1);

		HttpEntity<Keyword> requestEntity = new HttpEntity<Keyword>(keyword);

		ResponseEntity<Keyword> responseEntity = withBasicAuth.exchange(URL + "/{id}", HttpMethod.PUT, requestEntity, Keyword.class, new Integer(1));

		HttpStatus status = responseEntity.getStatusCode();

		assertEquals("Incorrect Response Status", HttpStatus.OK, status);

	}

	@Test
	public void testDeleteKeyword() throws Exception {

		TestRestTemplate withBasicAuth = testRestTemplate.withBasicAuth("jsetup", "123456");

		ResponseEntity<Boolean> responseEntity = withBasicAuth.exchange(URL + "/{id}", HttpMethod.DELETE, null, Boolean.class, new Integer(1));

		HttpStatus status = responseEntity.getStatusCode();

		ResponseEntity<Keyword> responseTesteDelete = withBasicAuth.getForEntity(URL + "/{id}", Keyword.class, new Integer(1));

		HttpStatus responseTesteDeleteStatus = responseTesteDelete.getStatusCode();
		Keyword resultKeyword = responseTesteDelete.getBody();

		assertEquals("Incorrect Response Status after delete the keyword id = 1", HttpStatus.NOT_FOUND, responseTesteDeleteStatus);
		assertNull(resultKeyword);

		assertEquals("Incorrect Response Status", HttpStatus.NO_CONTENT, status);

	}
	
	@TestConfiguration
	static class MyTestConfig {

	}
}
//generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21