package com.chameleon.selenium.elements;

import static com.chameleon.utils.TestReporter.logTrace;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.chameleon.selenium.ExtendedDriver;

/**
 * Interface that wraps a WebElement in CheckBox functionality.
 */
public class Table extends Element {

    /**
     * Wraps a WebElement with checkbox functionality.
     *
     * @param extendedElement
     *            to wrap up
     */

    public Table(ExtendedDriver driver, By by) {
        super(driver, by);
    }

    public Table(ExtendedDriver driver, By by, org.openqa.selenium.WebElement element) {
        super(driver, by, element);
    }

    protected List<Element> getRowCollection() {
        logTrace("Entering Webtable#getRowCollection");
        driver.setElementTimeout(1, TimeUnit.SECONDS);
        List<org.openqa.selenium.WebElement> elements = getWrappedElement().findElements(By.xpath("tr|tbody/tr"));
        List<Element> rowCollection = new ArrayList<>();
        elements.forEach(row -> rowCollection.add(new Element(driver, by, row)));
        driver.setElementTimeout(driver.getElementTimeout(), TimeUnit.SECONDS);
        logTrace("Exiting Webtable#getRowCollection");
        return rowCollection;

    }

    protected List<org.openqa.selenium.WebElement> getColumnCollection(Element row) {
        logTrace("Entering Webtable#getColumnCollection");
        driver.setElementTimeout(1, TimeUnit.MILLISECONDS);
        List<org.openqa.selenium.WebElement> columnCollection = row.findElements(By.xpath("th|td"));
        driver.setElementTimeout(driver.getElementTimeout(), TimeUnit.SECONDS);
        logTrace("Exiting Webtable#getColumnCollection");
        return columnCollection;
    }

    /**
     * Attempts to locate the number of child elements with the HTML
     * tag "tr" using xpath. If none are found, the xpath "tbody/tr" is
     * used.
     *
     * @return int - number of rows found for a given table
     */

    public int getRowCount() {
        logTrace("Entering Webtable#getRowCount");
        int rows = getRowCollection().size();
        logTrace("Exiting Webtable#getRowCount");
        return rows;
    }

    /**
     * Attempts to locate the number of child elements with the HTML
     * tag "tr" using xpath. If none are found, the xpath "tbody/tr" is
     * used. All rows are then iterated through until the desired row,
     * determined by the parameter, is found.
     *
     * @param row
     *            - Desired row for which to return a column count
     * @return int - number of columns found for a given row
     */

    public int getColumnCount(int row) {
        logTrace("Entering Webtable#getColumnCount");
        int columns = getColumnCollection(getRowCollection().get(row)).size();
        logTrace("Exiting Webtable#getColumnCount");
        return columns;
    }

    /**
     * Attempts to locate the number of child elements with the HTML
     * tag "tr" using xpath. If none are found, the xpath "tbody/tr" is
     * used. All rows are then iterated through until the desired row,
     * determined by the parameter 'row', is found. For this row, all
     * columns are then iterated through until the desired column,
     * determined by the parameter 'column', is found.
     *
     * @param row
     *            - Desired row in which to search for a particular cell
     * @param column
     *            - Desired column in which to find the cell
     * @return WebElement - the desired cell
     */

    public Element getCell(int row, int column) {
        logTrace("Entering Webtable#getCell");
        driver.setElementTimeout(1, TimeUnit.SECONDS);
        Element cell = new Element(driver, By.xpath(getElementIdentifier() + "/tbody/tr[" + row + "]/td[" + column + "]|" + getElementIdentifier() + "/tbody/tr[" + row + "]/th[" + column
                + "]|" + getElementIdentifier() + "/tr[" + row + "]/td[" + column + "]|" + getElementIdentifier() + "/tr[" + row + "]/th[" + column + "]"));
        driver.setElementTimeout(driver.getElementTimeout(), TimeUnit.SECONDS);
        logTrace("Exiting Webtable#getCell");
        return cell;
    }

