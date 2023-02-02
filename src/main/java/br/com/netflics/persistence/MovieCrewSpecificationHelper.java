package br.com.netflics.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import br.com.netflics.model.MovieCrew;
import br.com.netflics.model.filter.FilterMovieCrew;

import br.com.netflics.core.persistence.pagination.SearchParameters;
import br.com.netflics.core.utils.Util;

import org.springframework.data.jpa.domain.Specification;

import br.com.netflics.core.model.Tenant;
@SuppressWarnings("serial")
public class MovieCrewSpecificationHelper {

	public static Specification<MovieCrew> fromId(Integer id, Tenant tenant) {
		return new Specification<MovieCrew>() {
			@Override
			public Predicate toPredicate(Root<MovieCrew> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				predicates.add(criteriaBuilder.equal(root.get("tenant"), tenant));
					predicates.add(criteriaBuilder.equal(root.get("id"), id));

				return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
			}
		};
	}
	public static Specification<MovieCrew> filter(SearchParameters<FilterMovieCrew> searchParam, Tenant tenant) {
		return new Specification<MovieCrew>() {

			@Override
			public Predicate toPredicate(Root<MovieCrew> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				FilterMovieCrew filterMovieCrew = searchParam.getFilter();
				predicates.add(criteriaBuilder.equal(root.get("tenant"), tenant));
				if (filterMovieCrew.getJob() != null) {
					predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.<String>get("job")), Util.wrapSufix(filterMovieCrew.getJob().toUpperCase(), searchParam.isExact())));
				}  
				if (filterMovieCrew.getMovie() != null) {
					predicates.add(criteriaBuilder.equal(root.get("movie").get("id"), filterMovieCrew.getMovie()));
				}
				if (filterMovieCrew.getPerson() != null) {
					predicates.add(criteriaBuilder.equal(root.get("person").get("id"), filterMovieCrew.getPerson()));
				}
				if (filterMovieCrew.getDepartment() != null) {
					predicates.add(criteriaBuilder.equal(root.get("department").get("id"), filterMovieCrew.getDepartment()));
				}
				return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
			}
		};
	}
}
