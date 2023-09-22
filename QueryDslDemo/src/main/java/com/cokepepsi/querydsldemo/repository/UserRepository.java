package com.cokepepsi.querydsldemo.repository;

import com.cokepepsi.querydsldemo.model.po.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author CokePepsi
 * @date 2023/9/22 16:34
 */

@Repository
public interface UserRepository extends JpaRepository<UserPO, Long> {

}
