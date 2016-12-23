package com.benz.framework.query;

import org.hibernate.SQLQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by hongying.fu on 12/21/2016.
 */
public class BaseQuery {
    @PersistenceContext
    protected EntityManager em;

    protected <T> PagedList<T> getResult(QueryParameter parameter, String searchName, String countName, String resultMappingName) throws IllegalAccessException {

        Query searchQuery = em.createNamedQuery(searchName);
        Query countQuery = em.createNamedQuery(countName);
        String searchSQL = searchQuery.unwrap(SQLQuery.class).getQueryString();
        String countSQL = countQuery.unwrap(SQLQuery.class).getQueryString();

        String sqlWhere = parameter.generateSQLWhere();
        if (!"".equals(sqlWhere)) {
            searchSQL += " where " + sqlWhere;
            countSQL += " where " + sqlWhere;
        }

        Query countQueryWithWhere = em.createNativeQuery(countSQL);
        Query searchQueryWithWhere = em.createNativeQuery(searchSQL, resultMappingName);

        parameter.setQueryParameter(countQueryWithWhere, searchQueryWithWhere);

        Integer totalCount = (Integer) countQueryWithWhere.getSingleResult();

        Integer pageNo = parameter.getPageNo();
        Integer pageSize = parameter.getPageSize();
        PagedList<T> page = new PagedList<T>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        page.setTotalCount(totalCount);

        searchQueryWithWhere.setFirstResult((pageNo - 1) * pageSize);
        searchQueryWithWhere.setMaxResults(pageNo * pageSize);
        List<T> resultList = searchQueryWithWhere.getResultList();
        page.setList(resultList);

        return page;
    }

}
