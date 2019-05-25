
package br.com.fiveward.dogg.converter.toentity;

import java.time.LocalDate;

import br.com.fiveward.dogg.data.builder.MerchantEntityBuilder;
import br.com.fiveward.xlooksx.MerchantCanonical;
import br.com.fiveward.xlooksx.entity.MerchantEntity;


public class ToMerchantEntityConverter {

	public static MerchantEntity convert(final MerchantCanonical target) {
		final boolean targetIsNull = target == null;

		final Long id = targetIsNull ? null : target.getId();
		final String legalName = targetIsNull ? null : target.getLegalName();
		final String socialName = targetIsNull ? null : target.getSocialName();
		final Boolean allowedToTransact = targetIsNull ? null : target.getAllowedToTransact();
		final LocalDate foundation = targetIsNull ? null : target.getFoundation();
		final Boolean isActive = targetIsNull ? null : target.getIsActive();

		final boolean isDocumentNull = targetIsNull || target.getDocument() == null;
		final String document = isDocumentNull ? null : target.getDocument().getValue();

		return MerchantEntityBuilder //
		        .create() //
		        .setId(id) //
		        .setLegalName(legalName) //
		        .setSocialName(socialName) //
		        .setAllowedToTransact(allowedToTransact) //
		        .setFoundation(foundation) //
		        .setDocument(document) //
		        .setIsActive(isActive) //
		        .build();
	}
}
