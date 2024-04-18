package model;

import java.time.LocalDateTime;
public class Parcel {
	private LocalDateTime orderCreated;
	private LocalDateTime plannedDelivery;
	private ParcelSize size;
	private float price;
	private boolean isFragile;
	private Driver driver;
	
	
	
	public LocalDateTime getOrderCreated() {
		return orderCreated;
	}
	public void setOrderCreated() {
		this.orderCreated = LocalDateTime.now();
	}
	public LocalDateTime getPlannedDelivery() {
		return plannedDelivery;
	}
	public void setPlannedDelivery(LocalDateTime plannedDelivery) {
		if(plannedDelivery.isAfter(orderCreated)) {
			this.plannedDelivery = plannedDelivery;
		}
		else {
			this.plannedDelivery = LocalDateTime.of(2025, 04, 24, 14, 33, 48, 123456789);
		}
	}
	public ParcelSize getSize() {
		return size;
	}
	public void setSize(ParcelSize size) {
		if(size != null) {
			this.size = size;
		}
		else {
			this.size = ParcelSize.M;
		}
	}
	public float getPrice() {
		return price;
	}
	public void setPrice() {
		float counter = 0;
		if(size == ParcelSize.X) {
			counter = 1;	
		}
		else if(size == ParcelSize.S) {
			counter = 2;	
		}
		else if(size == ParcelSize.M) {
			counter = 3;	
		}
		else if(size == ParcelSize.L) {
			counter =  4;	
		}
		else if(size == ParcelSize.XL) {
			counter = 5;	
		}
		if(isFragile ) {
			this.price = (float)(counter * 1.99 + 2.99);
		}
		else {
			this.price = (float)(counter * 1.99);
		}
	}
	public boolean isFragile() {
		return isFragile;
	}
	public void setFragile(boolean isFragile) {
		if( isFragile == true || isFragile == false) {
			this.isFragile = isFragile;
		}
		else {
			this.isFragile = false;
		}
	}
	
	public Driver getDriver() {
		return driver;
	}
	
	public void setDriver(Driver driver) {
		if(driver != null) {
			this.driver = driver;
		}	
		else {
			this.driver = new Driver();
		}
	}
	
	public Parcel() {
		setDriver(new Driver());
		setFragile(false);
		setOrderCreated();
		setPlannedDelivery(LocalDateTime.of(2025, 04, 24, 14, 33, 48, 123456789));
		setPrice();
		setSize(ParcelSize.M);
	}
	
	public Parcel(LocalDateTime plannedDelivery, ParcelSize size, boolean isFragile, Driver driver) {
		setDriver(driver);
		setFragile(isFragile);
		setOrderCreated();
		setPlannedDelivery(plannedDelivery);
		setPrice();
		setSize(size);
	}
	
	public String toString() {
		return "Created :" +  orderCreated + ", planned delivery: " + plannedDelivery + " for " + price + " euros of size " + size + " is fragile :" + isFragile + " by " + driver;
	}
	
}