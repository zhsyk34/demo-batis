package com.cat.demo.entity;

import com.cat.demo.constant.DictEnum;
import com.cat.demo.util.FormatUtil;

import java.math.BigDecimal;
import java.util.Date;

public class House {

	private int id;

	private int landlordId;// 房东

	private String name;// 名称(坐标,如1708)

	private BigDecimal area;// 面积(+公摊...)

	private int rooms;// 房间数量(真实数量,挂名其下出租的room不得超过此数...)

	private Date buildTime;// 模拟小区建筑时间...

	private DictEnum.RentState rentState;// 托管状态

	private boolean used;// 是否已使用(亦可省略,但需要查询其下所有房间的状态...)

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public Date getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLandlordId() {
		return landlordId;
	}

	public void setLandlordId(int landlordId) {
		this.landlordId = landlordId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DictEnum.RentState getRentState() {
		return rentState;
	}

	public void setRentState(DictEnum.RentState rentState) {
		this.rentState = rentState;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	@Override
	public String toString() {
		return "House{" + "area=" + area + ", id=" + id + ", landlordId=" + landlordId + ", name='" + name + '\'' + ", rooms=" + rooms + ", buildTime=" + FormatUtil.dateToString(buildTime, null) + ", rentState=" + rentState + ", used=" + used + '}';
	}
}
