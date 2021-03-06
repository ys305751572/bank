define({ "api": [
  {
    "type": "post",
    "url": "/api/common/bind",
    "title": "4、绑定第三方账号",
    "version": "0.0.1",
    "name": "common_bind",
    "group": "common",
    "description": "<p>绑定第三方账号</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "LONG",
            "optional": false,
            "field": "userId",
            "description": "<p>用户ID</p>"
          },
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "openId",
            "description": "<p>第三方ID</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/sixmac/controller/api/CommonController.java",
    "groupTitle": "common",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/dayshow/api/common/bind"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/common/login",
    "title": "2、登录",
    "version": "0.0.1",
    "name": "common_login",
    "group": "common",
    "description": "<p>登录</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "mobile",
            "description": "<p>手机</p>"
          },
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "password",
            "description": "<p>密码</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "LONG",
            "optional": false,
            "field": "id",
            "description": "<p>用户名</p>"
          },
          {
            "group": "Success 200",
            "type": "STRING",
            "optional": false,
            "field": "mobile",
            "description": "<p>手机号(登录账号)</p>"
          },
          {
            "group": "Success 200",
            "type": "STRING",
            "optional": false,
            "field": "nickname",
            "description": "<p>昵称</p>"
          },
          {
            "group": "Success 200",
            "type": "STRING",
            "optional": false,
            "field": "avater",
            "description": "<p>头像</p>"
          },
          {
            "group": "Success 200",
            "type": "INTEGER",
            "optional": false,
            "field": "gender",
            "description": "<p>性别:1.男 2.女</p>"
          },
          {
            "group": "Success 200",
            "type": "DOUBLE",
            "optional": false,
            "field": "weight",
            "description": "<p>体重</p>"
          },
          {
            "group": "Success 200",
            "type": "DOUBLE",
            "optional": false,
            "field": "height",
            "description": "<p>身高</p>"
          },
          {
            "group": "Success 200",
            "type": "INTEGER",
            "optional": false,
            "field": "year",
            "description": "<p>出身年份</p>"
          },
          {
            "group": "Success 200",
            "type": "INTEGER",
            "optional": false,
            "field": "skin",
            "description": "<p>肤质:0.敏感性,1.中性,2.油性,3.干性,4.混合性</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n        {\"status\":0,\n         \"msg\":\"\",\n         \"data\":{\t\n         \t\"user\": {\n         \t\t\"id\": 1,\n         \t\t\"mobile\": 13476101111,\n         \t\t\"nickname\" : 张三,\n                \"avater\" : http://image,\n                \"gender\" : 1,\n                \"weight\" : 70, \n                \"height\" : 175,\n                \"year\"   : 1989,\n                \"skin\"   : 0\n         \t}\n        }",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/sixmac/controller/api/CommonController.java",
    "groupTitle": "common",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/dayshow/api/common/login"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/common/logout",
    "title": "3、登出",
    "version": "0.0.1",
    "name": "common_logout",
    "group": "common",
    "description": "<p>登出</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "id",
            "description": "<p>用户ID</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/sixmac/controller/api/CommonController.java",
    "groupTitle": "common",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/dayshow/api/common/logout"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/common/register",
    "title": "3、注册",
    "version": "0.0.1",
    "name": "common_register",
    "group": "common",
    "description": "<p>注册</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "code",
            "description": "<p>验证码</p>"
          },
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "mobile",
            "description": "<p>用户名</p>"
          },
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "password",
            "description": "<p>密码</p>"
          },
          {
            "group": "Parameter",
            "type": "INTEGER",
            "optional": false,
            "field": "gender",
            "description": "<p>性别 1.男 2.女</p>"
          },
          {
            "group": "Parameter",
            "type": "DOUBLE",
            "optional": false,
            "field": "weight",
            "description": "<p>体重</p>"
          },
          {
            "group": "Parameter",
            "type": "DOUBLE",
            "optional": false,
            "field": "height",
            "description": "<p>身高</p>"
          },
          {
            "group": "Parameter",
            "type": "INTEGER",
            "optional": false,
            "field": "year",
            "description": "<p>出身年份</p>"
          },
          {
            "group": "Parameter",
            "type": "INTEGER",
            "optional": false,
            "field": "skin",
            "description": "<p>肤质:0.敏感性,1.中性,2.油性,3.干性,4.混合性</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "LONG",
            "optional": false,
            "field": "id",
            "description": "<p>用户名</p>"
          },
          {
            "group": "Success 200",
            "type": "STRING",
            "optional": false,
            "field": "mobile",
            "description": "<p>手机号(登录账号)</p>"
          },
          {
            "group": "Success 200",
            "type": "STRING",
            "optional": false,
            "field": "nickname",
            "description": "<p>昵称</p>"
          },
          {
            "group": "Success 200",
            "type": "STRING",
            "optional": false,
            "field": "avater",
            "description": "<p>头像</p>"
          },
          {
            "group": "Success 200",
            "type": "INTEGER",
            "optional": false,
            "field": "gender",
            "description": "<p>性别:1.男 2.女</p>"
          },
          {
            "group": "Success 200",
            "type": "DOUBLE",
            "optional": false,
            "field": "weight",
            "description": "<p>体重</p>"
          },
          {
            "group": "Success 200",
            "type": "DOUBLE",
            "optional": false,
            "field": "height",
            "description": "<p>身高</p>"
          },
          {
            "group": "Success 200",
            "type": "INTEGER",
            "optional": false,
            "field": "year",
            "description": "<p>出身年份</p>"
          },
          {
            "group": "Success 200",
            "type": "INTEGER",
            "optional": false,
            "field": "skin",
            "description": "<p>肤质:0.敏感性,1.中性,2.油性,3.干性,4.混合性</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n        {\"status\":0,\n         \"msg\":\"\",\n         \"data\":{\t\n         \t\"user\": {\n         \t\t\"id\": 1,\n         \t\t\"mobile\": 13476101111,\n         \t\t\"nickname\" : 张三,\n                \"avater\" : http://image,\n                \"gender\" : 1,\n                \"weight\" : 70, \n                \"height\" : 175,\n                \"year\"   : 1989,\n                \"skin\"   : 0\n         \t}\n        }",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/sixmac/controller/api/CommonController.java",
    "groupTitle": "common",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/dayshow/api/common/register"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/common/sendCode",
    "title": "1、发送验证码",
    "version": "0.0.1",
    "name": "common_sendCode",
    "group": "common",
    "description": "<p>发送验证码</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "mobile",
            "description": "<p>手机</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/sixmac/controller/api/CommonController.java",
    "groupTitle": "common",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/dayshow/api/common/sendCode"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/help/helper",
    "title": "1、帮助",
    "version": "0.0.1",
    "name": "help_helper",
    "group": "helper",
    "description": "<p>帮助</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "INTEGER",
            "optional": false,
            "field": "type",
            "description": "<p>类型:0.注册协议 1.关于软件 2.帮助 3.测试帮助</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "STRING",
            "optional": false,
            "field": "content",
            "description": "<p>内容</p>"
          },
          {
            "group": "Success 200",
            "type": "INTEGER",
            "optional": false,
            "field": "type",
            "description": "<p>类型:0.注册协议 1.关于软件 2.帮助 3.测试帮助</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n        {\"status\":0,\n         \"msg\":\"\",\n         \"data\":{\t\n     \t\t\"type\": 0,\n     \t\t\"content\": 注册协议\n         }\n        }",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/sixmac/controller/api/HelperController.java",
    "groupTitle": "helper",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/dayshow/api/help/helper"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/measure/advice",
    "title": "5、测量-建议",
    "version": "0.0.1",
    "name": "measure_advice",
    "group": "measure",
    "description": "<p>测量-建议</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "LONG",
            "optional": false,
            "field": "userId",
            "description": "<p>用户ID</p>"
          },
          {
            "group": "Parameter",
            "type": "INTEGER",
            "optional": false,
            "field": "part",
            "description": "<p>测量部位:0.颈部,1.手部,2:脸部</p>"
          },
          {
            "group": "Parameter",
            "type": "LONG",
            "optional": false,
            "field": "timeDown",
            "description": "<p>查询时间,下限</p>"
          },
          {
            "group": "Parameter",
            "type": "LONG",
            "optional": false,
            "field": "timeUp",
            "description": "<p>查询时间,上限</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "INTEGER",
            "optional": false,
            "field": "part",
            "description": "<p>测量部位:0.颈部,1.手部,2:脸部</p>"
          },
          {
            "group": "Success 200",
            "type": "DOUBLE",
            "optional": false,
            "field": "measureMoistureAve",
            "description": "<p>脸部肌肤润度 (平均值)</p>"
          },
          {
            "group": "Success 200",
            "type": "DOUBLE",
            "optional": false,
            "field": "measureGreaseAve",
            "description": "<p>脸部老化角质(平均值)</p>"
          },
          {
            "group": "Success 200",
            "type": "DOUBLE",
            "optional": false,
            "field": "measureMoistureCompare",
            "description": "<p>水分值比较</p>"
          },
          {
            "group": "Success 200",
            "type": "DOUBLE",
            "optional": false,
            "field": "measureGreaseCompare",
            "description": "<p>油脂比较</p>"
          },
          {
            "group": "Success 200",
            "type": "STRING",
            "optional": false,
            "field": "result",
            "description": "<p>肤质状况</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n        {\"status\":0,\n         \"msg\":\"\",\n         \"data\":{\t\n     \t\t\"part\": 0,\n     \t\t\"measureMoistureAve\": 24%,\n     \t\t\"measureGreaseAve\" : 24%,\n            \"measureMoistureCompare\":+2.9%,\n            \"measureGreaseCompare\": -2.9%,\n            \"result\" : \"肤质状况\"\n            ]\n        }",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/sixmac/controller/api/MeasureController.java",
    "groupTitle": "measure",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/dayshow/api/measure/advice"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/measure/delete",
    "title": "3、测量-删除",
    "version": "0.0.1",
    "name": "measure_delete",
    "group": "measure",
    "description": "<p>测量-删除</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "LONG",
            "optional": false,
            "field": "userId",
            "description": "<p>用户ID</p>"
          },
          {
            "group": "Parameter",
            "type": "LONG",
            "optional": false,
            "field": "id",
            "description": "<p>记录ID</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/sixmac/controller/api/MeasureController.java",
    "groupTitle": "measure",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/dayshow/api/measure/delete"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/measure/detail",
    "title": "4、测量-详情",
    "version": "0.0.1",
    "name": "measure_detail",
    "group": "measure",
    "description": "<p>测量-列表</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "LONG",
            "optional": false,
            "field": "userId",
            "description": "<p>用户</p>"
          },
          {
            "group": "Parameter",
            "type": "INTEGER",
            "optional": false,
            "field": "part",
            "description": "<p>测量部位:0.颈部,1.手部,2:脸部</p>"
          },
          {
            "group": "Parameter",
            "type": "LONG",
            "optional": false,
            "field": "timeDown",
            "description": "<p>查询时间,下限</p>"
          },
          {
            "group": "Parameter",
            "type": "LONG",
            "optional": false,
            "field": "timeUp",
            "description": "<p>查询时间,上限</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "INTEGER",
            "optional": false,
            "field": "part",
            "description": "<p>测量部位:0.颈部,1.手部,2:脸部</p>"
          },
          {
            "group": "Success 200",
            "type": "DOUBLE",
            "optional": false,
            "field": "result1",
            "description": "<p>脸部肌肤润度</p>"
          },
          {
            "group": "Success 200",
            "type": "DOUBLE",
            "optional": false,
            "field": "result2",
            "description": "<p>脸部老化角质</p>"
          },
          {
            "group": "Success 200",
            "type": "DOUBLE",
            "optional": false,
            "field": "measureMoistureAve",
            "description": "<p>脸部肌肤润度 (平均值)</p>"
          },
          {
            "group": "Success 200",
            "type": "DOUBLE",
            "optional": false,
            "field": "measureGreaseAve",
            "description": "<p>脸部老化角质(平均值)</p>"
          },
          {
            "group": "Success 200",
            "type": "DOUBLE",
            "optional": false,
            "field": "list.measureMoisture",
            "description": "<p>水分值</p>"
          },
          {
            "group": "Success 200",
            "type": "DOUBLE",
            "optional": false,
            "field": "list.measureGrease",
            "description": "<p>油脂</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n        {\"status\":0,\n         \"msg\":\"\",\n         \"data\":{\t\n     \t\t\"part\": 0,\n     \t\t\"measureMoistureAve\": 24%,\n     \t\t\"measureGreaseAve\" : 24%,\n            \"list\":[\n               {\n               \t\"measureMoisture\":24%,\n                \"measureGrease\": 24%\n               }\n            ]\n        }",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/sixmac/controller/api/MeasureController.java",
    "groupTitle": "measure",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/dayshow/api/measure/detail"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/measure/list",
    "title": "2、测量-列表",
    "version": "0.0.1",
    "name": "measure_list",
    "group": "measure",
    "description": "<p>测量-列表</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "LONG",
            "optional": false,
            "field": "userId",
            "description": "<p>用户</p>"
          },
          {
            "group": "Parameter",
            "type": "INTEGER",
            "optional": false,
            "field": "part",
            "description": "<p>测量部位:0.颈部,1.手部,2:脸部</p>"
          },
          {
            "group": "Parameter",
            "type": "LONG",
            "optional": false,
            "field": "timeDown",
            "description": "<p>查询时间,下限</p>"
          },
          {
            "group": "Parameter",
            "type": "LONG",
            "optional": false,
            "field": "timeUp",
            "description": "<p>查询时间,上限</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "INTEGER",
            "optional": false,
            "field": "part",
            "description": "<p>测量部位:0.颈部,1.手部,2:脸部</p>"
          },
          {
            "group": "Success 200",
            "type": "DOUBLE",
            "optional": false,
            "field": "result",
            "description": "<p>肤质状况</p>"
          },
          {
            "group": "Success 200",
            "type": "DOUBLE",
            "optional": false,
            "field": "measureMoistureAve",
            "description": "<p>水分 (平均值)</p>"
          },
          {
            "group": "Success 200",
            "type": "DOUBLE",
            "optional": false,
            "field": "result2",
            "description": "<p>比较</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n        {\"status\":0,\n         \"msg\":\"\",\n         \"data\":{\t\n     \t\t\"list\": {\n     \t\t\t\"part\": 0\n         \t\t\"result\": 湿润,\n         \t\t\"measureMoistureAve\" : 24%,\n         \t\t\"result2\" : 比最近一天+1.2%\n     \t\t}\n        }",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/sixmac/controller/api/MeasureController.java",
    "groupTitle": "measure",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/dayshow/api/measure/list"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/measure/save",
    "title": "1、测量-新增记录",
    "version": "0.0.1",
    "name": "measure_save",
    "group": "measure",
    "description": "<p>测量-新增记录</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "LONG",
            "optional": false,
            "field": "userId",
            "description": "<p>用户ID</p>"
          },
          {
            "group": "Parameter",
            "type": "INTEGER",
            "optional": false,
            "field": "part",
            "description": "<p>测量部位:0.颈部,1.手部,2:脸部</p>"
          },
          {
            "group": "Parameter",
            "type": "DOUBLE",
            "optional": false,
            "field": "measureMoisture",
            "description": "<p>水分值</p>"
          },
          {
            "group": "Parameter",
            "type": "DOUBLE",
            "optional": false,
            "field": "measureGrease",
            "description": "<p>油脂</p>"
          },
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "address",
            "description": "<p>测量城市</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/sixmac/controller/api/MeasureController.java",
    "groupTitle": "measure",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/dayshow/api/measure/save"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/report/save",
    "title": "1、反馈-新增记录",
    "version": "0.0.1",
    "name": "report_save",
    "group": "report",
    "description": "<p>测量-新增记录</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "LONG",
            "optional": false,
            "field": "userId",
            "description": "<p>用户ID</p>"
          },
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "contact",
            "description": "<p>联系方式</p>"
          },
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "content",
            "description": "<p>反馈内容</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/sixmac/controller/api/ReportController.java",
    "groupTitle": "report",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/dayshow/api/report/save"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/user/modifyPassword",
    "title": "3、修改密码",
    "version": "0.0.1",
    "name": "user_modifyPassword",
    "group": "user",
    "description": "<p>修改密码</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "userId",
            "description": "<p>用户ID</p>"
          },
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "oldPassword",
            "description": "<p>原密码(空:找回密码,不空:修改密码)</p>"
          },
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "newPassword",
            "description": "<p>新密码</p>"
          },
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "code",
            "description": "<p>验证码</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/sixmac/controller/api/UserController.java",
    "groupTitle": "user",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/dayshow/api/user/modifyPassword"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/user/modifyUserInfo",
    "title": "2、修改个人信息",
    "version": "0.0.1",
    "name": "user_modifyUserInfo",
    "group": "user",
    "description": "<p>修改个人信息</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "LONG",
            "optional": false,
            "field": "userId",
            "description": "<p>用户ID</p>"
          },
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "nickname",
            "description": "<p>昵称</p>"
          },
          {
            "group": "Parameter",
            "type": "DOUBLE",
            "optional": false,
            "field": "weight",
            "description": "<p>体重</p>"
          },
          {
            "group": "Parameter",
            "type": "DOUBLE",
            "optional": false,
            "field": "height",
            "description": "<p>身高</p>"
          },
          {
            "group": "Parameter",
            "type": "INTEGER",
            "optional": false,
            "field": "year",
            "description": "<p>出身年份</p>"
          },
          {
            "group": "Parameter",
            "type": "INTEGER",
            "optional": false,
            "field": "skin",
            "description": "<p>肤质:0.敏感性,1.中性,2.油性,3.干性,4.混合性</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/sixmac/controller/api/UserController.java",
    "groupTitle": "user",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/dayshow/api/user/modifyUserInfo"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/user/uploadAvater",
    "title": "1、上传头像",
    "version": "0.0.1",
    "name": "user_uploadAvater",
    "group": "user",
    "description": "<p>上传头像</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "LONG",
            "optional": false,
            "field": "userId",
            "description": "<p>用户ID</p>"
          },
          {
            "group": "Parameter",
            "type": "MultipartFile",
            "optional": false,
            "field": "file",
            "description": "<p>头像</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/sixmac/controller/api/UserController.java",
    "groupTitle": "user",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/dayshow/api/user/uploadAvater"
      }
    ]
  }
] });
