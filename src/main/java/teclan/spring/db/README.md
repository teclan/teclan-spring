### Spring 数据库简单操作（mysql为例）

#### 1、添加依赖
Sping Jdbc 依赖
```
    <dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-jdbc</artifactId>
		<version>4.3.3.RELEASE</version><!--$NO-MVN-MAN-VER$ -->
	</dependency>
```
数据库依赖
```
	<dependency>
		<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
		<version>6.0.4</version><!--$NO-MVN-MAN-VER$-->
	</dependency>
```

#### 2、数据源配置
在项目环境路径下添加配置文件，文件名任意，在程序中指定正确的文件即可，配置文件内容如下:
```
<?xml version="1.0" encoding="UTF-8"?> 
 
<beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:aop="http://www.springframework.org/schema/aop"
  xmlns:tx="http://www.springframework.org/schema/tx"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xmlns:context="http://www.springframework.org/schema/context" 
  xmlns:p="http://www.springframework.org/schema/p"
 
  xsi:schemaLocation="
       http://www.springframework.org/schema/beans    
       http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
       http://www.springframework.org/schema/tx      
       http://www.springframework.org/schema/tx/spring-tx-3.0.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context-3.0.xsd
       http://www.springframework.org/schema/aop
       http://www.springframework.org/schema/aop/spring-aop-3.0.xsd">
 <!-- 使用XML Schema的p名称空间配置 -->
  <bean name="dataSource"  class="org.springframework.jdbc.datasource.DriverManagerDataSource" 
  p:driverClassName="com.mysql.jdbc.Driver" 
  p:url="jdbc:mysql://localhost:3306/testdb"
  p:username="root"
  p:password="123456"  /> 
 
</beans>
```

#### 3、准备数据库
##### 3.1、数据库安装 略
#### 3.2、数据准备
```
create database testdb;

use testdb;

create table teclan 
(
id bigint not null primary key,
content varchar(100)
);

insert into teclan values (1,'teclan1');
insert into teclan values (2,'teclan2');
```
