package br.com.fiveward.xlooksx.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fiveward.xlooksx.MerchantCanonical;
import br.com.fiveward.xlooksx.converter.tocanonical.ToMerchantCanonicalConverter;
import br.com.fiveward.xlooksx.converter.todto.ToMerchantDtoConverter;
import br.com.fiveward.xlooksx.dto.MerchantDto;
import br.com.fourward.xlooksx.business.MerchantBusiness;
import br.com.fourward.xlooksx.util.Pagination;

/**
 * @author xLooKsx
 *
 */
@RestController
@RequestMapping("/profiles")
public class MerchantController {

	@Autowired
	private MerchantBusiness merchantBusiness;

	public MerchantController() {}

	@PostMapping
	public ResponseEntity<MerchantDto> create(@RequestBody final MerchantDto MerchantDto) {
		final MerchantCanonical requestCanonical = convertToCanonical(MerchantDto);
		final MerchantCanonical savedCanonical = merchantBusiness.save(requestCanonical);

		final MerchantDto merchantResponseDto = convertToDto(requestCanonical);
		final URI location = getUri(savedCanonical);

		return ResponseEntity.created(location).body(merchantResponseDto);
	}

	@PutMapping
	public ResponseEntity<MerchantDto> update(@RequestBody final MerchantDto MerchantDto) {
		final MerchantCanonical requestCanonical = convertToCanonical(MerchantDto);
		final MerchantCanonical savedCanonical = merchantBusiness.save(requestCanonical);

		return ResponseEntity.ok(convertToDto(savedCanonical));
	}

	@GetMapping("/{id}")
	public ResponseEntity<MerchantDto> getById(@PathVariable("id") final Long id) {
		final MerchantCanonical foundCanonical = merchantBusiness.getById(id);

		return ResponseEntity.ok(convertToDto(foundCanonical));
	}

	@GetMapping()
	ResponseEntity<Pagination<MerchantDto>> getAllPaginated(@RequestParam(required = false, defaultValue = "") final String name,
	        @RequestParam(required = false, defaultValue = "0") final Integer page,
	        @RequestParam(required = false, defaultValue = "10") final Integer size) {
		final Pagination<MerchantCanonical> pagination = merchantBusiness.getAllPaginated(name, page, size);

		return ResponseEntity.ok(pagination.map(this::convertToDto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable final Long id) {
		// FIXME ao invés de deletar, vamos apenas desativar.
		merchantBusiness.deleteById(id);
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("Request ainda em implementação");
	}
	
	private URI getUri(final MerchantCanonical savedCanonical) {
		return ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedCanonical.getId())
				.toUri();
	}

	private MerchantCanonical convertToCanonical(final MerchantDto MerchantDto) {
		return ToMerchantCanonicalConverter.convert(MerchantDto);
	}

	private MerchantDto convertToDto(final MerchantCanonical MerchantCanonical) {
		return ToMerchantDtoConverter.convert(MerchantCanonical);
	}
}
