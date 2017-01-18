package uk.gov.hmrc.promos;

import uk.gov.hmrc.items.Orange;

public class OrangePromo implements Promos<Orange> {
	
	int numberOranges = 0;

	@Override
	public int getPrice(Orange t) {
		if (++numberOranges == 3){
			numberOranges = 0;
			System.out.println("3 for 2 oranges!");
			return 0;
		}
		return t.getPrice();
	}

}
