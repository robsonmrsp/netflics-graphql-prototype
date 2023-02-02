/* generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21 */
package br.com.netflics.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.netflics.core.model.Tenant ;

import br.com.netflics.model.MovieCrew;
import br.com.netflics.persistence.MovieCrewRepository;
import br.com.netflics.persistence.MovieCrewSpecificationHelper;
import br.com.netflics.model.filter.FilterMovieCrew;

import br.com.netflics.core.persistence.pagination.Pager;
import br.com.netflics.core.rs.exception.ValidationException;
import br.com.netflics.core.persistence.pagination.SearchParameters;
import br.com.netflics.core.utils.DateUtil;
import br.com.netflics.core.utils.Util;

@Service
@Transactional
public class MovieCrewServiceImp implements MovieCrewService {

	public static final Logger LOGGER = LoggerFactory.getLogger(MovieCrewServiceImp.class);
	
	@Autowired
	MovieCrewRepository movieCrewRepository;
	
	public Optional<MovieCrew> get(Integer id, Tenant tenant) {
		return movieCrewRepository.findOne(MovieCrewSpecificationHelper.fromId(id, tenant));
	}

	public Pager<MovieCrew> get(SearchParameters<FilterMovieCrew> searchParams, Tenant tenant) {
		Pageable pageRequest = searchParams.getPageRequest();

		Page<MovieCrew> page = movieCrewRepository.findAll(MovieCrewSpecificationHelper.filter(searchParams, tenant), pageRequest);

		return new Pager<MovieCrew>(page.getContent(), searchParams.getPage(), searchParams.getPageSize(),
		        searchParams.getOrder(), searchParams.getOrderBy(), page.getTotalElements());
	}

	public Boolean delete(Integer id, Tenant tenant) {
		Optional<MovieCrew> optional = this.get(id, tenant);
		if (optional.isPresent()) {
			movieCrewRepository.delete(optional.get());
		}
		return true;
	}

	public MovieCrew save(MovieCrew entity) {
		return movieCrewRepository.save(entity);
	}

	public MovieCrew update(MovieCrew entity) {
		return movieCrewRepository.save(entity);
	}
}

//generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21