package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;
    private Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws Exception {
        Class.forName(properties.getProperty("hibernate.connection.driver_class"));
        String url = properties.getProperty("hibernate.connection.url");
        String login = properties.getProperty("hibernate.connection.username");
        String password = properties.getProperty("hibernate.connection.password");
        connection = DriverManager.getConnection(url, login, password);
    }

    public void operationCreator(String operationName) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute(operationName);
        }
    }

    public void createTable(String tableName) throws Exception {
        operationCreator(String.format(
            "CREATE TABLE %s ();", tableName
        ));
    }

    public void dropTable(String tableName) throws Exception {
        operationCreator(String.format(
            "DROP TABLE %s;", tableName
        ));
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        operationCreator(String.format(
            "ALTER TABLE %s ADD COLUMN %s %s;", tableName, columnName, type
        ));
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        operationCreator(String.format(
            "ALTER TABLE %s DROP COLUMN %s;", tableName, columnName
        ));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        operationCreator(String.format(
            "ALTER TABLE %s RENAME COLUMN %s TO %s;", tableName, columnName, newColumnName
        ));
    }

    public String getTableScheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "SELECT * FROM %s LIMIT 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties config = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            config.load(in);
        }
        TableEditor tableEditor = new TableEditor(config);
        String tableName = "example_table";
        String firstColumnName = "first_column";
        String firstColumnType = "SERIAL PRIMARY KEY";
        String secondColumnName = "second_column";
        String secondColumnType = "TEXT";
        String secondColumnRename = "second_column_rename";
        tableEditor.dropTable(tableName);
        tableEditor.createTable(tableName);
        System.out.println(tableEditor.getTableScheme(tableName));
        System.out.println();
        tableEditor.addColumn(tableName, firstColumnName, firstColumnType);
        System.out.println(tableEditor.getTableScheme(tableName));
        System.out.println();
        tableEditor.addColumn(tableName, secondColumnName, secondColumnType);
        System.out.println(tableEditor.getTableScheme(tableName));
        System.out.println();
        tableEditor.renameColumn(tableName, secondColumnName, secondColumnRename);
        System.out.println(tableEditor.getTableScheme(tableName));
        System.out.println();
        tableEditor.dropColumn(tableName, secondColumnRename);
        System.out.println(tableEditor.getTableScheme(tableName));
        System.out.println();
    }
}