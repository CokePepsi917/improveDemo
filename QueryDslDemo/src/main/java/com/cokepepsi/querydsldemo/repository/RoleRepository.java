package com.cokepepsi.querydsldemo.repository;

import com.cokepepsi.querydsldemo.model.po.RolePO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author CokePepsi
 * @date 2023/9/22 16:36
 */
@Repository
public interface RoleRepository extends JpaRepository<RolePO, Long> {
}
