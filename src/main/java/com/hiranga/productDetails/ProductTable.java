package com.hiranga.productDetails;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.hiranga.BillingSystem.SupplierTable;

@Entity
public class ProductTable {
	@Id
private String ProductId;
private String Product;
private String Amount;
private String Meisure;
private String OtherDetails;
@OneToMany
private List<SupplierTable> suppliertable = new ArrayList<SupplierTable>();

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
public List<SupplierTable> getSuppliertable() {
	return suppliertable;
}
public void setSuppliertable(List<SupplierTable> suppliertable) {
	this.suppliertable = suppliertable;
}



}
