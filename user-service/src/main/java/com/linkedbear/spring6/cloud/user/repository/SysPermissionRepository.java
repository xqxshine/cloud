package com.linkedbear.spring6.cloud.user.repository;

import com.linkedbear.spring6.cloud.user.entity.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysPermissionRepository extends JpaRepository<SysPermission, Long> {
}
