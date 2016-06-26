package com.cat.demo.constant;

public class DictEnum {

	// 房源托管状态
	public enum RentState {
		BOTH, // 均可
		WHOLE, // 整租
		SINGLE, // 合租
		STOP// 暂停
	}

	// 住房类型
	public enum GridType {
		CITY, // 城市
		COMMUNITY, // 小区
		HOUSE, //
		ROOM
	}

	// 费用类型
	public enum FeeType {
		DEPOSIT, // 押金
		RENT, // 月租
		WATER, // 水费
		ELECTRIC, // 电费
		GAS, // 燃气费
		PROPERTY, // 物业费
		ADSL, // 宽带
		PENALTY// 违约金
	}

	// 计价方式
	public enum CalcType {
		RULING, // 刻度(读数,如面积,度数,吨数等...)
		COUNT// 个数(数数,如个,间,套,栋...)
	}

	// 订单状态
	public enum OrderStatus {
		RESERVE("预约,收藏"), DEBT("下单未付款"), CHANGE("变更订单"), // (能否修改房源?)
		COMPLETE("已完成"), REFUND("退单申请"), WAIT("待审核"), PASS("通过退单申请");

		@SuppressWarnings("unused")
		private final String desc;

		OrderStatus(String desc) {
			this.desc = desc;
		}

	}
	// 合同略...可根据订单状态在相应时间节点提供打印需求...退单签字?//TODO
}
