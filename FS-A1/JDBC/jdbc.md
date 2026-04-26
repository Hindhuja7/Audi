jdbc is a api/translator used in java applications to connect with database and send sql queries and get result back from db

we have some imp parts that r used in jdbc to connect with database
Driver
Connection
ResultSet
Statement

we use 2 parameters while creating statement : ResultSet.TYPE_FORWARD_ONLY and ResultSet.CONCUR_READ_ONLY
TYPE_FORWARD_ONLY : you can move only forward through data u r not supposed to go backward
TYPE_SCROLL_INSENSITIVE: you can never make changes
TYPE_SCROLL_SENSITIVE: the changes are reflected
CONCUR_READ_ONLY: ur not supposed to update data.just read only CONCUR means modification
CONCUR_UPDATABLE → allows updating data through ResultSet


execute() and executeQuery() this both executes query but execute() is used to execute all DML commands but executeQuery() is used only for 'select' which returns a result

 rs = stmt.getResultSet(); stores the result of a executeQuery() and result = stmt.getUpdateCount(); is used to get the count of rows i.e when u update/delete/insert some set of rows will get change so it returns the count that how many rows are affected

  rs.absolute(2); -> moves to particular row , indexing starts from 1 not 0
  rs.updateString("ename", "Allen"); -> at 2nd row ename gets change to Allen , but this change happens only in memory not in database
rs.updateRow();  -> now data is modified in database

IMPORTANT NOTE: when we r modifying data, make sure that createstatement is scrollable and updatable i.e stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
 
