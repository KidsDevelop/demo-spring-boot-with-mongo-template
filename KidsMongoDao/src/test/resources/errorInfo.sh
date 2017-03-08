mongo

use testkidsdb

db.createCollection("errorInfo")

db.getCollection('errorInfo').createIndex(
    { errorCode : 1 },
    { name: "errorCode_asc" ,unique: true }
)
exit