
package br.com.fiveward.dogg.dto.builder;

import java.time.LocalDate;

import br.com.fiveward.xlooksx.dto.DocumentDto;
import br.com.fiveward.xlooksx.dto.MerchantDto;

public class MerchantDtoBuilder {

	private Long id;
	private String legalName;
	private String socialName;
	private Boolean allowedToTransact;
	private LocalDate foundation;
	private DocumentDto document;
	private Boolean isActive;

	public static MerchantDtoBuilder create() {
		return new MerchantDtoBuilder();
	}

	private MerchantDtoBuilder() {}

	public MerchantDtoBuilder setId(final Long id) {
		this.id = id;
		return this;
	}

	public MerchantDtoBuilder setLegalName(final String legalName) {
		this.legalName = legalName;
		return this;
	}

	public MerchantDtoBuilder setSocialName(final String socialName) {
		this.socialName = socialName;
		return this;
	}

	public MerchantDtoBuilder setAllowedToTransact(final Boolean allowedToTransact) {
		this.allowedToTransact = allowedToTransact;
		return this;
	}

	public MerchantDtoBuilder setFoundation(final LocalDate foundation) {
		this.foundation = foundation;
		return this;
	}

	public MerchantDtoBuilder setDocument(final DocumentDto document) {
		this.document = document;
		return this;
	}

	public MerchantDtoBuilder setIsActive(final Boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public MerchantDto build() {
		return new MerchantDto(id, legalName, socialName, allowedToTransact, foundation, document, isActive);
	}
}
