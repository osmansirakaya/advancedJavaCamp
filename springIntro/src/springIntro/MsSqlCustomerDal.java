package springIntro;

public class MsSqlCustomerDal implements ICustomerDal{
String connectiString;
	
	public String getConnectiString() {
		return connectiString;
	}

	public void setConnectiString(String connectiString) {
		this.connectiString = connectiString;
	}


	@Override
	public void add() {
		System.out.println("connection string: "+this.connectiString);
		System.out.println("ms sql veri tabanına eklendi");
		
	}

}
