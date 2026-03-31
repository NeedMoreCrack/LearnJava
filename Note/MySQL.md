# <center>MySQL</center>

### 練習網站

1. [SQLBolt](https://sqlbolt.com/)
2. [SQL教程](https://www.w3school.com.cn/sql/index.asp)
3. [SQL Tutorial](https://www.w3schools.com/sql/default.asp)
4. [SQL Teaching](https://www.sqlteaching.com/)
5. [SQL語法教學](https://www.1keydata.com/tw/sql/sql.html)
6. [SQLZoo](https://sqlzoo.net/wiki/SELECT_basics/zh)

# 使用mycli工具補全語法 高亮提示
```cli
    # 安裝完畢後 要重開終端 或是 重新套用.bashrc設定檔
    sudo apt install pipx python3-venv -y
    pipx ensurepath
    pipx install mycli

    # 連線指令
    mycli -h 127.0.0.1 -P 3306 -u root
```

# Docker建立MySQL語法
```cli
    docker run --name learn-mysql -p 3306:3306 -v /my/custom:/etc/mysql/conf.d -e TZ=Asia/Taipei -e MYSQL_ROOT_PASSWORD=321321321 -d mysql:8
```

# MySQL練習資料
```MySQL
    CREATE DATABASE `learn_mysql_syntax`;

    USE `learn_mysql_syntax`;

    DROP TABLE IF EXISTS `course`;

    CREATE TABLE `course` (
      `cno` varchar(10) NOT NULL,
      `cname` varchar(20) DEFAULT NULL,
      `tno` varchar(20) NOT NULL,
      PRIMARY KEY (`cno`,`tno`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

    LOCK TABLES `course` WRITE;

    INSERT INTO `course` VALUES ('c001','J2SE','t002'),('c002','Java Web','t002'),('c003','SSH','t001'),('c004','Oracle','t001'),('c005','SQL SERVER 2005','t003'),('c006','C#','t003'),('c007','JavaScript','t002'),('c008','DIV+CSS','t001'),('c009','PHP','t003'),('c010','EJB3.0','t002');

    UNLOCK TABLES;

    DROP TABLE IF EXISTS `sc`;

    CREATE TABLE `sc` (
      `sno` varchar(10) NOT NULL,
      `cno` varchar(10) NOT NULL,
      `score` float(4,2) DEFAULT NULL,
      PRIMARY KEY (`sno`,`cno`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

    LOCK TABLES `sc` WRITE;

    INSERT INTO `sc` VALUES ('s001','c001',78.90),('s001','c002',82.90),('s001','c003',59.00),('s001','c007',78.90),('s001','c010',78.90),('s002','c001',80.90),('s002','c002',72.90),('s002','c004',52.90),('s002','c005',92.90),('s003','c001',81.90),('s003','c002',82.90),('s003','c004',20.90),('s004','c001',50.90),('s004','c004',59.80),('s005','c001',59.90),('s005','c004',50.80),('s006','c003',99.80);

    UNLOCK TABLES;

    DROP TABLE IF EXISTS `student`;

    CREATE TABLE `student` (
      `sno` varchar(10) NOT NULL,
      `sname` varchar(20) DEFAULT NULL,
      `sage` int DEFAULT NULL,
      `ssex` varchar(5) DEFAULT NULL,
      PRIMARY KEY (`sno`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

    LOCK TABLES `student` WRITE;

    INSERT INTO `student` VALUES ('s001','張三',23,'男'),('s002','李四',23,'男'),('s003','吳鵬',25,'男'),('s004','琴沁',20,'女'),('s005','王麗',20,'女'),('s006','李波',21,'男'),('s007','劉玉',21,'男'),('s008','蕭蓉',21,'女'),('s009','陳蕭曉',23,'女'),('s010','陳美',22,'女'),('s011','王麗',24,'女'),('s012','蕭蓉',20,'女');

    UNLOCK TABLES;

    DROP TABLE IF EXISTS `teacher`;

    CREATE TABLE `teacher` (
      `tno` varchar(10) NOT NULL,
      `tname` varchar(20) DEFAULT NULL,
      PRIMARY KEY (`tno`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

    LOCK TABLES `teacher` WRITE;

    INSERT INTO `teacher` VALUES ('t001','劉陽'),('t002','諶燕'),('t003','胡明星');

    UNLOCK TABLES;
```

# MySQL題目

    1. 查詢學生表的 前10條資料

    2. 查詢成績表所有成績的最低分,平均分,總分

    3. 查詢老師 “諶燕” 所帶的課程設數量

    4. 查詢所有老師所帶 的課程 數量

    5. 查詢姓”張”的學生名單

    6. 查詢課程名稱為'Oracle'且分數低於60 的學號和分數

    7. 查詢所有學生的選課 課程名稱

    8. 查詢任何一門課程成績在70 分以上的學生姓名.課程名稱和分數

    9. 查詢不及格的課程,並按課程號從大到小排列 學號,課程號,課程名,分數

    10. 查詢沒學過”諶燕”老師講授的任一門課程的學號,學生姓名

    11. 查詢兩門以上不及格課程的同學的學號及其平均成績

    12. 檢索'c004'課程分數小於60,按分數降序排列的同學學號

    13. 查詢'c001'課程比'c002'課程成績高的所有學生的學號

    14. 查詢平均成績大於60 分的同學的學號和平均成績

    15. 查詢所有同學的學號.姓名.選課數.總成績

    16. 查詢姓”劉”的老師的個數

    17. 查詢只學”諶燕”老師所教的課的同學的學號:姓名

    18. 查詢學過”c001″並且也學過編號”c002″課程的同學的學號.姓名

    19. 查詢學過”諶燕”老師所教的所有課的同學的學號:姓名

    20. 查詢課程編號”c004″的成績比課程編號”c001″和”c002″課程低的所有同學的學號.姓名

    21. 查詢所有課程成績小於60 分的同學的學號.姓名

    22. 查詢沒有學課的同學的學號.姓名

    23. 查詢與學號為”s001″一起上過課的同學的學號和姓名

    24. 查詢跟學號為”s005″所修課程完全一樣的同學的學號和姓名

    25. 查詢各科成績最高和最低的分 顯示:課程ID,最高分,最低分

    26. 按各科平均成績和及格率的百分數 照平均從低到高顯示

    27. 查詢每個課程的老師及平均分從高到低顯示 老師名稱,課程名稱,平均分數

    28. 統計列印各科成績,各分數段人數:課程ID,課程名稱,verygood[100-86], good[85-71], bad[<60]

    29. 查詢各科成績前三名的記錄:(不考慮成績並列情況)

    30. 查詢每門課程被選修的學生數

    31. 查詢出只選修了兩門課程的全部學生的學號和姓名

    32. 查詢男生.女生人數

        32-1. 查詢每個課程的男生女生總數

    33. 查詢同名同姓學生名單,並統計同名人數

    34. 查詢年紀最小跟最大的學生名單(注:Student 表中Sage 列的型別是int)

    35. 查詢每門課程的平均成績,結果按平均成績升序排列,平均成績相同時,按課程號降序排列

    36. 查詢平均成績大於85 的所有學生的學號.姓名和平均成績

    37. 查詢課程編號為c001 且課程成績在80 分以上的學生的學號和姓名

    38. 檢索每課程第二高分的學號 分數(考慮成績並列)

    39. 求選了課程的學生人數

    40. 查詢選修”諶燕”老師所授課程的學生中,成績最高的學生姓名及其成績

    41. 查詢不同課程成績有相同的學生的學號.課程號.學生成績

    42. 所有課程排名成績(不考慮並列) 學號,課程號,排名,成績 照課程,排名排序

    43. 所有課程排名成績(考慮並列) 學號,課程號,排名,成績 照課程,排名排序

    44. 做所有學生顯示學生名稱,課程名稱,成績,老師名稱的視圖

    45. 查詢上過所有老師教的課程的學生 學號,學生名

    46. 查詢包含數字的課程名

    47. 查詢只有英文的課程名

    48. 查詢所有學生的平均成績 並排名 , 學號,學生名,排名,平均成績(不考慮並列) 對平均成績高到低及學號低到高排序

    49. 查詢所有學生的平均成績 並排名 , 學號,學生名,排名,平均成績(考慮並列) 對平均成績高到低及學號低到高排序

    50. 查詢課程有學生的成績是其他人成績兩倍的學號 學生名

# 解答

## 1. 查詢學生表的前10條資料
```sql
SELECT *
FROM student
LIMIT 0,10
```

## 2. 查詢成績表所有成績的最低分、平均分、總分
```sql
SELECT MIN(score),AVG(score),SUM(score)
FROM sc
```

## 3. 查詢老師"諶燕"所帶的課程設數量
```sql
SELECT COUNT(*)
FROM course LEFT JOIN teacher USING(tno)
WHERE tname='諶燕'
```

## 4. 查詢所有老師所帶的課程數量
```sql
SELECT tname,COUNT(*)
FROM course LEFT JOIN teacher USING(tno)
GROUP BY tno
```

## 5. 查詢姓"張"的學生名單
```sql
SELECT sname
FROM student
WHERE sname LIKE '張%'
```

## 6. 查詢課程名稱為'Oracle'且分數低於60的學號和分數
```sql
SELECT sno,score
FROM sc LEFT JOIN course USING(cno)
WHERE cname = 'Oracle' AND score <60
```

## 7. 查詢所有學生的選課課程名稱
```sql
SELECT sname,cname
FROM sc LEFT JOIN student USING(sno) LEFT JOIN course USING(cno)
```

## 8. 查詢任何一門課程成績在70分以上的學生姓名、課程名稱和分數
```sql
SELECT sname,cname,score
FROM sc LEFT JOIN student USING(sno) LEFT JOIN course USING(cno)
WHERE score >= 70
```

## 9. 查詢不及格的課程，並按課程號從大到小排列學號、課程號、課程名、分數
```sql
SELECT sno,cno,cname,score
FROM sc LEFT JOIN student USING(sno) LEFT JOIN course USING(cno)
WHERE score < 60
ORDER BY cno DESC
```

## 10. 查詢沒學過"諶燕"老師講授的任一門課程的學號、學生姓名
```sql
SELECT sno,sname
FROM student
WHERE sno NOT IN(SELECT DISTINCT sno
FROM sc LEFT JOIN student USING(sno) LEFT JOIN course USING(cno) LEFT JOIN teacher USING(tno)
WHERE tname IN ('諶燕'))
```

## 11. 查詢兩門以上不及格課程的同學的學號及其平均成績
```sql
SELECT sno,AVG(score)
FROM sc
WHERE score < 60
GROUP BY sno
HAVING COUNT(score) >= 2
```

## 12. 檢索'c004'課程分數小於60，按分數降序排列的同學學號
```sql
SELECT sno,score
FROM sc
WHERE score < 60 AND cno='c004'
ORDER BY score DESC
```

## 13. 查詢'c001'課程比'c002'課程成績高的所有學生的學號
```sql
SELECT a.sno
FROM sc a,sc b
WHERE a.sno = b.sno AND a.cno='c001' AND b.cno='c002' AND a.score > b.score
```

## 14. 查詢平均成績大於60分的同學的學號和平均成績
```sql
SELECT sno,AVG(score)
FROM sc
GROUP BY sno
HAVING AVG(score)>60
```

## 15. 查詢所有同學的學號、姓名、選課數、總成績
```sql
SELECT sno,sname,COUNT(cno),SUM(score)
FROM sc LEFT JOIN student USING(sno)
GROUP BY sno
```

## 16. 查詢姓"劉"的老師的個數
```sql
SELECT COUNT(*)
FROM teacher
WHERE tname LIKE '劉%'
```

## 17. 查詢只學"諶燕"老師所教的課的同學的學號、姓名
```sql
SELECT DISTINCT sno,sname
FROM sc LEFT JOIN student USING(sno)
WHERE sno NOT IN (SELECT sno FROM sc
WHERE cno NOT IN(SELECT cno FROM course LEFT JOIN teacher USING(tno) WHERE tname='諶燕'))
```

## 18. 查詢學過"c001"並且也學過編號"c002"課程的同學的學號、姓名
```sql
SELECT sno,sname
FROM student
WHERE sno IN(SELECT a.sno
FROM sc a,sc b 
WHERE a.sno=b.sno AND a.cno='c001' AND b.cno='c002')
```

## 19. 查詢學過"諶燕"老師所教的所有課的同學的學號、姓名
```sql
SELECT sno,sname
FROM sc x LEFT JOIN student USING(sno) LEFT JOIN course USING(cno) LEFT JOIN teacher USING(tno)
WHERE cno IN(SELECT cno FROM course LEFT JOIN teacher USING(tno) WHERE tname='諶燕')
GROUP BY sno
HAVING COUNT(*)=(SELECT COUNT(*) FROM course LEFT JOIN teacher USING(tno) WHERE tname='諶燕')
```

## 20. 查詢課程編號"c004"的成績比課程編號"c001"和"c002"課程低的所有同學的學號、姓名
```sql
SELECT a.sno
FROM sc a,sc b,sc c
WHERE a.sno = b.sno AND b.sno = c.sno AND a.cno='c001' 
AND b.cno='c004' AND c.cno='c002' AND a.score > b.score AND c.score > b.score
```

## 21. 查詢所有課程成績小於60分的同學的學號、姓名
```sql
SELECT DISTINCT sno
FROM sc x
WHERE 60 > ALL(SELECT score FROM sc y WHERE x.sno=y.sno)
```

## 22. 查詢沒有學課的同學的學號、姓名
```sql
SELECT sno,sname
FROM student
WHERE sno NOT IN(SELECT DISTINCT sno FROM sc)
```

## 23. 查詢與學號為"s001"一起上過課的同學的學號和姓名
```sql
SELECT DISTINCT sc.sno,student.sname
FROM sc RIGHT JOIN student USING(sno)
WHERE cno IN(SELECT DISTINCT cno
FROM sc
WHERE sno='s001')
AND sc.sno <> 's001'
```

## 24. 查詢跟學號為"s005"所修課程完全一樣的同學的學號和姓名

### 方法一：
```sql
SELECT sno,sname
FROM sc x LEFT JOIN student USING(sno)
WHERE cno IN(SELECT cno FROM sc WHERE sno = 's005')
GROUP BY sno
HAVING COUNT(cno)=(SELECT COUNT(*) FROM sc WHERE sno = 's005') 
AND (SELECT COUNT(*) FROM sc WHERE sno = 's005') = ALL(SELECT COUNT(cno) FROM sc y WHERE x.sno=y.sno ) 
AND sno <> 's005';
```

### 方法二：
```sql
SELECT sno,sname
FROM sc LEFT JOIN student USING(sno)
GROUP BY sno
HAVING GROUP_CONCAT(cno ORDER BY cno) =(SELECT GROUP_CONCAT(cno ORDER BY cno)FROM sc WHERE sno='s005')
AND sno <> 's005';
```

## 25. 查詢各科成績最高和最低的分，顯示：課程ID、最高分、最低分
```sql
SELECT cno,MAX(score),MIN(score)
FROM sc 
GROUP BY cno
```

## 26. 按各科平均成績和及格率的百分數，照平均從低到高顯示
```sql
SELECT cno,AVG(score),CONCAT(ROUND(COALESCE(count,0)/tcount,2)*100,'%')AS passing
FROM sc LEFT JOIN (SELECT cno,COUNT(*) AS count FROM sc WHERE score > 60 GROUP BY cno)AS pass USING(cno)
LEFT JOIN (SELECT cno,COUNT(*) AS tcount FROM sc GROUP BY cno)AS total USING(cno)
GROUP BY cno
ORDER BY AVG(score)
```

## 27. 查詢每個課程的老師及平均分從高到低顯示，老師名稱、課程名稱、平均分數
```sql
SELECT tname,cname,AVG(score)
FROM sc LEFT JOIN course USING(cno) LEFT JOIN teacher USING(tno)
GROUP BY tno,cno
ORDER BY AVG(score) DESC
```

## 28. 統計列印各科成績，各分數段人數：課程ID、課程名稱、verygood[100-86]、good[85-71]、bad[<60]

### 方法一：
```sql
SELECT cno,cname,COALESCE(verygoodc,0)verygood, COALESCE(goodc,0)good, COALESCE(badc,0)bad
FROM sc LEFT JOIN (SELECT cno,COUNT(*) verygoodc FROM sc WHERE score BETWEEN 86 AND 100 GROUP BY cno)AS verygoodsc USING(cno)
LEFT JOIN (SELECT cno,COUNT(*) goodc FROM sc WHERE score BETWEEN 71 AND 85 GROUP BY cno)AS goodsc USING(cno)
LEFT JOIN (SELECT cno,COUNT(*) badc FROM sc WHERE score < 60 GROUP BY cno)AS badsc USING(cno)
LEFT JOIN course USING(cno)
GROUP BY cno
```

### 方法二：
```sql
SELECT sc.cno,course.cname,
SUM(CASE WHEN sc.score BETWEEN 86 AND 100 THEN 1 ELSE 0 END)verygood,
SUM(CASE WHEN sc.score BETWEEN 71 AND 85 THEN 1 ELSE 0 END)good,
SUM(CASE WHEN sc.score < 60 THEN 1 ELSE 0 END)bad
FROM sc,course
WHERE sc.cno=course.cno
GROUP BY cno
```

## 29. 查詢各科成績前三名的記錄（不考慮成績並列情況）
```sql
SELECT *
FROM sc x
WHERE (SELECT COUNT(*) FROM sc y WHERE x.cno = y.cno AND x.score < y.score)<3 
ORDER BY cno,score DESC
```

## 30. 查詢每門課程被選修的學生數
```sql
SELECT cno,COUNT(*)
FROM sc
GROUP BY cno
```

## 31. 查詢出只選修了兩門課程的全部學生的學號和姓名
```sql
SELECT sno,sname
FROM sc LEFT JOIN student USING(sno)
GROUP BY sno
HAVING COUNT(*)=2
```

## 32. 查詢男生、女生人數
```sql
SELECT ssex,COUNT(*)
FROM student
GROUP BY ssex
```

## 32-1. 查詢每個課程的男生女生總數
```sql
SELECT cno,cname,COALESCE(boy,0)AS boy,COALESCE(girl,0)AS girl
FROM course 
LEFT JOIN (SELECT cno,COUNT(*)AS boy FROM `course` JOIN sc USING(cno) JOIN student USING(sno)
GROUP BY cno,ssex HAVING ssex = '男' ORDER BY cno)AS cb USING(cno)
LEFT JOIN (SELECT cno,COUNT(*)AS girl FROM `course` JOIN sc USING(cno) JOIN student USING(sno)
GROUP BY cno,ssex HAVING ssex = '女' ORDER BY cno)AS cg USING(cno)
```

## 33. 查詢同名同姓學生名單，並統計同名人數
```sql
SELECT sname,COUNT(*)
FROM student x 
GROUP BY sname
HAVING COUNT(*)>1
```

## 34. 查詢年紀最小跟最大的學生名單（注：Student表中Sage列的型別是int）
```sql
SELECT *
FROM student
WHERE sno IN(SELECT sno FROM student x WHERE (SELECT COUNT(*) FROM student y WHERE x.sage > y.sage)<1)
OR sno IN(SELECT sno FROM student x WHERE (SELECT COUNT(*) FROM student y WHERE x.sage < y.sage)<1)
```

## 35. 查詢每門課程的平均成績，結果按平均成績升序排列，平均成績相同時，按課程號降序排列
```sql
SELECT cno,AVG(score)
FROM sc LEFT JOIN student USING(sno)
GROUP BY cno
ORDER BY AVG(score),cno DESC
```

## 36. 查詢平均成績大於85的所有學生的學號、姓名和平均成績
```sql
SELECT sno,sname,AVG(score)
FROM sc LEFT JOIN student USING(sno)
GROUP BY sno
HAVING AVG(score) > 75
```

## 37. 查詢課程編號為c001且課程成績在80分以上的學生的學號和姓名
```sql
SELECT sno,sname
FROM sc LEFT JOIN student USING(sno)
WHERE cno='c001' AND score>=80
```

## 38. 檢索每課程第二高分的學號分數（考慮成績並列）
```sql
SELECT *
FROM (SELECT * FROM sc GROUP BY score,cno)AS sca
WHERE (SELECT COUNT(*) FROM (SELECT * FROM sc GROUP BY score,cno)AS scb WHERE sca.cno=scb.cno AND sca.score < scb.score)=1
ORDER BY cno
```

**注意：課程人數要多於一人，否則不顯示此課程**

## 39. 求選了課程的學生人數
```sql
SELECT COUNT(*)
FROM (SELECT DISTINCT sno FROM sc)AS scount
```

## 40. 查詢選修"諶燕"老師所授課程的學生中，成績最高的學生姓名及其成績
```sql
SELECT sname,score
FROM sc x LEFT JOIN student USING(sno) LEFT JOIN course USING(cno) LEFT JOIN teacher USING(tno)
WHERE tname='諶燕' AND score = (SELECT MAX(score)
FROM sc x LEFT JOIN student USING(sno) LEFT JOIN course USING(cno) LEFT JOIN teacher USING(tno)
WHERE tname='諶燕')
```

## 41. 查詢不同課程成績有相同的學生的學號、課程號、學生成績
```sql
SELECT DISTINCT x.sno,x.cno,x.score
FROM sc x,sc y
WHERE x.sno=y.sno AND x.cno <> y.cno AND x.score=y.score
```

## 42. 所有課程排名成績（不考慮並列）學號、課程號、排名、成績，照課程、排名排序
```sql
SELECT sc.sno,sc.cno,
CASE WHEN @pre_parent_code=sc.cno THEN @curRank:=@curRank+1 
WHEN @pre_parent_code:=sc.cno THEN  @curRank:=1 
ELSE @curRank:=1
END AS rank,sc.score
FROM (select @curRank:=0,@pre_parent_code:='') r,sc
ORDER BY sc.cno,sc.score DESC
```

## 43. 所有課程排名成績（考慮並列）學號、排名、成績、課程號，照課程、排名排序
```sql
SELECT sc.sno,
CASE WHEN @pre_parent_code=sc.cno 
THEN (CASE WHEN @prefontscore=sc.score THEN @curRank WHEN @prefontscore:=sc.score THEN @curRank:=@curRank+1 END)
WHEN  @prefontscore:=sc.score THEN  @curRank:=1 END AS rank ,sc.score,@pre_parent_code:=sc.cno AS cno
FROM (SELECT @curRank:=0,@pre_parent_code:='',@prefontscore:=NULL) r,sc
ORDER BY sc.cno,sc.score DESC
```

**注意：此解答的課程編號賦值必須放在CASE判斷後欄位**

## 44. 建立所有學生顯示學生名稱、課程名稱、成績、老師名稱的視圖
```sql
SELECT sname,cname,score,tname
FROM student LEFT JOIN sc USING(sno) LEFT JOIN course USING(cno) LEFT JOIN teacher USING(tno)
```

## 45. 查詢上過所有老師教的課程的學生學號、學生名
```sql
SELECT sno,sname
FROM sc LEFT JOIN course USING(cno) LEFT JOIN student USING(sno) 
GROUP BY sno
HAVING GROUP_CONCAT(DISTINCT tno ORDER BY tno) = (SELECT GROUP_CONCAT(tno ORDER BY tno) FROM teacher)
```

## 46. 查詢包含數字的課程名
```sql
SELECT cname
FROM course
WHERE cname REGEXP '[0-9]'
```

## 47. 查詢只有英文的課程名
```sql
SELECT cname
FROM course
WHERE cname REGEXP '^([a-z]|[A-Z])+$'
```

## 48. 查詢所有學生的平均成績並排名，學號、學生名、排名、平均成績（不考慮並列），對平均成績高到低及學號低到高排序
```sql
SELECT scc.sno,scc.sname,@curRank:=@curRank+1 AS rank,scc.avgscore
FROM(SELECT sc.sno,student.sname,AVG(sc.score)AS avgscore
FROM sc LEFT JOIN student USING(sno)
GROUP BY sc.sno)AS scc,(SELECT @curRank:=0) AS r
ORDER BY scc.avgscore DESC,sno
```

## 49. 查詢所有學生的平均成績並排名，學號、學生名、排名、平均成績（考慮並列），對平均成績高到低及學號低到高排序
```sql
SELECT scavg.sno,scavg.sname,CASE WHEN @prevRank=scavg.avgscore THEN @curRank
WHEN @prevRank:=scavg.avgscore THEN @curRank:=@curRank+1 END AS rank,scavg.avgscore
FROM  (SELECT sno,sname,AVG(score) AS avgscore FROM sc LEFT JOIN student USING(sno) GROUP BY sno)AS scavg , 
(SELECT @curRank:=0,@prevRank:=NULL) AS r
ORDER BY scavg.avgscore DESC,scavg.sno
```

## 50. 查詢課程有學生的成績是其他人成績兩倍的學號學生名
```sql
SELECT sno,sname
FROM sc x LEFT JOIN student USING(sno)
WHERE (SELECT COUNT(*) FROM sc y WHERE x.sno <> y.sno AND x.cno = y.cno AND x.score/2 > y.score) > 0
```

# MySQL 常用語法筆記大全

## 1. 基本 CRUD 語法

```sql
-- 查詢全部
SELECT * FROM users;

-- 查詢指定欄位
SELECT id, name FROM users;

-- 新增資料
INSERT INTO users (name, email) VALUES ('Andy', 'andy@example.com');

-- 修改資料
UPDATE users SET email = 'new@example.com' WHERE id = 1;

-- 刪除資料
DELETE FROM users WHERE id = 1;
```

## 2. 條件查詢 WHERE / LIKE / IN

```sql
-- AND / OR 條件
SELECT * FROM users WHERE age > 18 AND gender = 'male';

-- 模糊查詢
SELECT * FROM users WHERE name LIKE '%an%';

-- IN 多個條件
SELECT * FROM users WHERE city IN ('Taipei', 'Kaohsiung');

-- BETWEEN 範圍查詢
SELECT * FROM products WHERE price BETWEEN 100 AND 500;
```

## 3. 聚合函數（統計）

```sql
-- 總筆數
SELECT COUNT(*) FROM orders;

-- 平均值
SELECT AVG(score) FROM students;

-- 最大/最小值
SELECT MAX(price), MIN(price) FROM products;

-- 總和
SELECT SUM(amount) FROM payments;
```

## 4. 分組 / 排序 / 過濾

```sql
-- GROUP BY + 聚合
SELECT city, COUNT(*) FROM users GROUP BY city;

-- HAVING 條件
SELECT city, COUNT(*) AS cnt
FROM users
GROUP BY city
HAVING cnt > 10;

-- 排序
SELECT * FROM products ORDER BY price DESC;

-- 多欄排序
SELECT * FROM products ORDER BY category ASC, price DESC;
```

## 5. JOIN 語法

```sql
-- INNER JOIN
SELECT u.name, o.amount
FROM users u
JOIN orders o ON u.id = o.user_id;

-- LEFT JOIN
SELECT u.name, o.amount
FROM users u
LEFT JOIN orders o ON u.id = o.user_id;

-- RIGHT JOIN
SELECT u.name, o.amount
FROM users u
RIGHT JOIN orders o ON u.id = o.user_id;
```

## 6. 子查詢（Subquery）

```sql
-- 查詢平均分以上的學生
SELECT * FROM students
WHERE score > (SELECT AVG(score) FROM students);

-- IN 子查詢
SELECT * FROM orders
WHERE user_id IN (SELECT id FROM users WHERE city = 'Taipei');
```

## 7. 資料表操作語法

```sql
-- 建立資料表
CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  email VARCHAR(100) UNIQUE
);

-- 加欄位
ALTER TABLE users ADD COLUMN age INT;

-- 改欄位名稱
ALTER TABLE users CHANGE name full_name VARCHAR(100);

-- 刪除欄位
ALTER TABLE users DROP COLUMN age;

-- 刪除表格
DROP TABLE users;
```

## 8. 索引 / 主鍵 / 外鍵

```sql
-- 建立索引
CREATE INDEX idx_name ON users(name);

-- 建立唯一索引
CREATE UNIQUE INDEX idx_email ON users(email);

-- 建立外鍵
ALTER TABLE orders
ADD CONSTRAINT fk_user
FOREIGN KEY (user_id) REFERENCES users(id);
```

## 9. 分頁 LIMIT / OFFSET

```sql
-- 前 10 筆
SELECT * FROM users LIMIT 10;

-- 第 11~20 筆
SELECT * FROM users LIMIT 10 OFFSET 10;
```

## 10. 使用者與權限管理

```sql
-- 建立使用者
CREATE USER 'andy'@'localhost' IDENTIFIED BY 'password123';

-- 賦予權限
GRANT ALL PRIVILEGES ON mydb.* TO 'andy'@'localhost';

-- 撤銷權限
REVOKE ALL PRIVILEGES ON mydb.* FROM 'andy'@'localhost';

-- 查看使用者
SELECT user, host FROM mysql.user;
```

## 11. 補充：視圖 / 函數 / 觸發器

```sql
-- 建立視圖
CREATE VIEW top_students AS
SELECT * FROM students WHERE score > 90;

-- 建立函數
CREATE FUNCTION get_tax(price DECIMAL(10,2))
RETURNS DECIMAL(10,2)
RETURN price * 0.05;

-- 建立觸發器
CREATE TRIGGER update_time
BEFORE UPDATE ON users
FOR EACH ROW SET NEW.updated_at = NOW();
```

