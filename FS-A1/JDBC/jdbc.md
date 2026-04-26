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