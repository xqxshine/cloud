package com.linkedbear.spring6.cloud.user.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sys_permission")
public class SysPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String permissionName;
    private String permissionCode;
    private String description;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private SysMenu menu;

    // getter和setter方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SysMenu getMenu() {
        return menu;
    }

    public void setMenu(SysMenu menu) {
        this.menu = menu;
    }
}
