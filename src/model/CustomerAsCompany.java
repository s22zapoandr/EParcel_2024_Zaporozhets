package model;

public class CustomerAsCompany extends AbstractCustomer {
	private String title;
	private String companyRegNo;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		if(title != null) {
			this.title = title;
		}
		else
		{
			this.title = "Stark Industries";
		}
	}
	public String getCompanyRegNo() {
		return companyRegNo;
	}
	public void setCompanyRegNo(String companyRegNo) {
		if(companyRegNo != null) {
			this.companyRegNo = companyRegNo;
		}
		else
		{
			this.companyRegNo = "000000000";
		}
	}
	
	public void setCustomerCode() {
		super.customerCode = (String) (cID+"_company_"+companyRegNo) ;
	}
	
	public CustomerAsCompany() {
		super();
		setTitle("Stark Industries");
		setCompanyRegNo("000000000");
		setCustomerCode();
	}
	
	public CustomerAsCompany(Address address, String phoneNo, String title, String companyRegNo) {
		setcID();
		setAddress(address);
		setPhoneNo(phoneNo);
		setPackages(getParcels());
		setCustomerCode();
		setTitle(title);
		setCompanyRegNo(companyRegNo);
	}
	
	public String toString() {
		return super.toString()  + " company name: " + title + " regestration number " + companyRegNo; 
	}
}
