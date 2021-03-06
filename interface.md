nekoStroy前后端接口文档
=================


#### 1.获取手机验证码
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

#### 2.提交预约信息（不需注册,未注册自动注册）
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

#### 3.同人专区-类型枚举

url:/front/doujin/getTypeEnum

method:post

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

#### 4.同人专区-获得某类型的内容

url:/front/doujin/getContentList

method:post

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

#### 5.新闻资讯-获取分类枚举

url:/front/news/getNewsTypeEnum

method:post

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

#### 6.新闻资讯-获取内容列表(update 17-09-26 添加page)
url:/front/news/getContentList

method:post

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
    ],
    "page":{
            "pageNo":1,
            "pageSize":12,
            "total":5
    }
  },
  "status":1
}
```

#### 7.新闻资讯-获取某资讯详情
url:/front/news/getNewsDetail/{newsId}

method:post

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

#### 8.活动专区-类型枚举

url:/front/activity/getTypeEnum

method:post

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

#### 9.活动专区-获得某类型的内容

url:/front/activity/getContentList

method:post

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

#### 10.活动专区-获取某活动详情(update 17-09-26 此处图片点开应为文章 不需要imgUrl)
url:/front/activity/getActivityDetail/{activityId}

method:post

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

#### 11.首页-故事梗概及玩法说明视频地址
url:/front/mainPage/getVideoPage

method:post

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
    "videoUrl":"https://xxxx.xxxx.xxx/xxxx"
  },
  "status":1
}
```

#### 12.首页-获取footer内容 (update 17-09-27 增加weiboOfficial.link 因为微博需要可以点击)
url:/front/mainPage/getFooterContent

method:post

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
      "QRCodeUrl":"xxxxxxxxxx",
      "link":"http://xxxxxxx"
    },
    "tiebaUrl":"xxxxxxx"
  }
}
```

#### 13.首页-下载地址与二维码  (update 17-09-27 更新所有字段名称)


url: /front/mainPage/getDownLoads

request:``{}``

response:
```json
{
  "QRCodeUrl":"xxxxx",
  "androidDownloadUrl":"xxxx",
  "iosDownloadUrl":"xxxxxx",
  "pcDownloadUrl":"xxxxxx"
}
```

#### 14.游戏攻略-获取分类枚举

url:/front/strategy/getStrategyTypeEnum

method:post

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

#### 15.游戏攻略-获取攻略内容 (update 17-09-27 补全返回值中page信息)
url:/front/strategy/getContentList

method:post

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
    ],
    "page":{
        "pageNo":1,
        "pageSize":10,
        "total":3
    }
  },
  "status":1
}
```

#### 16.游戏攻略-获取攻略详细内容
url:/front/strategy/getStrategyDetail/{newsId}

method:post

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

#### 17.首页轮播位 种类枚举

url:/front/mainPage/enum/getTypeEnum

method:post

request:``{}``

response:
```json
{
  "data":{
    "typeList":[
      {
        "typeCode":4,
        "typeName":"最新",
        "typeLink":"/getArticleDetail/"
      },{},{},{}
    ]
  }

}
```

#### 18.获取首页框某分类列表（update 改变返回参数格式）
url:/front/mainPage/getTypeList/{typeCode}

method:post

request:``{}``

response:
```json
{
  "data":[
   {
      "id":3,
      "title":"这是标题",
      "subContent":"这是被剪剩下的一部分内容xxxx",
      "dateTime":"2017-07-19 10:38:04" //格式 2017-07-26 12:38:04
  },{},{},{}
  ]

}
```
#### 19.获取首页轮播图 (update 17-10-19 轮播图可点击)
url: /front/mainPage/getImgs

method:post

request:``{}``

response:
```json
{
    "data":[
      {
        "imgUrl":"xxxxxxxxxx",
        "href":"xxxxxxxxxx"
      },{},{},{}
    ],
    "status":1
}
```


#### 20.获取预约人数
url: /front/mainPage/getOrderedAmount

method:post

request:``{}``

response:
```json
{
  "data":{
    "amount":100
  },
  "status":1
}
```
