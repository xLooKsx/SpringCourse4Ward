package br.com.fiveward.xlooksx.enums;
import java.util.stream.Stream;

public enum DocumentType {

    PERSONAL("PERSONAL"),
    BUSINESS("BUSINESS");

    private final String value;

    private DocumentType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static DocumentType fromString(final String value) {
        return Stream.of(DocumentType.values()) //
                .filter(e -> e.value.equalsIgnoreCase(value)) //
                .findFirst() //
                .orElseThrow(() -> new EnumConstantNotPresentException(DocumentType.class, value));
    }
}