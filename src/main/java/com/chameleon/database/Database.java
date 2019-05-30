package com.chameleon.database;

import static com.chameleon.utils.TestReporter.logTrace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.chameleon.database.exceptions.DatabaseException;

public class Database {

    protected String driver = null;
    private String host = null;
    private String port = null;
    private String service = null;
    private String username = null;
    private String password = null;
    private boolean returnString = true;
    protected String connectionString = null;
    protected boolean isTypeForwardOnly = false;

    protected String getDbDriver() {
        return this.driver;
    }

    protected String getDbHost() {
        return this.host;
    }

    protected String getDbPort() {
        return this.port;
    }

    protected String getDbService() {
        return this.service;
    }

    public void setDbUserName(String username) {
        this.username = username;
    }

    protected String getDbUserName() {
        return this.username;
    }

    public void setDbPassword(String password) {
        this.password = password;
    }

    protected String getDbPassword() {
        return this.password;
    }

    protected String getDbConnectionString() {
        return connectionString;
    }

    public void setReturnAsString(boolean returnString) {
        this.returnString = returnString;
    }

    public Object[][] getResultSetAsDataProvider(String query) {
        List<Object[]> list = new ArrayList<>(Arrays.asList(getResultSet(query)));
        list.remove(0);
        return list.toArray(new Object[][] {});
    }

    public Object[][] getResultSet(String query) {
        logTrace("Entering Database#getResultSet");
        if (driver != null) {
            loadDriver();
        }

        logTrace("Attempt to connect to database [ " + connectionString + " ]");
        int type = isTypeForwardOnly ? ResultSet.TYPE_FORWARD_ONLY : ResultSet.TYPE_SCROLL_INSENSITIVE;
        try (Connection connection = DriverManager.getConnection(connectionString, username, password);
                Statement statement = connection.createStatement(type, ResultSet.CONCUR_READ_ONLY);
                ResultSet resultSet = statement.executeQuery(query);) {
            logTrace("Query results returned with no errors. Parsing results");
            Object[][] parsedRs = extract(resultSet, statement, query);
            logTrace("Exiting Database#getResultSet");
            return parsedRs;

        } catch (Exception e) {
            throw new DatabaseException("Failed to extract data into a Recordset", e);
        }
    }

    private void loadDriver() {
        logTrace("Entering Database#loadDriver");
        try {
            logTrace("Attempting to load driver [ " + driver + " ]");
            Class.forName(driver);
            logTrace("Successfully loaded driver [ " + driver + " ]");
        } catch (ClassNotFoundException cnfe) {
            throw new DatabaseException("Driver class not found. Ensure requested driver jar is referenced in POM", cnfe);
        }
        logTrace("Exiting Database#loadDriver");
    }

    /**
     * Returns an ArrayList of ArrayLists of Strings extracted from a
     * ResultSet retrieved from the database.
     *
     * @param resultSet
     *            ResultSet to extract Strings from
     * @return an ArrayList of ArrayLists of Strings
     * @throws SQLException
     *             if an SQL exception occurs
     */
    private Object[][] extract(ResultSet resultSet, Statement statement, String query) throws SQLException {
        logTrace("Entering Database#extract");
        // get row and column count
        int rowCount = 0;
        try {
            logTrace("Determining number of rows in results");
            if (isTypeForwardOnly) {
                // Database type does not support commands for moving forward and backward
                // To determine row count, need to iterate through once, then re-query
                // to get back to start
                while (resultSet.next()) {
                    rowCount++;
                }
                resultSet = statement.executeQuery(query);
            } else {
                resultSet.last();
                rowCount = resultSet.getRow();
                resultSet.beforeFirst();
            }
            logTrace("Rows to to be extracted [ " + rowCount + " ] ");
        } catch (Exception ex) {
            rowCount = 0;
        }

        logTrace("Determining number of columns in results");
        int columnCount = resultSet.getMetaData().getColumnCount();
        logTrace("Columns to to be extracted [ " + columnCount + " ] ");

        logTrace("Generating Object array for the size of String[" + (rowCount + 1) + "][" + columnCount + "] (One row added for column headers)");
        Object[][] table = null;

        if (returnString) {
            table = new String[rowCount + 1][columnCount];
        } else {
            table = new Object[rowCount + 1][columnCount];
        }

        logTrace("Retrieve Result Set metadata");
        ResultSetMetaData rsmd = resultSet.getMetaData();

        logTrace("Extacting data from ResultSet and storing in Object[][]");
        for (int rowNum = 0; rowNum <= rowCount; rowNum++) {
            for (int colNum = 0, rsColumn = 1; colNum < columnCount; colNum++, rsColumn++) {

                if (rowNum == 0) {
                    table[rowNum][colNum] = resultSet.getMetaData().getColumnName(rsColumn);
                } else if (resultSet.getString(colNum + 1) == null) {
                    if (returnString) {
                        table[rowNum][colNum] = "NULL";
                    } else {
                        table[rowNum][colNum] = null;
                    }
                    continue;
                } else if (returnString) {
                    try {
                        switch (rsmd.getColumnType(rsColumn)) {
                            case Types.DATE:
                            case Types.TIMESTAMP:
                                table[rowNum][colNum] = String.valueOf(resultSet.getTimestamp(rsColumn));
                                break;
                            case Types.TIME:
                                table[rowNum][colNum] = resultSet.getTime(rsColumn);
                                break;
                            default:
                                table[rowNum][colNum] = resultSet.getString(rsColumn).intern();
                                break;
                        }
                    } catch (Exception e) {
                        table[rowNum][colNum] = resultSet.getString(rsColumn).intern();
                    }
                } else {
                    table[rowNum][colNum] = determineExactType(rsmd.getColumnType(rsColumn), resultSet, rsColumn);
                }
            }
            resultSet.next();
        }

        logTrace("Extraction complete");
        logTrace("Exiting Database#extract");
        return table;
    }

    private Object determineExactType(int type, ResultSet resultSet, int index) throws SQLException {
        switch (type) {
            case Types.DOUBLE:
                return resultSet.getDouble(index);
            case Types.BIT:
                return resultSet.getBoolean(index);
            case Types.CHAR:
            case Types.VARCHAR:
                return resultSet.getString(index);
            case Types.DATE:
                return resultSet.getDate(index);
            case Types.TIMESTAMP:
                return resultSet.getTimestamp(index);
            case Types.TIME:
                return resultSet.getTime(index);
            case Types.TINYINT:
            case Types.SMALLINT:
            case Types.INTEGER:
                return resultSet.getInt(index);
            case Types.FLOAT:
                return resultSet.getFloat(index);
            case Types.BIGINT:
                return resultSet.getLong(index);
            case Types.DECIMAL:
                return resultSet.getBigDecimal(index);
            case Types.BLOB:
                return resultSet.getBlob(index);
            case Types.CLOB:
                return resultSet.getClob(index);
            default:
                return resultSet.getString(index).intern();
        }
    }

}
