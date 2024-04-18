package model;
 
public class Address {
	private City city;
	private String streetOrHouseTitle;
	private int houseNo;
	
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		if(city != null) {
			this.city = city;
		}
		else {
			System.out.println("Invalid input, no such city avaliable");
		}
		}
	public String getStreetOrHouseTitle() {
		return streetOrHouseTitle;
	}
	public void setStreetOrHouseTitle(String streetOrHouseTitle) {
		if(streetOrHouseTitle != null && streetOrHouseTitle.matches("[A-Za-z ]{3,20}")) {
			this.streetOrHouseTitle = streetOrHouseTitle;
		}
		else {
			System.out.println("Invalid input");
		}
	}
	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		if(houseNo > 0 && houseNo < 10000) {
			this.houseNo = houseNo;
		}
		else {
			System.out.println("Invalid input");
		}
	}
	
	public Address() {
		setCity(City.Ventspils);
		setStreetOrHouseTitle("Inženieru iela");
		setHouseNo(101);	
	}
	public Address(City city, String streetOrHouseTitle, int houseNo) {
		setCity(city);
		setStreetOrHouseTitle(streetOrHouseTitle);
		setHouseNo(houseNo);
	}
	
	public String toString() {
		return city + " " + streetOrHouseTitle + " " + houseNo;
	}
	
}
