
package br.com.fiveward.dogg.canonical.builder;

import br.com.fiveward.xlooksx.DocumentCanonical;
import br.com.fiveward.xlooksx.enums.DocumentType;

public class DocumentCanonicalBuilder {

	private Long id;
	private String value;
	private DocumentType type;

	public static DocumentCanonicalBuilder create() {
		return new DocumentCanonicalBuilder();
	}

	private DocumentCanonicalBuilder() {}

	public DocumentCanonicalBuilder setId(final Long id) {
		this.id = id;
		return this;
	}

	public DocumentCanonicalBuilder setValue(final String value) {
		this.value = value;
		return this;
	}

	public DocumentCanonicalBuilder setType(final DocumentType type) {
		this.type = type;
		return this;
	}

	public DocumentCanonical build() {
		return new DocumentCanonical(id, value, type);
	}
}
