package com.hiranga.BillingSystem;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SupplierTable {
	@Id
private String SupplierID;
private String SuppliarName; 
private String CompanyName;
private String ContactNumber;
private String CompanyAddress;


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

}
