# 开发方案
restFul 前后端分离
## 后端 
- SSM  java&groovy 
- 使用关系数据库（开发使用sqlite,日期使用时间戳 兼容其他数据库)
- 数据库只存关键字段，其他属性存在json字段里,强依赖配置,强依赖json解析
- 每个表都有一个json字段，存储详细信息，从数据库里取时解析为detailMap
- 表结构(工有字段：id,uuid,creatTm,updateTm,del)
    - 组织表（dept)
        - name
        - superId（上线部门id)
        - status(open,close)
        - json
    - 员工表（employee)
        - name
        - level
        - status(正式，离职，请假，试用)
        - deptId(归属部门)
        - json
    - 资源表(resource)
    - 客源表(customer)
    - 联系方式表(contact)
    - 跟进表(follow)
    - 展示表 (二期，主要用来记录展示方式，如图片，视频地址)
    - 成交表（二期）
    
    
   
## 前端
- 未知
- 尽量少的刷新页面操作
- 加载资源尽量少


