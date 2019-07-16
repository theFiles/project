package lmysql.query;

import lmysql.LMysql;
import lmysql.Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Insert extends LMysql<Insert,Integer> {
    private String[] fields;
    private List values = new ArrayList();

    public Insert(Connection conn, String[] arr){
        setConn(conn);
        fields = arr;
    }

    /**
     * 设置插入的内容
     */
    public Insert value(Object... values){
        String valueStr = '('+arrayToString(values,"'")+')';
        this.values.add(valueStr);
        return this;
    }

    public String getFields() {
        return '('+arrayToString(fields,"`")+')';
    }

    public String getValues() {
        int len = values.size();
        StringBuffer buff = new StringBuffer();
        if(len > 0){
            buff.append(values.get(0));
            for (int i=1; i<len; i++){
                buff.append(","+values.get(i));
            }
        }
        return buff.toString();
    }

    @Override
    public Insert getThis() {
        return this;
    }

    @Override
    public String getSql() {
        return "INSERT INTO "+getFrom()+getFields()+" VALUES "+getValues();
    }

    @Override
    public Integer query() {
        return update();
    }
}
