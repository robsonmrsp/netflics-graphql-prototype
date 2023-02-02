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

import br.com.netflics.model.Language;
import br.com.netflics.persistence.LanguageRepository;
import br.com.netflics.persistence.LanguageSpecificationHelper;
import br.com.netflics.model.filter.FilterLanguage;

import br.com.netflics.core.persistence.pagination.Pager;
import br.com.netflics.core.rs.exception.ValidationException;
import br.com.netflics.core.persistence.pagination.SearchParameters;
import br.com.netflics.core.utils.DateUtil;
import br.com.netflics.core.utils.Util;

@Service
@Transactional
public class LanguageServiceImp implements LanguageService {

	public static final Logger LOGGER = LoggerFactory.getLogger(LanguageServiceImp.class);
	
	@Autowired
	LanguageRepository languageRepository;
	
	public Optional<Language> get(Integer id, Tenant tenant) {
		return languageRepository.findOne(LanguageSpecificationHelper.fromId(id, tenant));
	}

	public Pager<Language> get(SearchParameters<FilterLanguage> searchParams, Tenant tenant) {
		Pageable pageRequest = searchParams.getPageRequest();

		Page<Language> page = languageRepository.findAll(LanguageSpecificationHelper.filter(searchParams, tenant), pageRequest);

		return new Pager<Language>(page.getContent(), searchParams.getPage(), searchParams.getPageSize(),
		        searchParams.getOrder(), searchParams.getOrderBy(), page.getTotalElements());
	}

	public Boolean delete(Integer id, Tenant tenant) {
		Optional<Language> optional = this.get(id, tenant);
		if (optional.isPresent()) {
			languageRepository.delete(optional.get());
		}
		return true;
	}

	public Language save(Language entity) {
		return languageRepository.save(entity);
	}

	public Language update(Language entity) {
		return languageRepository.save(entity);
	}
}

//generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21