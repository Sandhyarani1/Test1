package com.chameleon.database;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

import com.chameleon.database.exceptions.DatabaseException;

public class Recordset {
    private int columnRow = 0;
    private int startRow = 1;
    private int totalRows = 0;
    private int totalColumns = 0;
    private int currentRow = 1;
    private Object[][] rs = null;

    public Recordset(Object[][] rs) {
        this.rs = rs;
        this.totalRows = rs.length - 1;
        this.totalColumns = rs[columnRow].length;
    }

    public Object[][] getArray() {
        return rs;
    }

    public int getRowCount() {
        return totalRows;
    }

    public int getColumnCount() {
        return totalColumns;
    }

    public void moveFirst() {
        currentRow = startRow;
    }

    public void moveNext() {
        if (currentRow <= totalRows + 1) {
            currentRow++;
        }
    }

    public void movePrevious() {
        if (currentRow > startRow) {
            currentRow--;
        }
    }

    public void moveLast() {
        currentRow = totalRows;
    }

    public boolean isFirst() {
        if (currentRow == startRow) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasNext() {
        if (currentRow <= totalRows) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isLast() {
        if (currentRow > totalRows) {
            return true;
        } else {
            return false;
        }
    }

    public int getColumnIndex(String name) {
        int index = 0;
        for (int columnIndex = 0; columnIndex < totalColumns; columnIndex++) {
            if (rs[columnRow][columnIndex].toString().equalsIgnoreCase(name)) {
                index = columnIndex + 1;
                break;
            }
        }
        return index;
    }

    public Object getObject(String columnName) {
        int index = -1;
        if (columnName.isEmpty()) {
            throw new DatabaseException("Column name cannot be blank. Column name entered was: " + columnName);
        }
        index = getColumnIndex(columnName) - 1;
        if (index == -1) {
            return ""; // Return blank value if no column found
        }
        return rs[currentRow][index];
    }

    public Long getLong(String columnName) {
        if (getObject(columnName) instanceof Long) {
            return (Long) getObject(columnName);
        } else {
            return Long.parseLong(getValue(columnName));
        }
    }

    public int getInt(String columnName) {
        if (getObject(columnName) instanceof Integer) {
            return (int) getObject(columnName);
        } else {
            return Integer.parseInt(getValue(columnName));
        }
    }

    public String getString(String columnName) {
        if (getObject(columnName) instanceof String) {
            return (String) getObject(columnName);
        } else {
            return String.valueOf(getValue(columnName));
        }
    }

    public Boolean getBoolean(String columnName) {
        if (getObject(columnName) instanceof Boolean) {
            return (Boolean) getObject(columnName);
        } else {
            return Boolean.parseBoolean(getValue(columnName));
        }
    }

    public double getDouble(String columnName) {
        if (getObject(columnName) instanceof Double) {
            return (double) getObject(columnName);
        } else {
            return Double.parseDouble(getValue(columnName));
        }
    }

    public BigDecimal getBigDecimal(String columnName) {
        if (getObject(columnName) instanceof BigDecimal) {
            return (BigDecimal) getObject(columnName);
        } else {
            return new BigDecimal(getValue(columnName));
        }
    }

    public Date getDate(String columnName) {
        if (getObject(columnName) instanceof Date) {
            return (Date) getObject(columnName);
        } else if (getObject(columnName) instanceof String) {
            return Date.valueOf(getValue(columnName));
        } else {
            throw new DatabaseException("Field is not type of Date or String, cannot convert to Date");
        }
    }

    public Timestamp getTimestamp(String columnName) {

        if (getObject(columnName) instanceof Timestamp) {
            return (Timestamp) getObject(columnName);
        } else if (getObject(columnName) instanceof String) {
            return Timestamp.valueOf(getValue(columnName));
        } else {
            throw new DatabaseException("Field is not type of Timestamp or String, cannot convert to Timestamp");
        }
    }

    public String getValue(String columnName) {
        int index = -1;
        if (columnName.isEmpty()) {
            throw new DatabaseException("Column name cannot be blank. Column name entered was: " + columnName);
        }
        index = getColumnIndex(columnName) - 1;
        if (index == -1) {
            return ""; // Return blank value if no column found
        }
        return Objects.toString(rs[currentRow][index]);
    }

    public String getValue(String columnName, int row) {
        int index = -1;
        if (columnName.isEmpty()) {
            throw new DatabaseException("Column name cannot be blank. Column name entered was: " + columnName);
        }
        if (row < 0) {
            throw new DatabaseException("Start row value needs to be 1 or greater. Start row entered was: " + row);
        }
        index = getColumnIndex(columnName) - 1;
        if (index == -1) {
            return ""; // Return blank value if no column found
        }
        return Objects.toString(rs[row][index]);
    }

    public String getValue(int column, int row) {
        if (column < 0) {
            throw new DatabaseException("Start row value needs to be 1 or greater. Start row entered was: " + column);
        }
        if (row < 0) {
            throw new DatabaseException("Start row value needs to be 1 or greater. Start row entered was: " + row);
        }
        return Objects.toString(rs[row][--column]);
    }

    public String printString() {
        return PrettyPrinter.print(rs);
    }

    public void print() {
        System.out.println(PrettyPrinter.print(rs));
    }

}
