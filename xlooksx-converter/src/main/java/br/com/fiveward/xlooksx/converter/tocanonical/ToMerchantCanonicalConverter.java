
package br.com.fiveward.xlooksx.converter.tocanonical;

import java.time.LocalDate;

import br.com.fiveward.dogg.canonical.builder.DocumentCanonicalBuilder;
import br.com.fiveward.dogg.canonical.builder.MerchantCanonicalBuilder;
import br.com.fiveward.xlooksx.DocumentCanonical;
import br.com.fiveward.xlooksx.MerchantCanonical;
import br.com.fiveward.xlooksx.dto.MerchantDto;
import br.com.fiveward.xlooksx.entity.MerchantEntity;
import br.com.fiveward.xlooksx.enums.DocumentType;


public class ToMerchantCanonicalConverter {

	private static final int PERSONAL_DOCUMENT_SIZE = 11;

	public static MerchantCanonical convert(final MerchantDto target) {
		final boolean targetIsNull = target == null;

		final Long id = targetIsNull ? null : target.getId();
		final String legalName = targetIsNull ? null : target.getLegalName();
		final String socialName = targetIsNull ? null : target.getSocialName();
		final Boolean allowedToTransact = targetIsNull ? null : target.getAllowedToTransact();
		final LocalDate foundation = targetIsNull ? null : target.getFoundation();
		final Boolean isActive = targetIsNull ? null : target.getIsActive();

		final boolean isDocumentNull = targetIsNull || target.getDocument() == null;
		final DocumentCanonical document =
		        isDocumentNull ? null : ToDocumentCanonicalConverter.convert(target.getDocument());

		return MerchantCanonicalBuilder //
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

	public static MerchantCanonical convert(final MerchantEntity target) {
		final boolean targetIsNull = target == null;

		final Long id = targetIsNull ? null : target.getId();
		final String legalName = targetIsNull ? null : target.getLegalName();
		final String socialName = targetIsNull ? null : target.getSocialName();
		final Boolean allowedToTransact = targetIsNull ? null : target.getAllowedToTransact();
		final LocalDate foundation = targetIsNull ? null : target.getFoundation();
		final Boolean isActive = targetIsNull ? null : target.getIsActive();

		final boolean isDocumentNull = targetIsNull || target.getDocument() == null;
		final DocumentCanonical document = isDocumentNull ? null
		        : buildDocumentCanonical(target.getDocument(),
		                target.getDocument().length() > PERSONAL_DOCUMENT_SIZE ? DocumentType.BUSINESS : DocumentType.PERSONAL);

		return MerchantCanonicalBuilder //
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

	private static DocumentCanonical buildDocumentCanonical(final String value, final DocumentType type) {
		return DocumentCanonicalBuilder.create().setValue(value).setType(type).build();
	}
}
