package uk.gov.hmrc.checkout;

import java.util.List;

import uk.gov.hmrc.items.Apple;
import uk.gov.hmrc.items.FruitInterface;
import uk.gov.hmrc.items.Orange;
import uk.gov.hmrc.promos.ApplePromo;
import uk.gov.hmrc.promos.OrangePromo;

public class FruitScanner implements CheckoutInterface<FruitInterface>{
	
	ApplePromo applePromo = new ApplePromo();
	OrangePromo orangePromo = new OrangePromo();

	@Override
	public int getTotal(List<? extends FruitInterface> items) {
		int total = 0;
		for (FruitInterface f : items){
			total += applyAnyDiscounts(f);
		}
		return total;
	}

	private int applyAnyDiscounts(FruitInterface f) {
		int price = 0;
		if (f instanceof Apple){
			price = applePromo.getPrice((Apple)f);
		} else if (f instanceof Orange){
			price = orangePromo.getPrice((Orange)f);
		}
		return price;
	}
}
