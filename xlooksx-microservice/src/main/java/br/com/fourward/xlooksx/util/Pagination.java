package br.com.fourward.xlooksx.util;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Classe de pagina��o para encapsular dtos/can�nicos em p�ginas para processamento ou convers�o para outros tipos de
 * repesenta��o de dados. Foi implementado utilizando alguns conceitos do spring-data de pagina��o.
 * 
 * @author vinicius.carvalho
 * @param <T> tipo de elemento que comp�e o conte�do desta p�gina.
 * @see https://github.com/spring-projects/spring-data-commons/blob/master/src/main/java/org/springframework/data/domain/PageImpl.java
 */
public class Pagination<T> implements Serializable {

	private static final long serialVersionUID = 7411463674738214318L;

	private final long pageNumber;

	private final long pageSize;

	private final long totalElements;

	private final long totalPages;

	private final List<T> content;

	/**
	 * Cria uma pagina��o vazia.
	 */
	public Pagination() {
		this(Collections.emptyList());
	}

	/**
	 * Cria uma pagina��o a partir de uma lista de elementos. Esta pagina��o assume que existe apenas uma �nica p�gina a
	 * ser paginada, cuja quantidade de elementos � igual ao tamanho da lista.
	 * 
	 * @param list {@link List} lista para cria��o da p�gina.
	 */
	public Pagination(List<T> list) {
		this(list, 0, list == null ? 0 : list.size(), list == null ? 0 : list.size());
	}

	/**
	 * Cria uma pagina��o a partir de uma lista e de informa��es de pagina��o, como n�mero da p�gina atual, tamanho da
	 * p�gina atual e quantidade total de elementos.
	 * 
	 * @param list {@link List} lista para cria��o da p�gina.
	 * @param page N�mero da p�gina atual.
	 * @param size Tamanho da p�gina atual.
	 * @param total Quantidade total de elementos.
	 */
	public Pagination(List<T> list, long page, long size, long total) {
		this.pageNumber = page;
		this.pageSize = size;
		this.content = list == null ? Collections.emptyList() : list;

		this.totalElements = calculateTotalElements(total);
		this.totalPages = calculateTotalPages();
	}

	public long getPageNumber() {
		return pageNumber;
	}

	public long getPageSize() {
		return pageSize;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public long getTotalPages() {
		return totalPages;
	}

	public List<T> getContent() {
		return Collections.unmodifiableList(content);
	}

	/**
	 * Mapeia o conte�do dentro dessa pagina��o para um novo tipo de objeto, definido pelo objeto conversor.
	 * 
	 * @param converter {@link Function} conversor para os tipos de dados
	 * @return Uma pagina��o nova, com os mesmos par�metros da pagina��o atual por�m com o seu conte�do interno
	 *         convertido.
	 */
	public <E> Pagination<E> map(final Function<? super T, ? extends E> converter) {
		return new Pagination<E>(getConvertedContent(converter), pageNumber, pageSize, totalElements);
	}

	private long calculateTotalElements(final long total) {
		final long offset = pageNumber * pageSize;
		return (offset + pageSize) > total ? offset + content.size() : total;
	}

	private long calculateTotalPages() {
		return pageSize == 0 ? 1 : (int) Math.ceil((double) totalElements / (double) pageSize);
	}

	private <E> List<E> getConvertedContent(Function<? super T, ? extends E> converter) {
		return content.stream().map(converter::apply).collect(Collectors.toList());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + (int) (pageNumber ^ (pageNumber >>> 32));
		result = prime * result + (int) (pageSize ^ (pageSize >>> 32));
		result = prime * result + (int) (totalElements ^ (totalElements >>> 32));
		result = prime * result + (int) (totalPages ^ (totalPages >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagination<?> other = (Pagination<?>) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (pageNumber != other.pageNumber)
			return false;
		if (pageSize != other.pageSize)
			return false;
		if (totalElements != other.totalElements)
			return false;
		if (totalPages != other.totalPages)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pagination [pageNumber="
		        + pageNumber
		        + ", pageSize="
		        + pageSize
		        + ", totalElements="
		        + totalElements
		        + ", totalPages="
		        + totalPages
		        + ", content="
		        + content
		        + "]";
	}
}