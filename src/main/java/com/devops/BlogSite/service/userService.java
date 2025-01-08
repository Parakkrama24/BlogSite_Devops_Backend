package com.devops.BlogSite.service;

import com.devops.BlogSite.model.user;

public interface userService {

    public user findUserByEmail(String email);
}
