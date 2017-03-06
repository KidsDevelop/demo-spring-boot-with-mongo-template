mongo

use testkidsdb

db.createCollection("errorInfo",
    {
        validator : { $and:
            [
                { errorCode : { $type : "string" } },
                { errorMessageTh : { $type : "string" } },
                { errorMessageEn : { $type : "string" } },
                { createDate : { $type : "date" } },
                { createBy : { $type : "string" } }
            ]
        },
        validationLevel: "moderate",
        validationAction : "error"
    }
)

db.getCollection('errorInfo').createIndex(
    { errorCode : 1 },
    { name: "errorCode_asc" ,unique: true }
)

db.getCollection('errorInfo').insert([
	{
		errorCode : "10000",
		errorMessageTh : "ระบบไม่สามารถใช้บริการได้ในขณะนี้กรุณาลองใหม่ภายหลัง",
		errorMessageEn : "Service is not available at this moment. Please try again later.",
		createDate : new Date(),
		createBy : "Admin"
	},
	{
		errorCode : "10001",
		errorMessageTh : "มีผู้เข้าใช้งานด้วยชื่อผู้ใช้งานเดียวกัน",
		errorMessageEn : "Invalid Session",
		createDate : new Date(),
        createBy : "Admin"
	},
	{
		errorCode : "10002",
		errorMessageTh : "ขออภัยไม่มีข้อมูลที่ต้องการค้นหา",
		errorMessageEn : "Not found any data.",
		createDate : new Date(),
        createBy : "Admin"
	}
])

exit

#db.getCollection('errorInfo').remove({})
#db.getCollection('errorInfo').drop()
#db.dropDatabase()
