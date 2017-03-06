mongo

use testkidsdb

db.createCollection("userInfo",
    {
        validator : { $and:
            [
                { citizenID : { $type : "string" } },
                { userName : { $type : "string" } },
                { authCode : { $type : "string" } },
                { firstName : { $type: "string" } },
                { lastName : { $type: "string" } },
                { phoneNo : { $type : "string" } },
                {
                    emailAddress : {
                        $regex : /@mongodb\.com$/,
                        $type : "string"
                    }
                },
                {
                    userStatus : {
                        $in : [ NumberInt(1), NumberInt(2), NumberInt(3) ] ,
                        $type : "int"
                    }
                },
                { createDate : { $type : "date" } },
                { createBy : { $type : "string" } }
            ]
        },
        validationLevel: "moderate",
        validationAction : "error"
    }
)

db.getCollection('userInfo').createIndex(
    { citizenID : 1 },
    { name: "citizenID_asc" ,unique: true }
)

db.getCollection('userInfo').insert([
	{
		citizenID : "9385739109836",
		userName : "Joke",
		authCode : "0192967Spring",
		firstName : "Javax",
		lastName : "Spring",
		phoneNo : "02947164648",
		emailAddress : "javax_Spring@mongodb.com",
		userStatus : NumberInt(1),
		createDate : new Date(),
        createBy : "Admin"
	},
	{
        citizenID : "9385739109777",
        userName : "Jav",
        authCode : "0192967Mongo",
        firstName : "Javax",
        lastName : "Mongo",
        phoneNo : "02947164777",
        emailAddress : "javax_Mongo@mongodb.com",
        userStatus : NumberInt(1),
        createDate : new Date(),
        createBy : "Admin"
    }
])

exit


#db.getCollection('userInfo').updateMany({},
#    {
#        "$currentDate": { "createDate": {"$type": "date" } },
#        "$set":{"createBy" : "Admin"}
#    }
#)

#db.getCollection('userInfo').remove({})
#db.getCollection('userInfo').drop()
#db.dropDatabase()

