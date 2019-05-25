
package br.com.fiveward.dogg.dto.builder;

import br.com.fiveward.xlooksx.dto.DocumentDto;

public class DocumentDtoBuilder {

	private Long id;
	private String value;
	private String type;

	public static DocumentDtoBuilder create() {
		return new DocumentDtoBuilder();
	}

	private DocumentDtoBuilder() {}

	public DocumentDtoBuilder setId(final Long id) {
		this.id = id;
		return this;
	}

	public DocumentDtoBuilder setValue(final String value) {
		this.value = value;
		return this;
	}

	public DocumentDtoBuilder setType(final String type) {
		this.type = type;
		return this;
	}

	public DocumentDto build() {
		return new DocumentDto(value, type);
	}
}
