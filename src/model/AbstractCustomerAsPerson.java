package model;

public abstract class AbstractCustomerAsPerson extends AbstractCustomer{
	public Person person;
	
	public AbstractCustomerAsPerson(){
		this.person = new Person();
	}
	
	public AbstractCustomerAsPerson(String name, String surname, String personCode ) {
		person.setName(name);
		person.setSurname(surname);
		person.setPersonCode(personCode);
	}
	
	public String toString() {
		return super.toString();
	}
}
