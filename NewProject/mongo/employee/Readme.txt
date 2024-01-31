Entry Level

a) Add Employee to a Database: 

http://localhost:8081/addEmp
POST
Request :

{
        "id": "05935ea4-a928-47d2-8aac-ecd47f01101f",
        "employeeName": "Tim David",
        "phoneNumber": "987-654-3210",
        "email": "Tim.David@example.com",
        "role": "Developer",
        "reportsTo": "f8d10753-0396-4cb7-8f8a-917413e08a07",
        "profileImage": "https://example.com/tim-profile.jpg"
    }

Response :

05935ea4-a928-47d2-8aac-ecd47f01101f

b) Get All Employees:

http://localhost:8081/getAllEmps
GET
Response :

[
    {
        "id": "27920d73-291c-40b4-9fc0-9ae18c99022d",
        "employeeName": "Jane Smith",
        "phoneNumber": "987-654-3210",
        "email": "jane.smith@example.com",
        "role": "developer",
        "reportsTo": "7cf16192-fab9-4dc3-aaf1-cc361daa7a8e",
        "profileImage": "https://example.com/jane-profile.jpg"
    },
    {
        "id": "f8d10753-0396-4cb7-8f8a-917413e08a07",
        "employeeName": "sam Doe",
        "phoneNumber": "987-345-6380",
        "email": "sam.Doe@example.com",
        "role": "Senior-Manager",
        "reportsTo": "null",
        "profileImage": "https://example.com/jane-profile.jpg"
    },
    {
        "id": "22bbeb48-586f-4292-9d29-6fb1e87508d1",
        "employeeName": "Bob Johnson",
        "phoneNumber": "555-123-4567",
        "email": "bob.johnson@example.com",
        "role": "Manager",
        "reportsTo": "f8d10753-0396-4cb7-8f8a-917413e08a07",
        "profileImage": "https://example.com/bob-profile.jpg"
    },
    {
        "id": "7cf16192-fab9-4dc3-aaf1-cc361daa7a8e",
        "employeeName": "peter jon",
        "phoneNumber": "777-323-7837",
        "email": "peter.jon@example.com",
        "role": "Manager",
        "reportsTo": "f8d10753-0396-4cb7-8f8a-917413e08a07",
        "profileImage": "https://example.com/peter-profile.jpg"
    },
    {
        "id": "4f250eff-ac52-48da-af2c-91677997c887",
        "employeeName": "santhosh kumar",
        "phoneNumber": "888-834-0912",
        "email": "santhosh.kumar@example.com",
        "role": "Developer",
        "reportsTo": "7cf16192-fab9-4dc3-aaf1-cc361daa7a8e",
        "profileImage": "https://example.com/santhosh-profile.jpg"
    },
    {
        "id": "49eabcaa-e1b5-4d07-b221-280b00f6e1f2",
        "employeeName": "David Jhon",
        "phoneNumber": "832-785-6091",
        "email": "david.jhon@example.com",
        "role": "Developer",
        "reportsTo": "22bbeb48-586f-4292-9d29-6fb1e87508d1",
        "profileImage": "https://example.com/Daavid-profile.jpg"
    },
    {
        "id": "05935ea4-a928-47d2-8aac-ecd47f01101f",
        "employeeName": "Tim David",
        "phoneNumber": "987-654-3210",
        "email": "Tim.David@example.com",
        "role": "Developer",
        "reportsTo": "f8d10753-0396-4cb7-8f8a-917413e08a07",
        "profileImage": "https://example.com/tim-profile.jpg"
    }
]

  II) Get All Employees by Id:
            
http://localhost:8081/getEmp/27920d73-291c-40b4-9fc0-9ae18c99022d
GET
Response :

{
    "id": "27920d73-291c-40b4-9fc0-9ae18c99022d",
    "employeeName": "Jane Smith",
    "phoneNumber": "987-654-3210",
    "email": "jane.smith@example.com",
    "role": "developer",
    "reportsTo": "7cf16192-fab9-4dc3-aaf1-cc361daa7a8e",
    "profileImage": "https://example.com/jane-profile.jpg"
}


c) Delete Employee by ID:

http://localhost:8081/deleteEmp/49eabcaa-e1b5-4d07-b221-280b00f6e1f2
DELETE
Respose :
Successfully Deleted


d)Update Employee by ID:

Original Data  :
{  
  "employeeName": "Tim David",
  "phoneNumber": "987-654-3210",
  "email": "Tim.David@example.com",
  "role":"Developer",
  "reportsTo": "f8d10753-0396-4cb7-8f8a-917413e08a07",
  "profileImage": "https://example.com/tim-profile.jpg
}

http://localhost:8081/updateEmp/f8d10753-0396-4cb7-8f8a-917413e08a07
POST
Request:
{
  "employeeName": "Tim David",
  "phoneNumber": "674-097-456",
  "email": "Tim.David@example.com",
  "role":"Developer",
  "reportsTo": "f8d10753-0396-4cb7-8f8a-917413e08a07",
  "profileImage": "https://example.com/tim-profile.jpg"
}

Resonse:

{
    "id": "f8d10753-0396-4cb7-8f8a-917413e08a07",
    "employeeName": "Tim David",
    "phoneNumber": "674-097-456",
    "email": "Tim.David@example.com",
    "role": "Developer",
    "reportsTo": "f8d10753-0396-4cb7-8f8a-917413e08a07",
    "profileImage": "https://example.com/tim-profile.jpg"
}


Intermediate:

a)Get nth Level Manager of an Employee:

http://localhost:8081/getNthLevelManager/4f250eff-ac52-48da-af2c-91677997c887/1
GET
Response :

