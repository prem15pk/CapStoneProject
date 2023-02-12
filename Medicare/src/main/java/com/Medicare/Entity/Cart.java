package com.Medicare.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue
	private int id;
	private String productName;
	private long productAmount;
	private String productCategory;
	private String productDescription;

	public Cart() {

	}

	public Cart(String productName, long productAmount, String productCategory, String productDescription) {
		super();
		this.productName = productName;
		this.productAmount = productAmount;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(long productAmount) {
		this.productAmount = productAmount;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", productName=" + productName + ", productAmount=" + productAmount
				+ ", productCategory=" + productCategory + ", productDescription=" + productDescription + "]";
	}

}
