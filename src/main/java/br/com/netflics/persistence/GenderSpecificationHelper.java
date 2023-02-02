package br.com.netflics.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import br.com.netflics.model.Gender;
import br.com.netflics.model.filter.FilterGender;

import br.com.netflics.core.persistence.pagination.SearchParameters;
import br.com.netflics.core.utils.Util;

import org.springframework.data.jpa.domain.Specification;

import br.com.netflics.core.model.Tenant;
@SuppressWarnings("serial")
public class GenderSpecificationHelper {

	public static Specification<Gender> fromId(Integer id, Tenant tenant) {
		return new Specification<Gender>() {
			@Override
			public Predicate toPredicate(Root<Gender> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				predicates.add(criteriaBuilder.equal(root.get("tenant"), tenant));
					predicates.add(criteriaBuilder.equal(root.get("id"), id));

				return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
			}
		};
	}
	public static Specification<Gender> filter(SearchParameters<FilterGender> searchParam, Tenant tenant) {
		return new Specification<Gender>() {

			@Override
			public Predicate toPredicate(Root<Gender> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				FilterGender filterGender = searchParam.getFilter();
				predicates.add(criteriaBuilder.equal(root.get("tenant"), tenant));
				if (filterGender.getGender() != null) {
					predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.<String>get("gender")), Util.wrapSufix(filterGender.getGender().toUpperCase(), searchParam.isExact())));
				}  
				return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
			}
		};
	}
}
