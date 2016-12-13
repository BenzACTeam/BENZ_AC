package com.benz.usecase.domain;

import com.benz.framework.ioc.SpringBootApplicationContext;

/**
 * Created by paulliu on 2016/12/12.
 */
public class DomainRegistry {

    public static UseCaseRepository repository() {
        return SpringBootApplicationContext.getBean(UseCaseRepository.class);
    }

}