    /**
     * Attempts to locate the number of child elements with the HTML
     * tag "tr" using xpath. If none are found, the xpath "tbody/tr" is
     * used. All rows are then iterated through until the desired row,
     * determined by the parameter 'row', is found. For this row, all
     * columns are then iterated through until the desired column,
     * determined by the parameter 'column', is found. The cell found
     * by the row/column indices is then clicked
     *
     * @param row
     *            - Desired row in which to search for a particular cell
     * @param column
     *            - Desired column in which to find the cell
     */

    public void clickCell(int row, int column) {
        logTrace("Entering Webtable#clickCell");
        getCell(row, column).click();
        logTrace("Exiting Webtable#clickCell");
    }

    /**
     * Attempts to locate the number of child elements with the HTML
     * tag "tr" using xpath. If none are found, the xpath "tbody/tr" is
     * used. All rows are then iterated through until the desired row,
     * determined by the parameter 'row', is found. For this row, all
     * columns are then iterated through until the desired column,
     * determined by the parameter 'column', is found.
     *
     * @param row
     *            - Desired row in which to search for a particular cell
     * @param column
     *            - Desired column in which to find the cell
     * @return String - text of cell contents
     */

    public String getCellData(int row, int column) {
        logTrace("Entering Webtable#getCellData");
        String data = getCell(row, column).getText();
        logTrace("Exiting Webtable#getCellData");
        return data;
    }

    /**
     * Attempts to locate the number of child elements with the HTML
     * tag "tr" using xpath. If none are found, the xpath "tbody/tr" is
     * used. All rows are then iterated through as well as each column
     * for each row until the cell with the desired text, determined by
     * the parameter, is found.
     *
     * @param text
     *            - text for which to search
     * @return int - row number containing the desired text
     */

    public int getRowWithCellText(String text) {
        logTrace("Entering Webtable#getRowWithCellText(String text)");
        int row = getRowWithCellText(text, -1, 1, true);
        logTrace("Exiting Webtable#getRowWithCellText(String text)");
        return row;
    }

    /**
     * Attempts to locate the number of child elements with the HTML
     * tag "tr" using xpath. If none are found, the xpath "tbody/tr" is
     * used. All rows are then iterated through as well as each column
     * for each row until the cell with the desired text, determined by
     * the parameter, is found.
     *
     * @param text
     *            - text for which to search
     * @param -
     *            determines if text should match exactly or ignore case
     * @return int - row number containing the desired text
     */

    public int getRowWithCellText(String text, boolean exact) {
        logTrace("Entering Webtable#getRowWithCellText(String text, boolean exact)");
        int row = getRowWithCellText(text, -1, 1, exact);
        logTrace("Exiting Webtable#getRowWithCellText(String text, boolean exact)");
        return row;
    }

    /**
     * Attempts to locate the number of child elements with the HTML
     * tag "tr" using xpath. If none are found, the xpath "tbody/tr" is
     * used. All rows are then iterated through as well as each column
     * for each row until the desired cell is located. The cell text is
     * then validated against the parameter 'text'
     *
     * @param text
     *            - text for which to search
     * @param columnPosition
     *            - column number where the desired text is expected
     * @return int - row number containing the desired text
     */

    public int getRowWithCellText(String text, int columnPosition) {
        logTrace("Entering Webtable#getRowWithCellText(String text, int columnPosition)");
        int row = getRowWithCellText(text, columnPosition, 1, true);
        logTrace("Exiting Webtable#getRowWithCellText(String text, int columnPosition)");
        return row;
    }

    /**
     * Attempts to locate the number of child elements with the HTML
     * tag "tr" using xpath. If none are found, the xpath "tbody/tr" is
     * used. All rows are then iterated through as well as each column
     * for each row until the desired cell is located. The cell text is
     * then validated against the parameter 'text'
     *
     * @param text
     *
     *            - text for which to search
     * @param columnPosition
     *            - column number where the desired text is expected
     * @param startRow
     *            - row with which to start
     * @return int - row number containing the desired text
     */

    public int getRowWithCellText(String text, int columnPosition, int startRow) {
        logTrace("Entering Webtable#getRowWithCellText(String text, int columnPosition, int startRow)");
        int row = getRowWithCellText(text, columnPosition, startRow, true);
        logTrace("Exiting Webtable#getRowWithCellText(String text, int columnPosition, int startRow)");
        return row;
    }

