package com.adgile.repository;

import com.adgile.domain.User;
import com.adgile.domain.conditional.UserConditional;

import java.util.List;
import java.util.Optional;

public interface UserCustom {

    Optional<User> findUser(UserConditional where);

    List<User> findUsers(UserConditional where);
}
