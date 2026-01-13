package com.linkedbear.spring6.cloud.user.repository;

import com.linkedbear.spring6.cloud.user.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    Optional<SysUser> findByUsername(String username);
}
