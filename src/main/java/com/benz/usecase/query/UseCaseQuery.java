package com.benz.usecase.query;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by hongying.fu on 12/15/2016.
 */
@Component
public class UseCaseQuery {

    @PersistenceContext
    private EntityManager em;

    public Page2<UseCaseResult> findAll(UseCaseParameter parameter, Integer pageNo, Integer pageSize) {
        Page2<UseCaseResult> page = getUseCaseResult(parameter, pageNo, pageSize, "findAll", "totalCount");
        return page;
    }

    private Page2<UseCaseResult> getUseCaseResultPage(UseCaseParameter parameter, Integer pageNo, Integer pageSize, String findAll, String totalCount1) {
        Query query = em.createNamedQuery(findAll);
        Query countQuery = em.createNamedQuery("totalCount");
        Integer totalCount = (Integer) countQuery.getSingleResult();

        Page2<UseCaseResult> page = new Page2<UseCaseResult>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        page.setTotalCount(totalCount);

        query.setFirstResult((pageNo - 1) * pageSize);
        query.setMaxResults(pageNo * pageSize);


        List<UseCaseResult> resultList = query.getResultList();


        page.setList(resultList);
        return page;
    }
    private Page2<UseCaseResult> getUseCaseResult(UseCaseParameter parameter, Integer pageNo, Integer pageSize, String findAll, String totalCountSQL) {
        Query query = em.createNamedQuery(findAll);
        Query countQuery = em.createNamedQuery(totalCountSQL);
        String sqlString = query.unwrap(SQLQuery.class).getQueryString();
        String countSql = countQuery.unwrap(SQLQuery.class).getQueryString();

        Page2<UseCaseResult> page = new Page2<UseCaseResult>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);

        String sqlWhere = "";
        Class useCaseParameterCla = parameter.getClass();
        Field[] fs = useCaseParameterCla.getDeclaredFields();
        try {
            for(int i = 0 ; i < fs.length; i++){
                Field f = fs[i];
                f.setAccessible(true);
                Object val = f.get(parameter);//得到此属性的值
                String type = f.getType().toString();//得到此属性的类型
                if(type.endsWith("String")){
                    String fieldVal = (String) val;
                    if(fieldVal != null && !"".equals(fieldVal)){
                        sqlWhere += f.getName()+ " = :" + f.getName() + " and ";
                    }
                }

            }
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }

        if(sqlWhere.endsWith(" and ")){
            sqlWhere = sqlWhere.substring(0,sqlWhere.lastIndexOf("and "));
        }
        if(!"".equals(sqlWhere)){
            sqlString += " where "+sqlWhere;
            countSql += " where "+sqlWhere;
        }

        Query countQ = em.createNativeQuery(countSql);
        Query q = em.createNativeQuery(sqlString,"useCaseMapping");

        try {
            for(int i = 0 ; i < fs.length; i++){
                Field f = fs[i];
                f.setAccessible(true);
                Object val = f.get(parameter);//得到此属性的值
                String type = f.getType().toString();//得到此属性的类型
                if(type.endsWith("String")){
                    String fieldVal = (String) val;
                    if(fieldVal != null && !"".equals(fieldVal)){
                        countQ.setParameter(f.getName(),fieldVal);
                        q.setParameter(f.getName(),fieldVal);
                    }
                }

            }
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }

        Integer totalCount = (Integer) countQ.getSingleResult();
        page.setTotalCount(totalCount);

        q.setFirstResult((pageNo - 1) * pageSize);
        q.setMaxResults(pageNo * pageSize);
        List<UseCaseResult> resultList = q.getResultList();
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