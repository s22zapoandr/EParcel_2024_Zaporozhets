package model;

public class Driver extends Person {
	private long dID;
	private float experienceInYears;
	private String licenseNo;
	private static long counter = 0;
	
	public long getdID() {
		return dID;
	}
	public void setdID() {
		this.dID = counter;
		counter++;
	}
	public float getExperienceInYears() {
		return experienceInYears;
	}
	public void setExperienceInYears(float experienceInYears) {
		if(experienceInYears > 0 && experienceInYears < 100) {
			this.experienceInYears = experienceInYears;
		}
		else {
		System.out.println("Invalid input");
		}
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		if(licenseNo  != null && licenseNo.matches("[A-Z]{1}[a-z]{1,20}")) {
			this.licenseNo = licenseNo;
		}
		else {
			System.out.println("Invalid input");
		}
	}
	
	public Driver() {
		super();
		setdID();
		setExperienceInYears(10);
		setLicenseNo("Default");
	}
	
	public Driver(String name, String surname, String personCode, String licenseNo, float experienceInYears) {
		setName(name);
		setSurname(surname);
		setPersonCode(personCode);
		setLicenseNo(licenseNo);
		setExperienceInYears(experienceInYears);
	}
	
	public String toString() {
		return super.toString() + licenseNo + " " + experienceInYears;
	}
	
}
