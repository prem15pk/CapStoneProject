package com.Medicare.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue
	private int id;
	private String orderName;
	private long orderPrice;
	private int orderQuandity;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(String orderName, long orderPrice, int orderQuandity) {
		super();
		this.orderName = orderName;
		this.orderPrice = orderPrice;
		this.orderQuandity = orderQuandity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public long getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(long orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getOrderQuandity() {
		return orderQuandity;
	}

	public void setOrderQuandity(int orderQuandity) {
		this.orderQuandity = orderQuandity;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderName=" + orderName + ", orderPrice=" + orderPrice + ", orderQuandity="
				+ orderQuandity + "]";
	}

}
