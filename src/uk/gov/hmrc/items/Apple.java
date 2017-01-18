package uk.gov.hmrc.items;

public class Apple implements FruitInterface{
	
	private static int PRICE = 60;

	@Override
	public int getPrice() {
		return PRICE;
	}

}
