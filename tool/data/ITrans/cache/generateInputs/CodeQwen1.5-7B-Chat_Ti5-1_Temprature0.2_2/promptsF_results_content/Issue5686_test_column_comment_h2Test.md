## New input pair1:
```java
    String sql = "INSERT INTO TABLE_TEST_1(\n" + "\tDATE_ID,-- qianzhushi\n" + "\tCUS_NO -- houzhushi\n,\n" + "\tCUS_NAME\n" + ")\n" + "SELECT A.DATE_ID,\n" + "\tA.CUS_NO,\n" + "\tA.CUS_NAME\n" + "FROM TABLE_TEST_2 \n" + "WHERE COL1='1';";
    MySqlInsertStatement sqlStatement = (MySqlInsertStatement) SQLUtils.parseSingleStatement(sql, DbType.mysql, true);
    MySqlInsertStatement sqlStatement2 = (MySqlInsertStatement) SQLUtils.parseSingleStatement(sql, DbType.mysql, true);
    sqlStatement2.getColumns().get(0).addAfterComment("-- comment注释0");
    sqlStatement2.getColumns().get(1).addAfterComment("-- comment注释1");
    sqlStatement2.getColumns().get(2).addAfterComment("-- comment注释2");
```

## Explanation:
In the new input pair1, the inferred relation is that the `MySqlInsertStatement` object `sqlStatement` and `sqlStatement2` should have the same structure and content after adding comments to their columns. The comments are added to the columns of `sqlStatement2` in the same order as they were added to the columns of `sqlStatement`. This satisfies the inferred relation because the structure and content of the two `MySqlInsertStatement` objects are the same, and the comments are added in the same order.