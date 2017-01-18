package uk.gov.hmrc.promos;

import uk.gov.hmrc.items.Apple;

public class ApplePromo implements Promos<Apple>{
	
	int numberApples = 0;

	@Override
	public int getPrice(Apple t) {
		if (++numberApples == 2){
			numberApples = 0;
			System.out.println("Free apple!");
			return 0;
		};
		return t.getPrice();
	}

}
