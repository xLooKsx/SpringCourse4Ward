
package br.com.fiveward.xlooksx.converter.todto;

import br.com.fiveward.dogg.dto.builder.DocumentDtoBuilder;
import br.com.fiveward.xlooksx.DocumentCanonical;
import br.com.fiveward.xlooksx.dto.DocumentDto;

public class ToDocumentDtoConverter {

	public static DocumentDto convert(final DocumentCanonical target) {
		final boolean targetIsNull = target == null;
		
		final String value = targetIsNull ? null : target.getValue();

		final boolean isTypeNull = targetIsNull || target.getType() == null;
		final String type = isTypeNull ? null : target.getType().getValue();

		return DocumentDtoBuilder //
		        .create() //
		        .setValue(value) //
		        .setType(type) //
		        .build();
	}
}
