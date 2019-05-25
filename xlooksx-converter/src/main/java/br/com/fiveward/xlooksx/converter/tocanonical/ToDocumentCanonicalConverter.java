
package br.com.fiveward.xlooksx.converter.tocanonical;

import br.com.fiveward.dogg.canonical.builder.DocumentCanonicalBuilder;
import br.com.fiveward.xlooksx.DocumentCanonical;
import br.com.fiveward.xlooksx.dto.DocumentDto;
import br.com.fiveward.xlooksx.enums.DocumentType;

public class ToDocumentCanonicalConverter {

	public static DocumentCanonical convert(final DocumentDto target) {
		final boolean targetIsNull = target == null;
		
		final String value = targetIsNull ? null : target.getValue();

		final boolean isTypeNull = targetIsNull || target.getType() == null;
		final DocumentType type = isTypeNull ? null : DocumentType.fromString(target.getValue());

		return DocumentCanonicalBuilder //
		        .create() //		        
		        .setValue(value) //
		        .setType(type) //
		        .build();
	}
}
