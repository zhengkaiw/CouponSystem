package com.passbook.passbook.dao;

import com.passbook.passbook.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Merchants Dao 接口
 */
public interface MerchantsDao extends JpaRepository<Merchants, Integer> {

    Optional<Merchants> findById(Integer id);

    Merchants findByName(String name);

    List<Merchants> findByIdIn(List<Integer> ids);
}
