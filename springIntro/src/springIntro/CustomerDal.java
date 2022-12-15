package springIntro;

public class CustomerDal implements ICustomerDal{
	String connectiString;
	
	public String getConnectiString() {
		return connectiString;
	}

	public void setConnectiString(String connectiString) {
		this.connectiString = connectiString;
	}

	public void add() {
		System.out.println("connection string: "+this.connectiString);
		System.out.println("oracle veri tabanına eklendi");		
	}
}
