package br.com.fiveward.xlooksx.data.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.fiveward.xlooksx.entity.MerchantEntity;

public class MerchantSpecification {

    private static final String LEGAL_NAME = "legalName";

    public static Specification<MerchantEntity> specByLegalName(final String name) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            criteriaQuery.distinct(true);
            return criteriaBuilder.like(criteriaBuilder.lower(root.get(LEGAL_NAME)), name.toLowerCase() + "%");
        };
    }
}