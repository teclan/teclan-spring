#### 项目配置

pom.xml
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>teclan.spring</groupId>  <!-- 自定义 -->
	<artifactId>teclan-spring</artifactId> <!-- 自定义 -->
	<version>0.0.1-SNAPSHOT</version> <!-- 自定义 -->
	<packaging>jar</packaging> <!-- 自定义 -->
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.4.0.RELEASE</version>
	</parent>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>com.jayway.jsonpath</groupId>
			<artifactId>json-path</artifactId>
			<scope>test</scope>
		</dependency>
   </dependencies>
   
   <properties>
		<java.version>1.8</java.version>
	</properties>
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
	<repositories>
		<repository>
			<id>spring-releases</id>
			<url>https://repo.spring.io/libs-release</url>
		</repository>
	</repositories>
	<pluginRepositories>
		<pluginRepository>
			<id>spring-releases</id>
			<url>https://repo.spring.io/libs-release</url>
		</pluginRepository>
	</pluginRepositories>
</project>
```