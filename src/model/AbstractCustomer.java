package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class AbstractCustomer {
	protected long cID;
	private Address address;
	private String phoneNo;
	private ArrayList<Parcel> parcels = new ArrayList<Parcel>();
	protected String customerCode;
	private static long counter = 0;
	
	public long getcID() {
		return cID;
	}
	public void setcID() {
		this.cID = counter;
		counter ++;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		if(address != null) {
			this.address = address;
		} else {
			this.address = new Address();
		}
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		if(phoneNo != null && phoneNo.matches("[0-9]{8}")) {
			this.phoneNo = phoneNo;
		}else {
			this.phoneNo = "00000000";
		}
	}
	public ArrayList<Parcel> getParcels() {
		return parcels;
	}
	public void setPackages(ArrayList<Parcel> parcels) {
		if(parcels != null) {
			this.parcels = parcels;
		} else {
			this.parcels = new ArrayList<Parcel>();
		}
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public abstract void setCustomerCode();
	
	public void addNewParcel(Parcel parcel) throws Exception{
		if(parcel == null) throw new Exception("Parcel is null");
		
		for(Parcel tempP: parcels) {
			if (tempP == parcel) {
				parcels.add(tempP);
				return;
			}
		}
		
	}
	
	public AbstractCustomer() {
		setAddress(new Address());
		setcID();
		//setCustomerCode();
		setPackages(parcels);
		setPhoneNo("00000000");
	}
	
	public AbstractCustomer(Address address, String phone) {
		setAddress(address);
		setcID();
		//setCustomerCode();
		setPackages(parcels);
		setPhoneNo(phone);
	}
	
	public String toString() {
		return cID + " lives at " + address + " contact number: "  + phoneNo + " parcels list: " + parcels + " code: " + customerCode;
	}
	
}
