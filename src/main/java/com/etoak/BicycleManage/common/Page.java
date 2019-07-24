package com.etoak.BicycleManage.common;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {
	//页码
	private int pageNumber;
	//每页条数
	private int pageSize;
	//总记录数
	private long total;
	//总页数
	private int pageCount;
	//数据
	private List<T> rows;
	//上一页
	private int pre;
	//下一页
	private int next;
	
}
