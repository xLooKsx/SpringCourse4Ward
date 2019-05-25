
package br.com.fiveward.xlooksx.converter.todto;

import java.time.LocalDate;

import br.com.fiveward.dogg.dto.builder.MerchantDtoBuilder;
import br.com.fiveward.xlooksx.MerchantCanonical;
import br.com.fiveward.xlooksx.dto.DocumentDto;
import br.com.fiveward.xlooksx.dto.MerchantDto;

public class ToMerchantDtoConverter {

	public static MerchantDto convert(final MerchantCanonical target) {
		final boolean targetIsNull = target == null;

		final Long id = targetIsNull ? null : target.getId();
		final String legalName = targetIsNull ? null : target.getLegalName();
		final String socialName = targetIsNull ? null : target.getSocialName();
		final Boolean allowedToTransact = targetIsNull ? null : target.getAllowedToTransact();
		final LocalDate foundation = targetIsNull ? null : target.getFoundation();
		final Boolean isActive = targetIsNull ? null : target.getIsActive();

		final boolean isDocumentNull = targetIsNull || target.getDocument() == null;
		final DocumentDto document = isDocumentNull ? null : ToDocumentDtoConverter.convert(target.getDocument());

		return MerchantDtoBuilder //
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
