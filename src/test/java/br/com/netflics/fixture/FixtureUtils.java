package br.com.netflics.fixture;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

import br.com.netflics.model.Department;
import br.com.netflics.model.Movie;
import br.com.netflics.model.Genre;
import br.com.netflics.model.MovieCast;
import br.com.netflics.model.Language;
import br.com.netflics.model.Country;
import br.com.netflics.model.Keyword;
import br.com.netflics.model.Gender;
import br.com.netflics.model.MovieCrew;
import br.com.netflics.model.Company;
import br.com.netflics.model.Person;
import br.com.netflics.model.User;
import br.com.netflics.model.Role;
import br.com.netflics.model.Permission;
import br.com.netflics.model.Group;
import br.com.netflics.model.Item;
public class FixtureUtils {

	public static void init() {
		Fixture.of(Department.class).addTemplate("novo", new Rule() {
			{
				add("departmentName", regex("[a-z ]{5,15}"));
			}
		});
		Fixture.of(Movie.class).addTemplate("novo", new Rule() {
			{
				add("title", regex("[a-z ]{5,15}"));
				add("homepage", regex("[a-z ]{5,15}"));
				add("overview", regex("[a-z ]{5,15}"));
				add("popularity", regex("[a-z ]{5,15}"));
				add("revenue", regex("[a-z ]{5,15}"));
				add("status", regex("[a-z ]{5,15}"));
				add("tagline", regex("[a-z ]{5,15}"));
				add("voteAverage", regex("[a-z ]{5,15}"));
			}
		});
		Fixture.of(Genre.class).addTemplate("novo", new Rule() {
			{
				add("genreName", regex("[a-z ]{5,15}"));
			}
		});
		Fixture.of(MovieCast.class).addTemplate("novo", new Rule() {
			{
				add("characterName", regex("[a-z ]{5,15}"));
			}
		});
		Fixture.of(Language.class).addTemplate("novo", new Rule() {
			{
				add("code", regex("[a-z ]{5,15}"));
				add("name", regex("[a-z ]{5,15}"));
			}
		});
		Fixture.of(Country.class).addTemplate("novo", new Rule() {
			{
				add("name", regex("[a-z ]{5,15}"));
				add("isoCode", regex("[a-z ]{5,15}"));
			}
		});
		Fixture.of(Keyword.class).addTemplate("novo", new Rule() {
			{
				add("name", regex("[a-z ]{5,15}"));
			}
		});
		Fixture.of(Gender.class).addTemplate("novo", new Rule() {
			{
				add("gender", regex("[a-z ]{5,15}"));
			}
		});
		Fixture.of(MovieCrew.class).addTemplate("novo", new Rule() {
			{
				add("job", regex("[a-z ]{5,15}"));
			}
		});
		Fixture.of(Company.class).addTemplate("novo", new Rule() {
			{
				add("name", regex("[a-z ]{5,15}"));
			}
		});
		Fixture.of(Person.class).addTemplate("novo", new Rule() {
			{
				add("name", regex("[a-z ]{5,15}"));
			}
		});
		Fixture.of(User.class).addTemplate("novo", new Rule() {
			{
				add("name", regex("[a-z ]{5,15}"));
				add("username", regex("[a-z ]{5,15}"));
				add("email", regex("[a-z ]{5,15}"));
				add("password", regex("[a-z ]{5,15}"));
				add("image", regex("[a-z ]{5,15}"));
			}
		});
		Fixture.of(Role.class).addTemplate("novo", new Rule() {
			{
				add("authority", regex("[a-z ]{5,15}"));
				add("description", regex("[a-z ]{5,15}"));
			}
		});
		Fixture.of(Permission.class).addTemplate("novo", new Rule() {
			{
				add("name", regex("[a-z ]{5,15}"));
				add("description", regex("[a-z ]{5,15}"));
				add("operation", regex("[a-z ]{5,15}"));
				add("tagReminder", regex("[a-z ]{5,15}"));
			}
		});
		Fixture.of(Group.class).addTemplate("novo", new Rule() {
			{
				add("name", regex("[a-z ]{5,15}"));
				add("description", regex("[a-z ]{5,15}"));
			}
		});
		Fixture.of(Item.class).addTemplate("novo", new Rule() {
			{
				add("name", regex("[a-z ]{5,15}"));
				add("itemType", regex("[a-z ]{5,15}"));
				add("identifier", regex("[a-z ]{5,15}"));
				add("description", regex("[a-z ]{5,15}"));
			}
		});

	}
}