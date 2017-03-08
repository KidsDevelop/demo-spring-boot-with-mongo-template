mongo

use testkidsdb

db.createCollection("userInfo")

db.getCollection('userInfo').createIndex(
    { citizenID : 1 },
    { name: "citizenID_asc" ,unique: true }
)
exit