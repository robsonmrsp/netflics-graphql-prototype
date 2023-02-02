/* generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21 */
package br.com.netflics.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;

import java.time.LocalDate;
import java.time.LocalDateTime;
	
import java.util.ArrayList;
import java.util.List;

import br.com.netflics.core.model.AbstractMultitenantEntity;

@Entity
@Table(name = "MOVIE")
public class Movie extends AbstractMultitenantEntity{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer id;
	
	@Column(name = "TITLE" )
	private String title;		
	
	@Column(name = "BUDGET")
	private Integer budget;  	
			
	@Column(name = "HOMEPAGE" )
	private String homepage;		
	
	@Column(name = "OVERVIEW" )
	private String overview;		
	
	@Column(name = "POPULARITY" )
	private String popularity;		
	
	@Column(name = "RELEASE_DATE")
	private LocalDate releaseDate;  
				
	@Column(name = "REVENUE" )
	private String revenue;		
	
	@Column(name = "RUNTIME")
	private Integer runtime;  	
			
	@Column(name = "MOVIE_STATUS" )
	private String status;		
	
	@Column(name = "TAGLINE" )
	private String tagline;		
	
	@Column(name = "VOTE_AVERAGE" )
	private String voteAverage;		
	
	@Column(name = "VOTE_COUNT")
	private Integer voteCount;  	
			
    @ManyToMany
    @JoinTable(name="MOVIE_LANGUAGE", joinColumns = @JoinColumn(name = "ID_MOVIE", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_LANGUAGE", referencedColumnName = "ID") )
    private List<Language> languages;
    
    @ManyToMany
    @JoinTable(name="MOVIE_COUNTRY", joinColumns = @JoinColumn(name = "ID_MOVIE", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_COUNTRY", referencedColumnName = "ID") )
    private List<Country> countries;
    
    @ManyToMany
    @JoinTable(name="MOVIE_KEYWORD", joinColumns = @JoinColumn(name = "ID_MOVIE", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_KEYWORD", referencedColumnName = "ID") )
    private List<Keyword> keywords;

	@OneToMany(mappedBy = "movie")
	private List<MovieCrew> crew;

	@OneToMany(mappedBy = "movie")
	private List<MovieCast> cast;	
		
    @ManyToMany
    @JoinTable(name="MOVIE_GENRE", joinColumns = @JoinColumn(name = "ID_MOVIE", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_GENRE", referencedColumnName = "ID") )
    private List<Genre> genres;
    
    @ManyToMany
    @JoinTable(name="MOVIE_COMPANY", joinColumns = @JoinColumn(name = "ID_MOVIE", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_COMPANY", referencedColumnName = "ID") )
    private List<Company> company;
    
		
	public  Movie() {
		
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getBudget() {
		return budget;
	}

	public void setBudget(Integer budget) {
		this.budget = budget;
	}
	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getPopularity() {
		return popularity;
	}

	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getRevenue() {
		return revenue;
	}

	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}
	public Integer getRuntime() {
		return runtime;
	}

	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}
	public String getVoteAverage() {
		return voteAverage;
	}

	public void setVoteAverage(String voteAverage) {
		this.voteAverage = voteAverage;
	}
	public Integer getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}
	public void setLanguages(List<Language> languages){
		this.languages = languages;
	}
	
	public List<Language>  getLanguages() {
		if(this.languages == null){
			setLanguages(new ArrayList<Language>());
		}
		return this.languages; 
	}
		
	public boolean addLanguages(Language language){	
		return getLanguages().add(language);
	}
	
	public boolean removeLanguages(Language language){	
		return getLanguages().remove(language);
	}
	public void setCountries(List<Country> countries){
		this.countries = countries;
	}
	
	public List<Country>  getCountries() {
		if(this.countries == null){
			setCountries(new ArrayList<Country>());
		}
		return this.countries; 
	}
		
	public boolean addCountries(Country country){	
		return getCountries().add(country);
	}
	
	public boolean removeCountries(Country country){	
		return getCountries().remove(country);
	}
	public void setKeywords(List<Keyword> keywords){
		this.keywords = keywords;
	}
	
	public List<Keyword>  getKeywords() {
		if(this.keywords == null){
			setKeywords(new ArrayList<Keyword>());
		}
		return this.keywords; 
	}
		
	public boolean addKeywords(Keyword keyword){	
		return getKeywords().add(keyword);
	}
	
	public boolean removeKeywords(Keyword keyword){	
		return getKeywords().remove(keyword);
	}
	public void setCrew(List<MovieCrew> crew){
		this.crew = crew;
	}
	
	public List<MovieCrew>  getCrew() {
		if(this.crew == null){
			setCrew(new ArrayList<MovieCrew>());
		}
		return this.crew;
	}
		
	public boolean addCrew(MovieCrew movieCrew){
		return getCrew().add(movieCrew);
	}
	
	public boolean removeCrew(MovieCrew movieCrew){
		return getCrew().remove(movieCrew);
	}
	
	public void setCast(List<MovieCast> cast){
		this.cast = cast;
	}
	
	public List<MovieCast>  getCast() {
		if(this.cast == null){
			setCast(new ArrayList<MovieCast>());
		}
		return this.cast;
	}
		
	public boolean addCast(MovieCast movieCast){
		return getCast().add(movieCast);
	}
	
	public boolean removeCast(MovieCast movieCast){
		return getCast().remove(movieCast);
	}
	
	public void setGenres(List<Genre> genres){
		this.genres = genres;
	}
	
	public List<Genre>  getGenres() {
		if(this.genres == null){
			setGenres(new ArrayList<Genre>());
		}
		return this.genres; 
	}
		
	public boolean addGenres(Genre genre){	
		return getGenres().add(genre);
	}
	
	public boolean removeGenres(Genre genre){	
		return getGenres().remove(genre);
	}
	public void setCompany(List<Company> company){
		this.company = company;
	}
	
	public List<Company>  getCompany() {
		if(this.company == null){
			setCompany(new ArrayList<Company>());
		}
		return this.company; 
	}
		
	public boolean addCompany(Company company){	
		return getCompany().add(company);
	}
	
	public boolean removeCompany(Company company){	
		return getCompany().remove(company);
	}
	
}
//generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21