package com.benz.framework.jpa;

import org.hibernate.dialect.SQLServerDialect;

import java.sql.Types;

/**
 * Created by paulliu on 2016/12/13.
 */
public class SQLServerNativeDialect  extends SQLServerDialect {

    public SQLServerNativeDialect() {
        super();
        registerColumnType(Types.VARCHAR, "nvarchar($l)");
    }
}
