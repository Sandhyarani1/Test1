package com.chameleon.database.databaseImpl;

import com.chameleon.database.Database;

public class MariaDBDatabase extends Database {
    public MariaDBDatabase(String host, String port, String dbName) {
        super.driver = "org.mariadb.jdbc.Driver";
        super.connectionString = "jdbc:mariadb://" + host + ":" + port + "/" + dbName;
    }
}
