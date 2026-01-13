package com.linkedbear.spring6.cloud.user.repository;

import com.linkedbear.spring6.cloud.user.entity.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysMenuRepository extends JpaRepository<SysMenu, Long> {
}
