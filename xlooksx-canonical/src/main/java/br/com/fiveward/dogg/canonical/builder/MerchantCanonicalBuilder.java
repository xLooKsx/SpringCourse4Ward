
package br.com.fiveward.dogg.canonical.builder;

import java.time.LocalDate;

import br.com.fiveward.xlooksx.DocumentCanonical;
import br.com.fiveward.xlooksx.MerchantCanonical;

public class MerchantCanonicalBuilder {

	private Long id;
	private String legalName;
	private String socialName;
	private Boolean allowedToTransact;
	private LocalDate foundation;
	private DocumentCanonical document;
	private Boolean isActive;

	public static MerchantCanonicalBuilder create() {
		return new MerchantCanonicalBuilder();
	}

	private MerchantCanonicalBuilder() {}

	public MerchantCanonicalBuilder setId(final Long id) {
		this.id = id;
		return this;
	}

	public MerchantCanonicalBuilder setLegalName(final String legalName) {
		this.legalName = legalName;
		return this;
	}

	public MerchantCanonicalBuilder setSocialName(final String socialName) {
		this.socialName = socialName;
		return this;
	}

	public MerchantCanonicalBuilder setAllowedToTransact(final Boolean allowedToTransact) {
		this.allowedToTransact = allowedToTransact;
		return this;
	}

	public MerchantCanonicalBuilder setFoundation(final LocalDate foundation) {
		this.foundation = foundation;
		return this;
	}

	public MerchantCanonicalBuilder setDocument(final DocumentCanonical document) {
		this.document = document;
		return this;
	}

	public MerchantCanonicalBuilder setIsActive(final Boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public MerchantCanonical build() {
		return new MerchantCanonical(id, legalName, socialName, allowedToTransact, foundation, document, isActive);
	}
}
