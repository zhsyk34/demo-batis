package com.cat.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.cat.demo.constant.DictEnum;

/**
 * 计费参照
 */
public class FeeRef {

	private int id;

	// gridId+gridType联合定位计费目标(事实上的主键)
	// 如gridId:1,gridType:house表示该费用标准范围为house
	// 计费标准应在业务中明确,如grid:3,girdType:City,feeType:water表示城市3的水费标准...
	private int gridId;
	private DictEnum.GridType gridType;

	private DictEnum.FeeType feeType;// 费用类型

	private DictEnum.CalcType calcType;// 计价方式(单价所指...,以此计算计价数量)

	private BigDecimal price;// 单价

	private String unit;// 单位

	private Date begin;// 物价表开始执行的时间

	private Date end;// 当前物价表的终止日期,为空默认为永久,当新增记录时,begin应与同gridId+girdType的上一条记录end时间衔接

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGridId() {
		return gridId;
	}

	public void setGridId(int gridId) {
		this.gridId = gridId;
	}

	public DictEnum.GridType getGridType() {
		return gridType;
	}

	public void setGridType(DictEnum.GridType gridType) {
		this.gridType = gridType;
	}

	public DictEnum.FeeType getFeeType() {
		return feeType;
	}

	public void setFeeType(DictEnum.FeeType feeType) {
		this.feeType = feeType;
	}

	public DictEnum.CalcType getCalcType() {
		return calcType;
	}

	public void setCalcType(DictEnum.CalcType calcType) {
		this.calcType = calcType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

}
