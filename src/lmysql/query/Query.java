package lmysql.query;

import lmysql.LMysql;

import java.sql.Connection;
import java.util.List;

public class Query extends LMysql<Query,List> {
    private String sql;

    public Query(Connection conn, String sql) {
        setConn(conn);
        this.sql = sql;
    }

    @Override
    public Query getThis() {
        return this;
    }

    @Override
    public String getSql() {
        return sql;
    }

    @Override
    public List query() {
        return execute();
    }

}
