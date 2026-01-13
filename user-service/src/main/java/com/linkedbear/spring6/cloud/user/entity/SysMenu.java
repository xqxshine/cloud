package com.linkedbear.spring6.cloud.user.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "sys_menu")
public class SysMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String menuName;
    private String path;
    private String component;
    private String icon;
    private Integer orderNum;
    private Long parentId;
    private Integer isFrame; // 0-是, 1-否

    @OneToMany(mappedBy = "menu", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<SysPermission> permissions;

    // getter和setter方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getIsFrame() {
        return isFrame;
    }

    public void setIsFrame(Integer isFrame) {
        this.isFrame = isFrame;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }
}