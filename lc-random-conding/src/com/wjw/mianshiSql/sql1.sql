#
一个表有3个字段id name score, 求出name出现次数大于3次, 分数都<60的人
select id, name, score, count(*) cnt
from student
group by name
having count(*) > 3
   and max(score) < 60;

