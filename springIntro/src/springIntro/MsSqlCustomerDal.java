package springIntro;

public class MsSqlCustomerDal implements ICustomerDal{

	@Override
	public void add() {
		System.out.println("ms sql veri tabanına eklendi");
		
	}

}
