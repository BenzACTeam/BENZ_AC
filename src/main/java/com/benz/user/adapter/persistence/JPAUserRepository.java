package com.benz.user.adapter.persistence;

import com.benz.user.domain.User;
import com.benz.user.domain.UserRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by paulliu on 2016/12/12.
 */
@Repository
public class JPAUserRepository implements UserRepository {
    @Override
    public User findByName(String name) {
        return null;
    }

    @Override
    public User findByNameAndAge(String name, Integer age) {
        return null;
    }

    @Override
    public User findUser(String name) {
        return null;
    }
}
