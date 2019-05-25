
package br.com.fourward.xlooksx.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import br.com.fiveward.xlooksx.MerchantCanonical;
import br.com.fiveward.xlooksx.converter.tocanonical.ToMerchantCanonicalConverter;
import br.com.fiveward.xlooksx.converter.todto.ToMerchantDtoConverter;
import br.com.fiveward.xlooksx.converter.toentity.ToMerchantEntityConverter;
import br.com.fiveward.xlooksx.data.repository.MerchantRepository;
import br.com.fiveward.xlooksx.data.specification.MerchantSpecification;
import br.com.fiveward.xlooksx.entity.MerchantEntity;
import br.com.fourward.xlooksx.util.Pagination;

@Service
public class MerchantBusiness {

	@Autowired
	private MerchantRepository MerchantRepository;

	public MerchantBusiness() {}

	public MerchantCanonical save(final MerchantCanonical MerchantCanonical) {
		final MerchantEntity entity = convertCanonicalToEntity(MerchantCanonical);
		final MerchantEntity savedEntity = MerchantRepository.save(entity);

		return convertEntityToCanonical(savedEntity);
	}

	public MerchantCanonical getById(final Long id) {
		final MerchantEntity foundEntity = MerchantRepository.getOne(id);

		return convertEntityToCanonical(foundEntity);
	}

	public Pagination<MerchantCanonical> getAllPaginated(final String name, final int page, final int size) {

		final Pageable pageable = new PageRequest(page, size);

		final Page<MerchantEntity> foundPage = MerchantRepository.findAll(Specifications//
		        .where(MerchantSpecification.specByLegalName(name)), pageable);

		final Pagination<MerchantEntity> pagination =
		        new Pagination<>(foundPage.getContent(), page, size, foundPage.getTotalElements());

		return pagination.map(this::convertEntityToCanonical);
	}

	public void deleteById(final Long id) {
		// FIXME ao invés de deletar, vamos apenas desativar.
	}

	private MerchantEntity convertCanonicalToEntity(final MerchantCanonical MerchantCanonical) {
		return ToMerchantEntityConverter.convert(MerchantCanonical);
	}

	private MerchantCanonical convertEntityToCanonical(final MerchantEntity MerchantEntity) {
		return ToMerchantCanonicalConverter.convert(MerchantEntity);
	}
}
