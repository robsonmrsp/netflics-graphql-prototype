package br.com.netflics.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import br.com.netflics.model.MovieCast;
import br.com.netflics.model.filter.FilterMovieCast;

import br.com.netflics.core.persistence.pagination.SearchParameters;
import br.com.netflics.core.utils.Util;

import org.springframework.data.jpa.domain.Specification;

import br.com.netflics.core.model.Tenant;
@SuppressWarnings("serial")
public class MovieCastSpecificationHelper {

	public static Specification<MovieCast> fromId(Integer id, Tenant tenant) {
		return new Specification<MovieCast>() {
			@Override
			public Predicate toPredicate(Root<MovieCast> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				predicates.add(criteriaBuilder.equal(root.get("tenant"), tenant));
					predicates.add(criteriaBuilder.equal(root.get("id"), id));

				return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
			}
		};
	}
	public static Specification<MovieCast> filter(SearchParameters<FilterMovieCast> searchParam, Tenant tenant) {
		return new Specification<MovieCast>() {

			@Override
			public Predicate toPredicate(Root<MovieCast> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				FilterMovieCast filterMovieCast = searchParam.getFilter();
				predicates.add(criteriaBuilder.equal(root.get("tenant"), tenant));
				if (filterMovieCast.getOrder() != null) {
					predicates.add(criteriaBuilder.equal(root.get("order"), filterMovieCast.getOrder()));
				}				
				if (filterMovieCast.getCharacterName() != null) {
					predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.<String>get("characterName")), Util.wrapSufix(filterMovieCast.getCharacterName().toUpperCase(), searchParam.isExact())));
				}  
				if (filterMovieCast.getMovie() != null) {
					predicates.add(criteriaBuilder.equal(root.get("movie").get("id"), filterMovieCast.getMovie()));
				}
				if (filterMovieCast.getGender() != null) {
					predicates.add(criteriaBuilder.equal(root.get("gender").get("id"), filterMovieCast.getGender()));
				}
				if (filterMovieCast.getPerson() != null) {
					predicates.add(criteriaBuilder.equal(root.get("person").get("id"), filterMovieCast.getPerson()));
				}
				return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
			}
		};
	}
}
