
insert into xueqi (xq_name) VALUES ("2016-2017学年第一学期");
insert into xueqi (xq_name) VALUES ("2016-2017学年第二学期");
insert into xueqi (xq_name) VALUES ("2017-2018学年第一学期");
insert into xueqi (xq_name) VALUES ("2017-2018学年第二学期");

insert into zhuanye (zy_name) VALUES ("计算机应用");

insert into kemu (km_name,zy_id) VALUES ("程序设计",1);
insert into kemu (km_name,zy_id) VALUES ("数据库",1);

INSERT INTO student (xs_name) VALUES ("张三");

insert into score (xq_id,zy_id, xs_id,km_id,fenshu) VALUES (1,1,1,1,90);
insert into score (xq_id,zy_id, xs_id,km_id,fenshu) VALUES (1,1,1,2,80);

