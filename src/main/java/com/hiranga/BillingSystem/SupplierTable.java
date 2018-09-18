package com.hiranga.BillingSystem;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SupplierTable {
	@Id
private String SupplierID;
private String SuppliarName; 
private String CompanyName;
private String ContactNumber;
private String CompanyAddress;
@OneToMany(targetEntity = ProductTable.class, mappedBy="suppliartable", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
private List <ProductTable> producttable;

public String getContactNumber() {
	return ContactNumber;
}
public void setContactNumber(String contactNumber) {
	ContactNumber = contactNumber;
}
public String getSupplierID() {
	return SupplierID;
}
public void setSupplierID(String supplierID) {
	SupplierID = supplierID;
}
public String getSuppliarName() {
	return SuppliarName;
}
public void setSuppliarName(String suppliarName) {
	SuppliarName = suppliarName;
}
public String getCompanyName() {
	return CompanyName;
}
public void setCompanyName(String companyName) {
	CompanyName = companyName;
}

public String getCompanyAddress() {
	return CompanyAddress;
}
public void setCompanyAddress(String companyAddress) {
	CompanyAddress = companyAddress;
}

public List<ProductTable> getProducttable() {
	return producttable;
}
public void setProducttable(List<ProductTable> producttable) {
	this.producttable = producttable;
}
@Override
public String toString() {
	return "SupplierTable [SupplierID=" + SupplierID + ", SuppliarName=" + SuppliarName + ", CompanyName=" + CompanyName
			+ ", ContactNumber=" + ContactNumber + ", CompanyAddress=" + CompanyAddress + "]";
}


}
