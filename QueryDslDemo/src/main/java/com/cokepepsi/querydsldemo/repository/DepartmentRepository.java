package com.cokepepsi.querydsldemo.repository;

import com.cokepepsi.querydsldemo.model.po.DepartmentPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author CokePepsi
 * @date 2023/9/22 16:37
 */

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentPO, Long> {
}
