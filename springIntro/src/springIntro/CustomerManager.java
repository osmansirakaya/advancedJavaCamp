package springIntro;

public class CustomerManager {
	private ICustomerDal customerDal;
	
	public CustomerManager(ICustomerDal customerDal) { // referans type olduğu için ICustomerDal'ı implemente eden herkesi parametere olarak gönderebiliriz.
		this.customerDal = customerDal;
	}
	public void add() {
		// iş kuralları
		customerDal.add();
	}

}
