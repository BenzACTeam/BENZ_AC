package com.benz.usecase.domain;

import com.benz.framework.mvc.SpringBootApplicationContext;

/**
 * Created by paulliu on 2016/12/12.
 */
public class DomainRegistry {

    public static UseCaseRepository repository() {
        return SpringBootApplicationContext.getBean(UseCaseRepository.class);
    }

    public static ResultFileRepository resultFileRepository() {
        return SpringBootApplicationContext.getBean(ResultFileRepository.class);
    }

    public static AnalysisModelFileRespository analysisModelFileRespository() {
        return SpringBootApplicationContext.getBean(AnalysisModelFileRespository.class);
    }

}
