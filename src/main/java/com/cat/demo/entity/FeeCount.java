package com.cat.demo.entity;

import com.cat.demo.constant.DictEnum;

import java.math.BigDecimal;
import java.util.Date;

//按刻度收费时的数值记录表...
public class FeeCount {

	private int id;

	private int houseId;// 这里简化处理为刻度在存在于house上(否则同样需要gridId+gridType联合定位)

	private DictEnum.FeeType feeType;

	private BigDecimal ruling;// 刻度

	private Date date;// 日期

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public DictEnum.FeeType getFeeType() {
		return feeType;
	}

	public void setFeeType(DictEnum.FeeType feeType) {
		this.feeType = feeType;
	}

	public int getHouseId() {
		return houseId;
	}

	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getRuling() {
		return ruling;
	}

	public void setRuling(BigDecimal ruling) {
		this.ruling = ruling;
	}
}
