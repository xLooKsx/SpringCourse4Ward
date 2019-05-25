package br.com.fiveward.xlooksx.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.fiveward.xlooksx.entity.MerchantEntity;

@Repository
public interface MerchantRepository extends JpaRepository<MerchantEntity, Long>, JpaSpecificationExecutor<MerchantEntity>{

}
