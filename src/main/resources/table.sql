CREATE TABLE bicycle(
	bike_no varchar(32) PRIMARY KEY COMMENT '主键》单车编号',
	model varchar(32) COMMENT '单车类别',
	b_type varchar(32) COMMENT '单车型号',
	gys varchar(32) COMMENT '供应商',
	remain_num int(11) COMMENT '剩余数量',
	status int(1) DEFAULT 0 COMMENT '租赁状态(0-已还车，1-租赁中)'
);

CREATE TABLE `dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `group_id` varchar(32) NOT NULL COMMENT '组id',
  `dict_name` varchar(32) NOT NULL COMMENT '页面显示的名称',
  `dict_value` varchar(32) NOT NULL COMMENT '页面提交的值',
  `sort` int(11) NOT NULL COMMENT '排序字段',
  PRIMARY KEY (`id`)
);

insert into bicycle (bike_no,model,gys,remain_num)
		values
		(REPLACE(UUID(),'-',''),'1','2',123);
		

select b.bike_no as bikeNo,
			b.model,
			b.b_type as bType,
			b.gys,
			b.remain_num as remainNum,
			d.dict_name as modelName 
			from bicycle b 
			LEFT JOIN dict d 
			ON b.model = d.dict_value;
			

##租赁表字段：租赁号，单车型号(外键)，单车编号(外键)，租赁人，联系电话，租赁时间，归还时间，租赁状态(租赁中、已还车)
CREATE TABLE rental(
	rental_no varchar(32) PRIMARY KEY COMMENT '租赁号',	
	bike_type varchar(32) COMMENT '单车型号 外键',
	bno varchar(32) COMMENT '单车编号 外键',
	person_name varchar(32) COMMENT '租赁人',
	phone varchar(11) COMMENT '联系电话',
	start_time datetime COMMENT '租赁时间(默认当前时间)',
	end_time datetime COMMENT '归还时间',
	##FOREIGN KEY (`btype`) REFERENCES `bicycle` (`b_type`),
	FOREIGN KEY (`bno`) REFERENCES `bicycle` (`bike_no`)  ON DELETE CASCADE
);


select DISTINCT b_type from bicycle;
select * from bicycle GROUP BY b_type;

select bike_no from bicycle where b_type = 'JAT001' and b_status = 0 and remain_num>0;

##拿取租赁号最大(最新一条)的记录
SELECT rental_no from rental ORDER BY start_time desc limit 1;



























