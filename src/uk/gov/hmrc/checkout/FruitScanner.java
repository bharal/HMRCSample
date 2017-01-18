package uk.gov.hmrc.checkout;

import java.util.List;

import uk.gov.hmrc.items.FruitInterface;

public class FruitScanner implements CheckoutInterface<FruitInterface>{

	@Override
	public int getTotal(List<? extends FruitInterface> items) {
		int total = 0;
		for (FruitInterface f : items){
			total += f.getPrice();
		}
		return total;
	}

}
