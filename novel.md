# novel
[toc]
## 1	环境变量

### 本地环境
| 参数名 | 字段值 |
| ------ | ------ |
|baseUrl|http://localhost:8080/novel|


## 2	author controller

## 2.1	/author/list   获取作者列表

> GET  /author/list
### 接口说明
> 获取作者列表；需要先登录才能获取
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| page|int32|1|false|分页参数，第几页|
| limit|int32|10|false|分页参数，每页最多有几条数据|
| order|string||false|排序方式，asc或者desc；没有则不排序|
| sidx|string||false|排序字段，根据哪个字段进行排序，没有则不排序|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| page|object||true|分页数据|
| code|string|200|true|响应码|
| msg|string||true|响应信息|


## 2.2	/author/info/{id}

> GET  /author/info/{id}
### 接口说明
> 根据id获取作者详细信息
### 地址参数（Path Variable）
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|id||作者id—— 对应数据表中的 author_id|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|
| author|object||true|作者信息|


## 2.3	/author/save

> POST  /author/save
### 接口说明
> 新增作者，由管理员操作
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| nickname|string||true|作者昵称|
| info|string||true|作者简介|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|


## 2.4	/author/update

> POST  /author/update
### 接口说明
> 更新作者信息
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| nickname|string||false|更新后的作者昵称|
| info|string||false|更新后的作者简介|
| id|int64||true|作者id|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|


## 2.5	/author/delete

> POST  /author/delete
### 接口说明
> 删除作者，管理员操作
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| ids|array||true|作者id列表，可传多个|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|


## 3	book controller

## 3.1	/book/list

> GET  /book/list
### 接口说明
> 分页获取书籍列表
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| page|int32|1|false|分页参数，第几页|
| limit|int32|10|false|分页参数，每页最多显示几条数据|
| order|string||false|排序方式，asc或者desc；没有则不排序|
| sidx|string||false|排序字段，根据哪个字段进行排序，没有则不排序|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|
| page|object||true|分页数据|


## 3.2	/book/search

> GET  /book/search
### 接口说明
> 根据关键字查找书籍
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| page|int32|1|false|分页参数|
| limit|int32|10|false|分页参数，每页最多有几条数据|
| order|string||false|排序方式，asc或者desc；没有则不排序|
| sidx|string||false|排序字段，根据哪个字段进行排序，没有则不排序|
| keyword|string||false|搜索关键字|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|
| page|array||true|分页数据|


## 3.3	/book/list/type

> GET  /book/list/type
### 接口说明
> 根据分页id搜索所有书籍
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| typeId|int64||false|分类id|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|
| books|array||true|对应分类的书籍信息|


## 3.4	/book/list/author

> GET  /book/list/author
### 接口说明
> 根据作者id搜索所有书籍
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| authorId|int64||false|作者id|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|
| books|array||true|对应分类的书籍信息|


## 3.5	/book/info/{id}

> GET  /book/info/{id}
### 接口说明
> 根据id获取书籍详细信息
### 地址参数（Path Variable）
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|id||书籍id—— 对应数据表中的 book_id|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|
| book|object||true|作者信息|


## 3.6	/book/save

> POST  /book/save
### 接口说明
> 新增书籍
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| authorId|int64||true|作者id|
| authorNickname|string||true|作者昵称|
| coverImage|string||true|小说封面图片地址|
| novelTitle|string||true|小说名字|
| description|string||true|简介|
| typeId|int64||true|分类id|
| typeName|string||true|分类名称|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|


## 3.7	/book/update

> POST  /book/save
### 接口说明
> 新增书籍
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| id|int64||true|书籍id|
| authorId|int64||false|更新后的作者id|
| authorNickname|string||false|更新后的作者昵称|
| coverImage|string||false|更新后的小说封面图片地址|
| novelTitle|string||false|更新后的小说名字|
| description|string||false|更新后的简介|
| typeId|int64||false|更新后的分类id|
| typeName|string||false|更新后的分类名称|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|


## 3.8	/book/delete

> POST  /book/delete
### 接口说明
> 根据书籍id删除书籍
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| ids|array[int64]||true|需要删除的书籍id数组|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|


## 4	chapter controller

## 4.1	/chapter/list/{book}

> GET  /chapter/list/{bookId}
### 接口说明
> 根据书籍id查询章节列表
### 地址参数（Path Variable）
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|bookId||书籍id|
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| page|int32|1|false|分页参数，第几页|
| limit|int32|10|false|分页参数，每页最多有几条数据|
| order|string||false|排序方式，asc或者desc；没有则不排序|
| sidx|string||false|排序字段，根据哪个字段进行排序，没有则不排序|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|
| page|object||true|分页数据|


