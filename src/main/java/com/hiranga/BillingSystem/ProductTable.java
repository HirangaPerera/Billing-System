package com.hiranga.BillingSystem;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductTable {
	@Id
private String ProductId;
private String Product;
private String Amount;
private String Meisure;
private String OtherDetails;
private String BuingPrice;
private String SelleingPrice;
@ManyToOne
@JoinColumn(name="Suppliar_ID")
private SupplierTable suppliartable;

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

public String getBuingPrice() {
	return BuingPrice;
}
public void setBuingPrice(String buingPrice) {
	BuingPrice = buingPrice;
}
public String getSelleingPrice() {
	return SelleingPrice;
}
public void setSelleingPrice(String selleingPrice) {
	SelleingPrice = selleingPrice;
}
public String getOtherDetails() {
	return OtherDetails;
}
public void setOtherDetails(String otherDetails) {
	OtherDetails = otherDetails;
}

public SupplierTable getSuppliartable() {
	return suppliartable;
}
public void setSuppliartable(SupplierTable suppliartable) {
	this.suppliartable = suppliartable;
}

}
