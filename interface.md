nekoStroy前后端接口文档
=================

####1.获取手机验证码
url: /front/account/getCheckCode

method: post

request:
```json
{
    "telephone":"17621181235"
}
```
response:
```json
{
    "data":{
        "msg":"成功"
    },
    "status":1
}
```

####2.提交预约信息（不需注册,未注册自动注册）
url:/front/account/login

method:post

request:
```json
{
    "telephone":"17621181235",
    "phoneType":"Android",
    "verifyCode":"123456"
}
```

response:
```json
{
    "data":{
        "resultCode":1,//0预约失败 1预约成功 2已预约
        "resultMsg":"预约成功"
    },
    "status":1
}
```

####3.同人专区-类型枚举

url:/front/doujin/getTypeEnum

method:get

request:
```json
{}
```

response:
```json
{
    "data":{
        "typeList":[
        {
          "typeCode":1,
          "typeName":"精选"
        },{},{}
        ]
    }
}
```

####4.同人专区-获得某类型的内容

url:/front/doujin/getContentList

method:get

request:
```json
{
    "typeCode":3,
    "pageNo":1,
    "pageSize":12
}
```

response:
```json
{
  "data":{
      "contentList":[
        {
          "imgUrl":"http://xxxxx.xxxxx.xxxx",
          //前端缩略还是后端缩略 此处暂定前端 上述为原图url
          "isVideo":true,
          "videoUrl":"http://www.bilibili.com/xxxxxx"
        },{},{}
      ],
      "page":{
        "pageNo":1,
        "pageSize":12,
        "total":5
      }
  }
  ,
  "status":1
}
```

####5.新闻资讯-获取分类枚举

url:/front/news/getNewsTypeEnum

method:get

request:
``{}``

response:
```json
{
  "data":{
          "typeList":[
          {
            "typeCode":1,
            "typeName":"最新消息"
          },{},{}
          ]
      },
  "status":1
}
```

####6.新闻资讯-获取内容列表
url:/front/news/getContentList

method:get

request:
```json
{
    "typeCode":2,
    "pageNo":1,
    "pageSize":12
}
```

response:
```json
{
  "data":{
    "contentList":[
      {
        "id":3,
        "title":"这是标题",
        "subContent":"这是被剪剩下的一部分内容xxxx",
        "dateTime":"2017-07-19 10:38:04" //格式 2017-07-26 12:38:04
      },{},{}
    ]
  },
  "status":1
}
```

####7.新闻资讯-获取某资讯详情
url:/front/news/getNewsDetail/{newsId}

method:get

request:
``{}``

response:
```json
{
  "data":{
    "title":"这是标题",
    "writer":"这是作者",
    "dataTime":"2017-07-19 10:38:04",
    "content":"非常长的内容 包括\n\r换行符以及各种空格  甚至插入图片 建议使用TextArea"
  },
  "status":1
}
```

####8.活动专区-类型枚举

url:/front/activity/getTypeEnum

method:get

request:
```json
{}
```

response:
```json
{
    "data":{
        "typeList":[
        {
          "typeCode":1,
          "typeName":"线下活动公告"
        },{},{}
        ]
    }
}
```

####9.同人专区-获得某类型的内容

url:/front/activity/getContentList

method:get

request:
```json
{
    "typeCode":3,
    "pageNo":1,
    "pageSize":12
}
```

response:
```json
{
  "data":{
      "contentList":[
        {
          "imgUrl":"http://xxxxx.xxxxx.xxxx",
          "id":2
        },{},{}
      ],
      "page":{
        "pageNo":1,
        "pageSize":12,
        "total":5
      }
  }
  ,
  "status":1
}
```

####10.活动专区-获取某活动详情
url:/front/activity/getActivityDetail/{activityId}

method:get

request:
``{}``

response:
```json
{
  "data":{
    "title":"这是标题",
    "writer":"这是作者",
    "dataTime":"2017-07-19 10:38:04",
    "content":"非常长的内容 包括\n\r换行符以及各种空格  甚至插入图片 建议使用TextArea"
  },
  "status":1
}
```

####11.首页-故事梗概及玩法说明视频地址
url:/front/mainPage/getVideoPage

method:get

request:
```json
{
  "typeCode":1//此处暂时直接写死 故事梗概传0 玩法说明-经营传1 房间传2 订单传3 宣传传4
}
```

response:
```json
{
  "data":{
    videoUrl:"https://xxxx.xxxx.xxx/xxxx"
  },
  "status":1
}
```

####12.首页-获取footer内容
url:/front/mainPage/getFooterContent

method:get

request:
```json
{}
```

response:
```json
{
  "data":{
    "aboutUs":"http://xxxxxx",
    "userAgreement":"http://xxxxxx",
    "contactUs":"http://xxxxxx",
    "cooperation":"http://xxxxxx",
    "customerService":"010-11111111",
    "qqGroupList":["123456","1234567","12345678"],
    "wechatOfficial":{
      "name":"萌猫物语公众号",
      "QRCodeUrl":"xxxxxxxxxx"
    },
    "weiboOfficial":{
      "name":"萌猫物语微博",
      "QRCodeUrl":"xxxxxxxxxx"
    },
    "tiebaUrl":"xxxxxxx"
  }
}
```

####13.首页-下载地址与二维码

url: /front/mainPage/getDownLoads

request:``{}``

response:
```json
{
  "QRCode":"xxxxx",
  "Android":"xxxx",
  "IOS":"xxxxxx",
  "PC":"xxxxxx"
}
```