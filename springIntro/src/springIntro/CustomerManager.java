package springIntro;

public class CustomerManager implements ICustomerService{
	
	private ICustomerDal customerDal;
	// setter injection 
	public void setCustomerDal(ICustomerDal customerDal) {
		this.customerDal = customerDal;
	}
	// constructor injection (daha çok kullanılır)
	//public CustomerManager(ICustomerDal customerDal) { // referans type olduğu için ICustomerDal'ı implemente eden herkesi parametere olarak gönderebiliriz.
	//	this.customerDal = customerDal;
	//}
	public void add() {
		// iş kuralları
		customerDal.add();
	}
}
