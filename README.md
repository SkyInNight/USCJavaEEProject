# USCJavaEEProject
对底层java web开发基础机制的学习开发运用（版本比较旧，如果开发项目参考价值不大，主要用作学习）
> 使用环境：Maven3.5以上  
> jdk1.6~8  
> web开发版本为3.0以上，可以没有web.xml文件  
> 原先为Idea项目，为可以全IDE开发此项目，故改成Maven项目  
## Introduction
- 此项目为上课老师布置的一些小组合作学习时的作业
- 项目目录结构
  - src
    - main
      - java ： 存放所有java源代码
        - cn.org.cerambycidae.Servlet : 用来存放Servlet的java文件
      - webapp ： 对应平时开发的webapp,`里面没有预存放web.xml，如果需要需另外编写`
    - test
## 运行说明
- 项目克隆到本地导入到IDE中即可使用maven运行
  - 在maven执行选项中输入tomcat7:run即可
  - 也可用maven命令行执行：输入mvn tomcat7:run即可
