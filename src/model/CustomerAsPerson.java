package model;

public class CustomerAsPerson extends AbstractCustomerAsPerson{
	@Override
	public void setCustomerCode() {
		customerCode = (String) (cID + "_person_" + super.person.personCode);
	}
	
	public CustomerAsPerson() {
		person.setName("John");
		person.setSurname("Smith");
		person.setPersonCode("1234567890");
		setCustomerCode();
		setPhoneNo("000000000");
	}
	
	public CustomerAsPerson(String name, String surname, String personCode, Address address, String phoneNumber) {
		person.setName(name);
		person.setSurname(surname);
		person.setPersonCode(personCode);
		setCustomerCode();
		setAddress(address);
		setPhoneNo(phoneNumber);
	}
	
	public String toString() {
		return super.toString() +", name: "+ person.toString();
	}
}

