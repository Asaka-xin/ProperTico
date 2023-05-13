<p align="center">
    <a target="blank">
    <img src="./assets/logo_waifu4x.png" width="300" height="300">
    </a>
    <h1 align="center">数据字典</h1>
</p>
<p align="center">
	<img src="./assets/ER.ProperTico.png">
    <h2 align="center">实体关系映射图</h2>
</p>


## 检索

[用户表](##用户表)
[报修工单表](##报修工单表)
[小区表](##小区表)
[楼栋表](##楼栋表)
[停车位表](##停车位表)
[投诉表](##投诉表)
[缴费表](##缴费表)
[访客表](##访客表)
[房产表](##房产表)


## 用户表

user

|    字段     |   数据类型   |            约束             |   注释   |     备注     |
| :---------: | :----------: | :-------------------------: | :------: | :----------: |
|     id      |    BIGINT    | PRIMARY KEY, AUTO_INCREMENT |    ID    |     主键     |
|    name     | VARCHAR(255) |          NOT NULL           | 用户名称 |      /       |
|    email    | VARCHAR(255) |          NOT NULL           | 用户邮箱 |      /       |
|  password   | VARCHAR(255) |          NOT NULL           | 用户密码 |      /       |
|    phone    | VARCHAR(255) |          NOT NULL           | 用户电话 |      /       |
| create_time |     DATE     |          NOT NULL           | 注册时间 | 自动当前时间 |

## 报修工单表

maintenancerequests

|     字段      |   数据类型   |            约束             |   注释   |     备注     |
| :-----------: | :----------: | :-------------------------: | :------: | :----------: |
|      id       |    BIGINT    | PRIMARY KEY, AUTO_INCREMENT | 工单编号 |      /       |
|   username    | VARCHAR(255) |          NOT NULL           |  用户名  |     name     |
|     phone     | VARCHAR(255) |          NOT NULL           | 联系方式 |    phone     |
|  description  | VARCHAR(255) |          NOT NULL           | 报修信息 |      /       |
| requests_time |     DATE     |          NOT NULL           | 提交时间 | 自动当前时间 |
|    status     | VARCHAR(255) |          NOT NULL           | 报修状态 |  已/待处理   |

## 小区表

estates

|   字段    |     数据类型     |             约束              |  注释  | 备注 |
|:-------:|:------------:|:---------------------------:|:----:|:--:|
|   id    |    BIGINT    | PRIMARY KEY, AUTO_INCREMENT |  ID  | /  |
|  name   | VARCHAR(255) |          NOT NULL           | 小区名称 | /  |
| address | VARCHAR(255) |          NOT NULL           | 小区地址 | /  |
| esphone | VARCHAR(255) |          NOT NULL           | 联系方式 | /  |

## 楼栋表

buildings

|   字段    |     数据类型     |             约束              |  注释  |   备注   |
|:-------:|:------------:|:---------------------------:|:----:|:------:|
|   id    |    BIGINT    | PRIMARY KEY, AUTO_INCREMENT | 楼编号  | 序列号/编号 |
| estates | VARCHAR(255) |          NOT NULL           | 所属小区 |   /    |
|  Floor  |     INT      |          NOT NULL           | 楼层数  |  默认20  |

## 停车位表

parkingspaces

|     字段      |     数据类型     |             约束              |  注释  |  备注  |
|:-----------:|:------------:|:---------------------------:|:----:|:----:|
|     id      |    BIGINT    | PRIMARY KEY, AUTO_INCREMENT | 车位编号 |  /   |
| parkingtype | VARCHAR(255) |          NOT NULL           | 车位类型 | A/B  |
|  building   | VARCHAR(255) |          NOT NULL           | 所属房产 |  /   |
|    owner    |    BIGINT    |          NOT NULL           | 所属业主 | 业主id |

## 投诉表

complaints

|     字段      |     数据类型     |             约束              |  注释   |  备注   |
|:-----------:|:------------:|:---------------------------:|:-----:|:-----:|
|     id      |    BIGINT    | PRIMARY KEY, AUTO_INCREMENT | 投诉单编号 |   /   |
| create_time |     DATE     |          NOT NULL           | 创建时间  | 当前时间  |
| description | VARCHAR(255) |          NOT NULL           | 投诉描述  |   /   |
|   status    | VARCHAR(255) |          NOT NULL           |  状态   | 已/待处理 |

## 缴费表

payments

|     字段     |     数据类型     |             约束              |  注释  | 备注 |
|:----------:|:------------:|:---------------------------:|:----:|:--:|
|     id     |    BIGINT    | PRIMARY KEY, AUTO_INCREMENT | 缴费编号 | /  |
|    user    | VARCHAR(255) |          NOT NULL           | 缴费户号 | /  |
|  pay_time  |     DATE     |          NOT NULL           | 缴费时间 | /  |
| pay_amount |     INT      |          NOT NULL           | 缴费金额 | /  |

## 访客表

visitors

|    字段     |     数据类型     |             约束              |  注释  | 备注 |
|:---------:|:------------:|:---------------------------:|:----:|:--:|
|    id     |    BIGINT    | PRIMARY KEY, AUTO_INCREMENT | 序列号  | /  |
|   name    | VARCHAR(255) |          NOT NULL           | 访客姓名 | /  |
|  estates  | VARCHAR(255) |          NOT NULL           | 访问小区 | /  |
| visitTime |     Date     |          NOT NULL           | 访问时间 | /  |

## 房产表

properties

|   字段    |     数据类型     |             约束              |  注释  | 备注 |
|:-------:|:------------:|:---------------------------:|:----:|:--:|
|   id    |    BIGINT    | PRIMARY KEY, AUTO_INCREMENT | 房产号  | /  |
|  name   | VARCHAR(255) |          NOT NULL           | 房产名  | /  |
|  user   | VARCHAR(255) |          NOT NULL           | 持有人  | /  |
| estates | VARCHAR(255) |          NOT NULL           | 所在小区 | /  |
|  area   |     INT      |          NOT NULL           | 房产面积 | /  |