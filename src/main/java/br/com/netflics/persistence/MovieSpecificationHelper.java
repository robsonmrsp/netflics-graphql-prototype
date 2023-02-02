package br.com.netflics.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import br.com.netflics.model.Movie;
import br.com.netflics.model.filter.FilterMovie;

import br.com.netflics.core.persistence.pagination.SearchParameters;
import br.com.netflics.core.utils.Util;

import org.springframework.data.jpa.domain.Specification;

import br.com.netflics.core.model.Tenant;
@SuppressWarnings("serial")
public class MovieSpecificationHelper {

	public static Specification<Movie> fromId(Integer id, Tenant tenant) {
		return new Specification<Movie>() {
			@Override
			public Predicate toPredicate(Root<Movie> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				predicates.add(criteriaBuilder.equal(root.get("tenant"), tenant));
					predicates.add(criteriaBuilder.equal(root.get("id"), id));

				return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
			}
		};
	}
	public static Specification<Movie> filter(SearchParameters<FilterMovie> searchParam, Tenant tenant) {
		return new Specification<Movie>() {

			@Override
			public Predicate toPredicate(Root<Movie> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				FilterMovie filterMovie = searchParam.getFilter();
				predicates.add(criteriaBuilder.equal(root.get("tenant"), tenant));
				if (filterMovie.getTitle() != null) {
					predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.<String>get("title")), Util.wrapSufix(filterMovie.getTitle().toUpperCase(), searchParam.isExact())));
				}  
				if (filterMovie.getBudget() != null) {
					predicates.add(criteriaBuilder.equal(root.get("budget"), filterMovie.getBudget()));
				}				
				if (filterMovie.getHomepage() != null) {
					predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.<String>get("homepage")), Util.wrapSufix(filterMovie.getHomepage().toUpperCase(), searchParam.isExact())));
				}  
				if (filterMovie.getOverview() != null) {
					predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.<String>get("overview")), Util.wrapSufix(filterMovie.getOverview().toUpperCase(), searchParam.isExact())));
				}  
				if (filterMovie.getPopularity() != null) {
					predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.<String>get("popularity")), Util.wrapSufix(filterMovie.getPopularity().toUpperCase(), searchParam.isExact())));
				}  
				if (filterMovie.getReleaseDate() != null) {
					predicates.add(criteriaBuilder.equal(root.get("releaseDate"), filterMovie.getReleaseDate()));
				}				
				if (filterMovie.getRevenue() != null) {
					predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.<String>get("revenue")), Util.wrapSufix(filterMovie.getRevenue().toUpperCase(), searchParam.isExact())));
				}  
				if (filterMovie.getRuntime() != null) {
					predicates.add(criteriaBuilder.equal(root.get("runtime"), filterMovie.getRuntime()));
				}				
				if (filterMovie.getStatus() != null) {
					predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.<String>get("status")), Util.wrapSufix(filterMovie.getStatus().toUpperCase(), searchParam.isExact())));
				}  
				if (filterMovie.getTagline() != null) {
					predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.<String>get("tagline")), Util.wrapSufix(filterMovie.getTagline().toUpperCase(), searchParam.isExact())));
				}  
				if (filterMovie.getVoteAverage() != null) {
					predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.<String>get("voteAverage")), Util.wrapSufix(filterMovie.getVoteAverage().toUpperCase(), searchParam.isExact())));
				}  
				if (filterMovie.getVoteCount() != null) {
					predicates.add(criteriaBuilder.equal(root.get("voteCount"), filterMovie.getVoteCount()));
				}				
				return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
			}
		};
	}
}
