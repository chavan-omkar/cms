curl requests
1) Register User

curl --location --request POST 'localhost:8798/cms/register' \
--header 'Content-Type: application/json' \
--data-raw '{
"userName": "Omkar1",
"password":"Omkar1",
"mobileNo":1234567890
}'


2) get Day wise Menu

   curl --location --request GET 'localhost:8798/cms/getMenu/monday'