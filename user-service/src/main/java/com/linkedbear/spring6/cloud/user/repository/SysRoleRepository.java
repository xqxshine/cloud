package com.linkedbear.spring6.cloud.user.repository;

import com.linkedbear.spring6.cloud.user.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysRoleRepository extends JpaRepository<SysRole, Long> {
}
