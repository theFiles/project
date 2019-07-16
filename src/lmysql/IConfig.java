package lmysql;

import java.sql.Connection;

public interface IConfig {
    String driver            = "com.mysql.cj.jdbc.Driver";
    String host              = "localhost";
    short port               = 3306;
    String root              = "root";
    String pwd               = "root";
    String dbName            = "work";
    String characterEncoding = "utf8";
    boolean useSSL           = false;
    String serverTimezone    = "CST";

    default String getConfigString(){
        return "jdbc:mysql://"+host+":"+port+"/"+dbName+"?characterEncoding="+characterEncoding+"&useSSL="+useSSL+"&serverTimezone="+serverTimezone;
    }
}
