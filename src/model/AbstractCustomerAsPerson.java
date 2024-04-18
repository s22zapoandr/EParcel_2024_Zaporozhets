package model;

public abstract class AbstractCustomerAsPerson extends AbstractCustomer{
	public Person person;
	
	public AbstractCustomerAsPerson(){
		this.person.setName("John");
		person.setSurname("Smith");
		person.setPersonCode("1234567890");
	}
	
	public AbstractCustomerAsPerson(String name, String surname, String personCode ) {
		person.setName(name);
		person.setSurname(surname);
		person.setPersonCode(personCode);
	}
	
	public String toString() {
		return person.toString();
	}
}