{
    "id": "7cf16192-fab9-4dc3-aaf1-cc361daa7a8e",
    "employeeName": "peter jon",
    "phoneNumber": "777-323-7837",
    "email": "peter.jon@example.com",
    "role": "Manager",
    "reportsTo": "f8d10753-0396-4cb7-8f8a-917413e08a07",
    "profileImage": "https://example.com/peter-profile.jpg"
}


b)Get Employees with Pagination and Sorting: based on fileds

Example-1 ==> sort based on employee name.

http://localhost:8081/getAllEmployees?page=0&size=10&sortBy=employeeName
GET
Response :

{
    "content": [
        {
            "id": "22bbeb48-586f-4292-9d29-6fb1e87508d1",
            "employeeName": "Bob Johnson",
            "phoneNumber": "555-123-4567",
            "email": "bob.johnson@example.com",
            "role": "Manager",
            "reportsTo": "f8d10753-0396-4cb7-8f8a-917413e08a07",
            "profileImage": "https://example.com/bob-profile.jpg"
        },
        {
            "id": "49eabcaa-e1b5-4d07-b221-280b00f6e1f2",
            "employeeName": "David Jhon",
            "phoneNumber": "832-785-6091",
            "email": "david.jhon@example.com",
            "role": "Developer",
            "reportsTo": "22bbeb48-586f-4292-9d29-6fb1e87508d1",
            "profileImage": "https://example.com/Daavid-profile.jpg"
        },
        {
            "id": "27920d73-291c-40b4-9fc0-9ae18c99022d",
            "employeeName": "Jane Smith",
            "phoneNumber": "987-654-3210",
            "email": "jane.smith@example.com",
            "role": "developer",
            "reportsTo": "7cf16192-fab9-4dc3-aaf1-cc361daa7a8e",
            "profileImage": "https://example.com/jane-profile.jpg"
        },
        {
            "id": "7cf16192-fab9-4dc3-aaf1-cc361daa7a8e",
            "employeeName": "peter jon",
            "phoneNumber": "777-323-7837",
            "email": "peter.jon@example.com",
            "role": "Manager",
            "reportsTo": "f8d10753-0396-4cb7-8f8a-917413e08a07",
            "profileImage": "https://example.com/peter-profile.jpg"
        },
        {
            "id": "f8d10753-0396-4cb7-8f8a-917413e08a07",
            "employeeName": "sam Doe",
            "phoneNumber": "987-345-6380",
            "email": "sam.Doe@example.com",
            "role": "Senior-Manager",
            "reportsTo": "null",
            "profileImage": "https://example.com/jane-profile.jpg"
        },
        {
            "id": "4f250eff-ac52-48da-af2c-91677997c887",
            "employeeName": "santhosh kumar",
            "phoneNumber": "888-834-0912",
            "email": "santhosh.kumar@example.com",
            "role": "Developer",
            "reportsTo": "7cf16192-fab9-4dc3-aaf1-cc361daa7a8e",
            "profileImage": "https://example.com/santhosh-profile.jpg"
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 10,
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 6,
    "size": 10,
    "number": 0,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "first": true,
    "numberOfElements": 6,
    "empty": false
}

Example-2 ==> sort based on phone number

http://localhost:8081/getAllEmployees?page=0&size=10&sortBy=phoneNumber
GET
Response:

{
    "content": [
        {
            "id": "22bbeb48-586f-4292-9d29-6fb1e87508d1",
            "employeeName": "Bob Johnson",
            "phoneNumber": "555-123-4567",
            "email": "bob.johnson@example.com",
            "role": "Manager",
            "reportsTo": "f8d10753-0396-4cb7-8f8a-917413e08a07",
            "profileImage": "https://example.com/bob-profile.jpg"
        },
        {
            "id": "7cf16192-fab9-4dc3-aaf1-cc361daa7a8e",
            "employeeName": "peter jon",
            "phoneNumber": "777-323-7837",
            "email": "peter.jon@example.com",
            "role": "Manager",
            "reportsTo": "f8d10753-0396-4cb7-8f8a-917413e08a07",
            "profileImage": "https://example.com/peter-profile.jpg"
        },
        {
            "id": "49eabcaa-e1b5-4d07-b221-280b00f6e1f2",
            "employeeName": "David Jhon",
            "phoneNumber": "832-785-6091",
            "email": "david.jhon@example.com",
            "role": "Developer",
            "reportsTo": "22bbeb48-586f-4292-9d29-6fb1e87508d1",
            "profileImage": "https://example.com/Daavid-profile.jpg"
        },
        {
            "id": "4f250eff-ac52-48da-af2c-91677997c887",
            "employeeName": "santhosh kumar",
            "phoneNumber": "888-834-0912",
            "email": "santhosh.kumar@example.com",
            "role": "Developer",
            "reportsTo": "7cf16192-fab9-4dc3-aaf1-cc361daa7a8e",
            "profileImage": "https://example.com/santhosh-profile.jpg"
        },
        {
            "id": "f8d10753-0396-4cb7-8f8a-917413e08a07",
            "employeeName": "sam Doe",
            "phoneNumber": "987-345-6380",
            "email": "sam.Doe@example.com",
            "role": "Senior-Manager",
            "reportsTo": "null",
            "profileImage": "https://example.com/jane-profile.jpg"
        },
        {
            "id": "27920d73-291c-40b4-9fc0-9ae18c99022d",
            "employeeName": "Jane Smith",
            "phoneNumber": "987-654-3210",
            "email": "jane.smith@example.com",
            "role": "developer",
            "reportsTo": "7cf16192-fab9-4dc3-aaf1-cc361daa7a8e",
            "profileImage": "https://example.com/jane-profile.jpg"
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 10,
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 6,
    "size": 10,
    "number": 0,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "first": true,
    "numberOfElements": 6,
    "empty": false
}
