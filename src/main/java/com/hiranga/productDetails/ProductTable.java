package com.hiranga.productDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.hiranga.BillingSystem.SupplierTable;

@Entity
public class ProductTable {
	@Id
private String ProductId;
private String Product;
private String Amount;
private String Meisure;
private String OtherDetails;
@OneToOne
private SupplierTable suppliertable;

public String getProductId() {
	return ProductId;
}
public void setProductId(String productId) {
	ProductId = productId;
}
public String getProduct() {
	return Product;
}
public void setProduct(String product) {
	Product = product;
}
public String getAmount() {
	return Amount;
}
public void setAmount(String amount) {
	Amount = amount;
}
public String getMeisure() {
	return Meisure;
}
public void setMeisure(String meisure) {
	Meisure = meisure;
}
public String getOtherDetails() {
	return OtherDetails;
}
public void setOtherDetails(String otherDetails) {
	OtherDetails = otherDetails;
}
public SupplierTable getSuppliertable() {
	return suppliertable;
}
public void setSuppliertable(SupplierTable suppliertable) {
	this.suppliertable = suppliertable;
}

}
