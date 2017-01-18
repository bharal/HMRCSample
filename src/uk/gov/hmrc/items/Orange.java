package uk.gov.hmrc.items;

public class Orange implements FruitInterface {

	private static int PRICE = 25;
	
	@Override
	public int getPrice() {
		return PRICE;
	}

}
