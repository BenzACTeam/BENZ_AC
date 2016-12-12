package com.benz.framework.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by paulliu on 2016/12/12.
 */
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    String nextIdentity();
}