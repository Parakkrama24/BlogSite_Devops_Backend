package com.devops.BlogSite.repository;

import com.devops.BlogSite.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<user,Long> {

    //check why username
    public user findUserByEmail(String userName);

}
