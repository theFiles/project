package java.util.lmysql;

import java.util.lmysql.query.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 实例化类数据库连接
 */
public class Mysql implements IConfig {
    private static List<String> errorList = new ArrayList<>();
    protected Connection conn = null;

    public Mysql(){
        this.getConn();
    }

    protected boolean getConn(){
        try {
            Class.forName(driver);
            conn = setConnect();
            return true;
        } catch (ClassNotFoundException e) {
            setErrorList(e.getMessage());
            return false;
        }
    }

    public static void setErrorList(String err){
        if(errorList.size() > 4)
            errorList.remove(0);

        errorList.add(err);
    }

    private Connection setConnect(){
        if(conn == null){
            try {
                return DriverManager.getConnection(
                    getConfigString(),
                    root,
                    pwd
                );
            } catch (SQLException e) {
                setErrorList(e.getMessage());
                e.printStackTrace();
            }

            return null;
        }

        return conn;
    }

    public List query(String sql){
        return new Query(conn,sql).query();
    }

    public Select select(){
        return new Select(conn,new String[0]);
    }
    public Select select(String... field){
        return new Select(conn,field);
    }

    public Insert insert(String... str){
        return new Insert(conn,str);
    }

    public Update update(String table){
        return new Update(conn,table);
    }
    public Update update(){
        return new Update(conn);
    }

    public Delete delete(String table){
        return new Delete(conn,table);
    }
    public Delete delete(){
        return new Delete(conn);
    }


    /**
     * 关闭所有对象
     */
    public void close(){
        try {
            if(conn != null)
                conn.close();

        } catch (SQLException e) {
            setErrorList(e.getMessage());
        }
    }

}
