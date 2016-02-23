### 接口返回格式

## 单条数据:
> 异常:
```javascript
{ 
 "status":1000,
 "data":{},
 "msg":"错误消息"
}
```
> 正常:
```javascript
{
 "status":0,
 "data":{"id":"1","name":"wb"},
 "msg":""
}
```
## 多条数据:
> 异常:
```javascript
{
 "status":1000,
 "data":{},
 "msg":"错误消息"
}
```
> 正常:
```javascript
{
 "status":0,
 "data":{
   "list":[
     {"id":267,"city":"Wuhan"},
     {"id":266,"city":"Nanjin"}
   ],
   "page":{
     "totalNum":4,
     "totalPage":2,
     "currentPage":1
   }
 }  
}
```

### 错误码
| 解释|错误码 |
| --- | --- | 
|参数不正确|1001|
|服务器异常|1002|
|url不存在|1003|
|手机号已被注册|2001|
|验证码错误|2002|
|用户名密码错误|2003|
|用户不存在|2004|
