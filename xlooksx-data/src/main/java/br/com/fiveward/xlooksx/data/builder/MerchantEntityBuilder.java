
package br.com.fiveward.xlooksx.data.builder;

import java.time.LocalDate;

import br.com.fiveward.xlooksx.entity.MerchantEntity;

public class MerchantEntityBuilder {

	private Long id;
	private String legalName;
	private String socialName;
	private Boolean allowedToTransact;
	private LocalDate foundation;
	private String document;
	private Boolean isActive;

	public static MerchantEntityBuilder create() {
		return new MerchantEntityBuilder();
	}

	private MerchantEntityBuilder() {}

	public MerchantEntityBuilder setId(final Long id) {
		this.id = id;
		return this;
	}

	public MerchantEntityBuilder setLegalName(final String legalName) {
		this.legalName = legalName;
		return this;
	}

	public MerchantEntityBuilder setSocialName(final String socialName) {
		this.socialName = socialName;
		return this;
	}

	public MerchantEntityBuilder setAllowedToTransact(final Boolean allowedToTransact) {
		this.allowedToTransact = allowedToTransact;
		return this;
	}

	public MerchantEntityBuilder setFoundation(final LocalDate foundation) {
		this.foundation = foundation;
		return this;
	}

	public MerchantEntityBuilder setDocument(final String document) {
		this.document = document;
		return this;
	}

	public MerchantEntityBuilder setIsActive(final Boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public MerchantEntity build() {
		return new MerchantEntity(id, legalName, socialName, allowedToTransact, foundation, document, isActive);
	}
}
