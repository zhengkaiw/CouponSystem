package com.passbook.merchants.dao;

import com.passbook.merchants.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Merchants Dao 接口
 */
public interface MerchantsDao extends JpaRepository<Merchants, Integer> {

    Optional<Merchants> findById(Integer id);

    Merchants findByName(String name);
}
