package com.benz.usecase.query;


import com.benz.framework.jpa.BaseRepository;
import com.benz.usecase.domain.UseCase;
import org.hibernate.SQLQuery;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongying.fu on 12/15/2016.
 */
@Component
public class UseCaseQuery {

    @PersistenceContext
    private EntityManager em;


    public Page2<UseCaseResult> findAll(UseCaseParameter parameter, Integer pageNo, Integer pageSize) {

        Page2<UseCaseResult> page = getUseCaseResultPage(parameter, pageNo, pageSize, "findAll", "totalCount");
        return page;
    }

    private Page2<UseCaseResult> getUseCaseResultPage(UseCaseParameter parameter, Integer pageNo, Integer pageSize, String findAll, String totalCount1) {
        Query query = em.createNamedQuery(findAll);
//        String sqlString = query.unwrap(SQLQuery.class).getQueryString();


//        Query countQuery = em.createNativeQuery("select count(*) from (" + sqlString + ") totalCount");
        Query countQuery = em.createNamedQuery("totalCount");
//        query = em.createNativeQuery(sqlString);
        Integer totalCount = (Integer) countQuery.getSingleResult();

        Page2<UseCaseResult> page = new Page2<UseCaseResult>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        page.setTotalCount(totalCount);

        query.setParameter(1, page.getStartNum());
        query.setParameter(2, page.getEndNum());
//        query.setFirstResult((pageNo - 1) * pageSize);
//        query.setMaxResults(pageNo * pageSize);


        List<UseCaseResult> resultList = query.getResultList();


        page.setList(resultList);
        return page;
    }

    public UseCaseResult findOne(String id) {
        Query query = em.createNamedQuery("findOne");
        query.setParameter(1, id);
        UseCaseResult result = (UseCaseResult) query.getSingleResult();
        return result;
    }


}