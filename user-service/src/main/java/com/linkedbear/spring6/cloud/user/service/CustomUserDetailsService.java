package com.linkedbear.spring6.cloud.user.service;

import com.linkedbear.spring6.cloud.user.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return sysUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("用户不存在：" + username));
    }
}
