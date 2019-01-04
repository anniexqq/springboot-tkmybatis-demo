Springboot + Mybatis(TK mybatis)

1.首页：
浏览器访问：http://localhost:8081

2.数据分页展示：
postman请求：http://localhost:8081/user/all?pageNum=1&pageSize=3

3.用户新增：
postman请求：http://localhost:8081/user/add
入参：
{
	"userName":"mimu",
	"password":"1234",
	"phone":"122345555"
}

4.
在resource/templates/error下添加error.html页面
(error替换成对应的错误码，404、401、500等，还可以用4xx、5xx等)，springBoot会自动找到该页面作为错误页面，适合内嵌Tomcat或者war方式。

