package service;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import model.AbstractCustomer;
import model.AbstractCustomerAsPerson;
import model.Address;
import model.City;
import model.CustomerAsCompany;
import model.CustomerAsPerson;
import model.Driver;
import model.Parcel;
import model.ParcelSize;
import model.Person;
import java.time.LocalDateTime;

public class MainService {
	private static ArrayList<Driver> allDrivers = new ArrayList<Driver>();
	private static ArrayList<AbstractCustomer> allCustomers = new ArrayList<AbstractCustomer>();
	private static ArrayList<Parcel> allParcels = new ArrayList<Parcel>();
	public static void main(String[] args) {
		
		Driver dr1 = new Driver();
		Driver dr2 = new Driver("Igors", "Goncarovs", "123456-09876", "Aboba", 4);
		Driver dr3 = new Driver("Ryan", "Gosling", "121298-67894", "Xyz", 54);
		Driver dr4 = new Driver("John", "Blaze", "430722-41016","Ghost", 66);
		allDrivers.addAll(Arrays.asList(dr1, dr2, dr3, dr4));
		for (Driver tempD : allDrivers) {
			System.out.println(tempD.toString());	
		}
		
		Address a1 = new Address();
		Address a2 = new Address(City.Riga, "Targales", 41);
		Address a3 = new Address(City.Riga, "Lieapajas", 54);
		Address a4 = new Address(City.Daugavpils, "Saules", 76);
		
		
		Parcel p1 = new Parcel();
		Parcel p2 = new Parcel(LocalDateTime.of(2024, 04, 24, 14, 33, 48, 123456789),  ParcelSize.M, false , dr1);
		Parcel p3 = new Parcel(LocalDateTime.of(2024, 05, 24, 14, 33, 48, 123456789),  ParcelSize.L, true , dr2);
		Parcel p4 = new Parcel(LocalDateTime.of(2024, 05, 20, 14, 33, 48, 123456789),  ParcelSize.X, true , dr2);
		Parcel p5 = new Parcel(LocalDateTime.of(2024, 05, 18, 14, 33, 48, 123456789),  ParcelSize.XL, false , dr3);
		allParcels.addAll(Arrays.asList(p1, p2, p3, p4,  p5));
		for(Parcel tempP : allParcels) {
			System.out.println(tempP.toString());
		}
		
		
		
		CustomerAsCompany c1 = new CustomerAsCompany();
		CustomerAsCompany c2 = new CustomerAsCompany(a1, "63628303", "Ventspils Augstskola", "321904512" );
		CustomerAsPerson c3 = new CustomerAsPerson("Anton", "Volkov", "437202-41016", a4, "23374110");
		allCustomers.addAll(Arrays.asList(c1, c2, c3));
		for(AbstractCustomer tempC : allCustomers) {
			System.out.println(tempC.toString());
		}
		System.out.println(p5.getPrice());
		System.out.println(p5.getDriver());
		System.out.println(p5.getOrderCreated());
		System.out.println(p5.getPlannedDelivery());
		System.out.println(p5.getSize());
		p5.setPlannedDelivery(LocalDateTime.of(2024, 05, 18, 14, 33, 48, 123456789));
		p5.setOrderCreated();
		p5.setFragile(true);
		p5.setDriver(dr2);
		p5.setSize(ParcelSize.L);
		System.out.println(p5.getPlannedDelivery());
		System.out.println(p5.getOrderCreated());
		System.out.println(p5.getDriver());
		System.out.println(p5.isFragile());
		System.out.println(p5.getSize());
		System.out.println(p5.toString());
		
		
		retrieveAllParcels();
		try {
			createNewParcelForCustomer(LocalDateTime.of(2024, 05, 18, 14, 33, 48, 123456789), ParcelSize.M, false, dr1, c3.getCustomerCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Parcel tempP : allParcels) {
			System.out.println(tempP.toString());
		}
		
	}
	
	//Driver functions
	
	
	public static void createNewDriver(String name, String surname, String personCode, String licenseNo, float experienceInYears) throws Exception {
	    if(name == null || surname == null || personCode == null || licenseNo == null || experienceInYears > 80 ) throw new Exception("Invalid input");

	    ArrayList<Driver> allDrivers2 = new ArrayList<>();

	    for(Driver tempD : allDrivers) {
	        if(tempD.getLicenseNo().equals(licenseNo) && tempD.getPersonCode().equals(personCode)) {
	            System.out.println("This driver's license number and person code are already in the system");
	            return;
	        }
	    }

	    Driver newDriver = new Driver(name, surname, personCode, licenseNo, experienceInYears);
	    allDrivers2.add(newDriver);

	    allDrivers.addAll(allDrivers2);
	}
	
	public static Driver retrieveDriverByPersonCode(String personCode) throws Exception {
		if(personCode == null) throw new Exception("Invalid person code");
		for(Driver tempD : allDrivers) {
			if(tempD.getPersonCode() == personCode) {
				return tempD;
			}
		}
		throw new Exception("No driver with this person code found in the system");
	}
	
	public static void updateDriverLicenseByPersonCode(String personCode, String licenseNo) throws Exception {
		if(personCode == null && licenseNo == null) throw new Exception ("Invalid input");
		for(Driver tempD : allDrivers) {
			if(tempD.getPersonCode() == personCode) {
				tempD.setLicenseNo(licenseNo);
				return;
			}
		}
	}
	
	public static void updateDriverExperienceInYearsByPersonCode(String personCode, float experienceInYears) throws Exception {
	    if(personCode == null || experienceInYears > 80) throw new Exception ("Invalid input");

	    for(Driver tempD : allDrivers) {
	        if(tempD.getPersonCode().equals(personCode)) {
	            tempD.setExperienceInYears(experienceInYears);
	            return;
	        }
	    }
	    throw new Exception("No driver with this person code found in the system");
	}
	
	public static void removeDriverByPersonCode(String personCode) throws Exception {
		if(personCode == null ) throw new Exception ("Invalid input");
		for(Driver tempD : allDrivers) {
			if(tempD.getPersonCode() == personCode) {
				allDrivers.remove(tempD);
				return;
			}
		}
	}
	
	
	// Customer as company functions
	
	
	public static void createNewCustomerAsCompany(Address address, String phone, String title, String companyRegNo) throws Exception{
		if(phone == null || title == null || companyRegNo == null) throw new Exception ("Invalid Input");
		for(AbstractCustomer tempC : allCustomers) {
			if(tempC instanceof CustomerAsCompany) {
				if(companyRegNo == ((CustomerAsCompany) tempC).getCompanyRegNo()) throw new Exception("This company is alredy in the system");
				CustomerAsCompany newCompany = new CustomerAsCompany(address, phone, title, companyRegNo);
				return;
			}
		}
		
	}
	
	public static ArrayList<CustomerAsCompany> retrieveAllCustomersAsCompany(){
		ArrayList<CustomerAsCompany> allCompanies = new ArrayList<CustomerAsCompany>();
		for(AbstractCustomer tempC : allCustomers) {
			if(tempC instanceof CustomerAsCompany) {
				allCompanies.add((CustomerAsCompany) tempC);
			}
		}
		return allCompanies;
	}
	
	
	// Customer as person functions
	
	
	public static void createNewCustomerAsPerson(String name, String surname, String personCode, Address address, String phone) throws Exception{
		if(phone == null || name == null || surname == null || personCode == null || address == null ) throw new Exception ("Invalid Input");
		for(AbstractCustomer tempC : allCustomers) {
			if(tempC.getPhoneNo() == phone && tempC.getAddress() == address) throw new Exception("This customer is alredy in the system");
			
			CustomerAsPerson newCustomer = new CustomerAsPerson(name, surname, personCode, address, phone);
			return;
			}
		}
	
	public static ArrayList <CustomerAsPerson> retrieveAllCustomersAsPerson(){
		ArrayList<CustomerAsPerson> allPersons = new ArrayList<CustomerAsPerson>();
		for(AbstractCustomer tempC : allPersons) {
			if(tempC instanceof AbstractCustomerAsPerson) {
				if(tempC instanceof CustomerAsPerson) {
					allPersons.add((CustomerAsPerson) tempC);
				}
			}
		}
		return allPersons;
	}
	
	
	// Parcel functions
	
	

	public static void retrieveAllParcels() {  // Not required but necessary for retrieve functions
		for(AbstractCustomer tempC : allCustomers) {
			allParcels.addAll(tempC.getParcels());
		}
	}
	
	
	public static void createNewParcelForCustomer(LocalDateTime plannedDelivery, ParcelSize size, boolean isFragile, Driver driver, String customerCode) throws Exception {
		if(plannedDelivery == null || size == null || driver == null || customerCode == null) throw new Exception("Invalid input");
		for(AbstractCustomer tempC : allCustomers) {
			if(tempC.getCustomerCode() == customerCode) {
				Parcel customersParcel = new Parcel(plannedDelivery, size, isFragile, driver);
			}
			else
			{
				System.out.println("No customer with such code registred in the system");
			}
		}
	}

	
	public static ArrayList<Parcel> retrieveALlParcelsByCustomerCode(String customerCode) throws Exception{
		if(customerCode == null) throw new Exception("Invalid input");
		ArrayList<Parcel> allParcelsByCustomersnCode = new ArrayList<Parcel>();
		for(AbstractCustomer tempC : allCustomers) {
			if(tempC.getCustomerCode() == customerCode) {
				allParcelsByCustomersnCode.addAll(tempC.getParcels());
			}
		}
		return allParcelsByCustomersnCode;
	}
	
	public static ArrayList<Parcel> retrieveAllParcelsbyDriverPersonCode(String personCode) throws Exception{
		if(personCode == null) throw new Exception("Invalid input");
		ArrayList<Parcel> allParcelsByPersonCode = new ArrayList<Parcel>();
		for(Parcel tempP : allParcels) {
			if(tempP.getDriver().getPersonCode() == personCode) {
				allParcelsByPersonCode.add(tempP);
			}
		}
		return allParcelsByPersonCode;
	}
	
	public static ArrayList<Parcel> rertrieveAllParcelsByCity(City city) throws Exception{
		if(city == null) throw new Exception("Invalid input");
		ArrayList<Parcel> allParcelsByCity = new ArrayList<Parcel>();
		for(AbstractCustomer tempC : allCustomers) {
			if(tempC.getAddress().getCity() == city) {
				allParcelsByCity.addAll(tempC.getParcels());
			}
		}
		return allParcelsByCity;
	}
	
	public static ArrayList<Parcel> rertrieveAllParcelsBySize(ParcelSize size) throws Exception{
		if(size == null) throw new Exception("Invalid input");
		ArrayList<Parcel> allParcelsBySize = new ArrayList<Parcel>();
		for(Parcel tempP : allParcels) {
			if(tempP.getSize() == size) {
				allParcelsBySize.add(tempP);
			}
		}
		return allParcelsBySize;
	}
	
	public static float calculatePriceOfAllCustomerParcelsByCustomerCode(String customerCode) throws Exception{
		if(customerCode == null) throw new Exception("Invalid input");
		float totalPrice = 0;
		for(Parcel tempP : retrieveALlParcelsByCustomerCode(customerCode)) {
			totalPrice += tempP.getPrice();
		}
		return totalPrice;
	}
	
	public static int[] retrieveStatisticsOfCustomerParcelSize(String customerCode) throws Exception{
		if(customerCode == null) throw new Exception("Invalid input");
		int[] parcelSizeStatistics = {0,0,0,0,0};
		for(AbstractCustomer tempC : allCustomers) {
			if(customerCode == tempC.getCustomerCode()) {
				for(int i = 0; i < parcelSizeStatistics.length; i ++) {
					for(Parcel tempP : retrieveALlParcelsByCustomerCode(customerCode)) {
						for(ParcelSize tempSize : ParcelSize.values()) {
							if(tempP.getSize() == ParcelSize.X) {		
								parcelSizeStatistics[i] += 1;
							}
						}
					}
				}
			}
		}
		return parcelSizeStatistics;
	}
		
	
	
	// Other functions
	
	public static void sortDriversByExperience(){
		ArrayList<Float> driversByExperience = new ArrayList<Float>();
		for(Driver tempD : allDrivers) {
			driversByExperience.add(tempD.getExperienceInYears());
		}
		driversByExperience.sort(null);
		for(Driver tempD : allDrivers) {
			for(int i = 0; i < driversByExperience.size(); i ++) {
				if(tempD.getExperienceInYears() == driversByExperience.get(i)) {
					System.out.println(tempD.toString());
				}
			}	
		}
	}
	
	
}

