package com.linkedbear.spring6.cloud.user.service;

import com.linkedbear.spring6.cloud.user.entity.SysUser;
import com.linkedbear.spring6.cloud.user.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<SysUser> getAllUsers() {
        return sysUserRepository.findAll();
    }

    public Optional<SysUser> getUserById(Long id) {
        return sysUserRepository.findById(id);
    }

    public SysUser createUser(SysUser user) {
        // 加密密码
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return sysUserRepository.save(user);
    }

    public SysUser updateUser(Long id, SysUser userDetails) {
        SysUser user = sysUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("用户不存在：" + id));

        user.setUsername(userDetails.getUsername());
        user.setNickname(userDetails.getNickname());
        user.setEmail(userDetails.getEmail());
        user.setPhone(userDetails.getPhone());
        user.setStatus(userDetails.getStatus());
        user.setRoles(userDetails.getRoles());

        // 如果密码不为空，则更新密码
        if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        }

        return sysUserRepository.save(user);
    }

    public void deleteUser(Long id) {
        sysUserRepository.deleteById(id);
    }
}
