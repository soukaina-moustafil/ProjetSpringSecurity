package com.example.Tp1;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.Tp1.AppUserPermission.USER_READ;
import static com.example.Tp1.AppUserPermission.USER_WRITE;

public enum AppUserRole {
    //  ADMIN(Sets.newHashSet(USER_READ,USER_WRITE)),
    ADMIN(Sets.newHashSet(USER_WRITE)),
    USER(Sets.newHashSet(USER_READ));

    private final Set<AppUserPermission> permission;

    AppUserRole(Set<AppUserPermission> permission) {
        this.permission = permission;

    }


}