    /**
     * Attempts to locate the number of child elements with the HTML
     * tag "tr" using xpath. If none are found, the xpath "tbody/tr" is
     * used. All rows are then iterated through as well as each column
     * for each row until the desired cell is located. The cell text is
     * then validated against the parameter 'text'
     *
     * @param text
     *            - text for which to search
     * @param columnPosition
     *            - column number where the desired text is expected
     * @param startRow
     *            - row with which to start
     * @param exact
     *            - determines if text should match exactly or ignore case
     * @return int - row number containing the desired text
     */

    public int getRowWithCellText(String text, int columnPosition, int startRow, boolean exact) {
        logTrace("Entering Webtable#getRowWithCellText(String text, int columnPosition, int startRow, boolean exact)");
        int currentRow = 1, rowFound = 0;

        List<Element> rowCollection = getRowCollection();
        for (Element rowElement : rowCollection) {
            if (startRow > currentRow) {
                currentRow++;
            } else {
                if (currentRow <= rowCollection.size()) {

                    if (columnPosition == -1) {
                        for (org.openqa.selenium.WebElement cell : getColumnCollection(rowElement)) {
                            if (exact) {
                                if (cell.getText().trim().equals(text)) {
                                    logTrace("Exiting Webtable#getRowWithCellText(String text, int columnPosition, int startRow, boolean exact)");
                                    return currentRow;
                                }
                            } else {
                                if (cell.getText().toLowerCase().trim().contains(text.toLowerCase())) {
                                    logTrace("Exiting Webtable#getRowWithCellText(String text, int columnPosition, int startRow, boolean exact)");
                                    return currentRow;
                                }
                            }
                        }
                    } else {
                        org.openqa.selenium.WebElement cell = rowElement.findElements(By.xpath("th|td")).get(columnPosition - 1);
                        if (exact) {
                            if (cell.getText().trim().equals(text)) {
                                logTrace("Exiting Webtable#getRowWithCellText(String text, int columnPosition, int startRow, boolean exact)");
                                return currentRow;
                            }
                        } else {
                            if (cell.getText().toLowerCase().trim().contains(text.toLowerCase())) {
                                logTrace("Exiting Webtable#getRowWithCellText(String text, int columnPosition, int startRow, boolean exact)");
                                return currentRow;
                            }
                        }
                    }
                    currentRow++;
                }
            }
        }

        logTrace("Exiting Webtable#getRowWithCellText(String text, int columnPosition, int startRow, boolean exact)");
        return rowFound;
    }

    /**
     * Attempts to locate the number of child elements with the HTML
     * tag "tr" using xpath. If none are found, the xpath "tbody/tr" is
     * used. All rows are then iterated through as well as each column
     * for each row until the desired cell is located. The cell text is
     * then validated against the parameter 'text'
     *
     * @param text
     *            - text for which to search
     * @return int - column number containing the desired text
     */

    public int getColumnWithCellText(String text) {
        logTrace("Entering Webtable#getColumnWithCellText(String text)");
        int column = getColumnWithCellText(text, 1);
        logTrace("Exiting Webtable#getColumnWithCellText(String text)");
        return column;
    }

    /**
     * Attempts to locate the number of child elements with the HTML
     * tag "tr" using xpath. If none are found, the xpath "tbody/tr" is
     * used. All rows are then iterated through until the desired row
     * is found, then all columns are iterated through until the
     *
     * @param text
     *            - text for which to search
     * @param rowPosition
     *            - row where the expected text is anticipated
     * @return int - column number containing the desired text
     */

    public int getColumnWithCellText(String text, int rowPosition) {
        logTrace("Entering Webtable#getColumnWithCellText(String text, int rowPosition)");
        int currentColumn = 1;
        List<org.openqa.selenium.WebElement> columns = getColumnCollection(getRowCollection().get(rowPosition - 1));
        for (org.openqa.selenium.WebElement cell : columns) {
            if (currentColumn <= columns.size()) {
                if (cell.getText().trim().equals(text)) {
                    logTrace("Exiting Webtable#getColumnWithCellText(String text, int rowPosition)");
                    return currentColumn;
                }
                currentColumn++;
            }
        }
        logTrace("Exiting Webtable#getColumnWithCellText(String text, int rowPosition)");
        return 0;
    }

}