CREATE TABLE bicycle(
	bike_no varchar(32) PRIMARY KEY COMMENT '主键》单车编号',
	model varchar(32) COMMENT '单车类别',
	b_type varchar(32) COMMENT '单车型号',
	gys varchar(32) COMMENT '供应商',
	remain_num int(11) COMMENT '剩余数量'
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
			








