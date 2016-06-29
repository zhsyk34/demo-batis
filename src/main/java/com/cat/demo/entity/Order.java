package com.cat.demo.entity;

import java.util.Date;

import com.cat.demo.constant.DictEnum;
import com.cat.demo.util.FormatUtil;

/**
 * @author Cat
 * 修改订单是保持订单号不变,新增记录
 * 为避免订单表数据过多,可定时将历史订单记录转移至其它表(新增record表,同时删除已转移记录)
 */
public class Order {

	private int id;

	private String orderNo;// 区分是否同一订单(保留订单变更记录...)

	private int tenantId;// 租客,修改订单时不可变

	// 此处简化为租房的最大范围为houseId(roomId在明细中补充),否则也应未girdId+gridType...
	private int houseId;

	/**
	 * 住房类型,需要在detail中相应处理
	 * 比如整租时需将其名下所有房间关联(如果roomId等子集无used字段则可省略...)
	 */
	private DictEnum.GridType gridType;

	private Date begin;// 签约时间

	private Date end;// 到期时间

	private Date happen;// 发生时间

	private DictEnum.OrderStatus status;// 订单状态

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

	public DictEnum.GridType getGridType() {
		return gridType;
	}

	public void setGridType(DictEnum.GridType gridType) {
		this.gridType = gridType;
	}

	public Date getHappen() {
		return happen;
	}

	public void setHappen(Date happen) {
		this.happen = happen;
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

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public DictEnum.OrderStatus getStatus() {
		return status;
	}

	public void setStatus(DictEnum.OrderStatus status) {
		this.status = status;
	}

	public int getTenantId() {
		return tenantId;
	}

	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}

	@Override
	public String toString() {
		return "Order{" + "begin=" + FormatUtil.dateToString(begin, null) + ", id=" + id + ", orderNo='" + orderNo + '\'' + ", houseId=" + houseId + ", tenantId=" + tenantId + ", gridType=" + gridType + ", end=" + end + ", happen=" + FormatUtil.dateToString(happen, null) + ", status=" + status + '}';
	}
}