## 4.2	/chapter/info/{id}

> GET  /chapter/info/{id}
### 接口说明
> 根据章节id获取章节信息
### 地址参数（Path Variable）
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|id||章节id|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|
| chapter|object||true|章节信息|


## 4.3	/chapter/save

> POST  /chapter/save
### 接口说明
> 新增章节信息，上传章节文件
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| bookId|int64||true|书籍id|
| title|string||true|章节标题|
| file|file||true|章节文件|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|
| uploadFileDir|string||true|文件地址|


## 4.4	/chapter/update

> POST  /chapter/update
### 接口说明
> 修改章节信息
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| id|int64||true|章节id|
| bookId|int64||true|书籍id|
| title|string||true|章节标题|
| fileLocation|string||true|章节文件位置|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|


## 4.5	/chapter/delete

> POST  /chapter/delete
### 接口说明
> 根据id删除章节信息
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| ids|array[int64]||true|章节id数组，可以批量删除|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|


## 5	bookshelf controller

## 5.1	/bookshelf/list

> GET  /bookshelf/list
### 接口说明
> 根据用户id查询书架列表
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| userId|int64||true|用户id|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|
| list|array[object]||true|对应用户的书架信息|


## 5.2	/bookshelf/info/{id}

> GET  /bookshelf/info/{id}
### 接口说明
> 根据id查询书架信息
### 地址参数（Path Variable）
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|id||书架id|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|
| bookshelf|object||true|对应id的书架信息|


## 5.3	/bookshelf/save

> POST  /bookshelf/save
### 接口说明
> 新增书架信息
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| userId|int64||true|用户id|
| bookId|int64||true|书籍id|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|


## 5.4	/bookshelf/update

> POST  /bookshelf/update
### 接口说明
> 根据id更新书架信息，主要是更新时间
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| id|int64||true|书架id|
| userId|int64||true|更新后的用户id|
| bookId|int64||true|更新后的书籍id|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|


## 5.5	/bookshelf/delete

> POST  /bookshelf/delete
### 接口说明
> 根据id删除书架信息
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| ids|array[int64]||true|书架id数组，可批量删除|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|


## 6	type controller

## 6.1	/type/list

> GET  /type/list
### 接口说明
> 分页查询分类列表
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| page|int32|1|false|分页参数，第几页|
| limit|int32|10|false|分页参数，每页最多有几条数据|
| order|string||false|排序方式，asc或者desc；没有则不排序|
| sidx|string||false|排序字段，根据哪个字段进行排序，没有则不排序|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|
| page|object||true|分页数据|


## 6.2	/type/info/{id}

> GET  /type/info/{id}
### 接口说明
> 根据id查询分类信息
### 地址参数（Path Variable）
| 参数名称 | 默认值 | 描述 |
| ------ | ------ | ------ |
|id||分类id|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|
| type|object||true|对应id的分类数据|


## 6.3	/type/save

> POST  /type/save
### 接口说明
> 新增分类
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| name|string||true|分类名称|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|


## 6.4	/type/update

> POST  /type/update
### 接口说明
> 根据id更新分类
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| id|int64||true|分类id|
| name|string||false|更新后的分类名称|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|


## 6.5	/type/delete

> POST  /type/delete
### 接口说明
> 根据id删除
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| ids|array[int64]||true|分类id数组，可批量删除|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|


## 7	user controller

## 7.1	/user/info/{id}

> GET  /user/info/{id}
### 接口说明
> 根据id查询用户个人信息
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| id|array[int64]||true|用户id|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|
| user|object||true|用户信息|


## 7.2	/user/save

> POST  /user/save
### 接口说明
> 新增用户，用户注册
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| nickname|string||true|用户昵称|
| password|string||true|密码|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string||true|响应信息|


## 8	/login

> POST  /login
### 接口说明
> 登录
### 请求体(Request Body)
| 参数名称 | 数据类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| username|string||true|用户昵称|
| password|string||true|密码|
### 响应体
● 200: OK 响应数据格式：JSON
| 参数名称 | 类型 | 默认值 | 不为空 | 描述 |
| ------ | ------ | ------ | ------ | ------ |
| code|string|200|true|响应码|
| msg|string|登陆成功|true|响应信息|


## 9	/logout

> POST  /logout
### 接口说明
> 登出，退出当前的登录
### 响应体
● 200: OK 响应数据格式：JSON

