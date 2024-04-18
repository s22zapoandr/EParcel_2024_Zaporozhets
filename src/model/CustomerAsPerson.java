package model;

public class CustomerAsPerson extends AbstractCustomerAsPerson{
	@Override
	public void setCustomerCode() {
		this.customerCode = (String) (cID + "_person_" + person.getPersonCode());
	}
	
	public CustomerAsPerson() {
		person.setName("John");
		person.setSurname("Smith");
		person.setPersonCode("1234567890");
	}
	
	public CustomerAsPerson(String name, String surname, String personCode ) {
		person.setName(name);
		person.setSurname(surname);
		person.setPersonCode(personCode);
	}
	
	public String toString() {
		return super.toString() + person.toString() + super.getCustomerCode();
	}
}

