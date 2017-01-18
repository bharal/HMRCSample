package uk.gov.hmrc;

import java.util.LinkedList;
import java.util.List;

import uk.gov.hmrc.checkout.FruitScanner;
import uk.gov.hmrc.items.Apple;
import uk.gov.hmrc.items.FruitInterface;
import uk.gov.hmrc.items.Orange;

public class DemoRun {
	
	public static void main(String[] args){
		if (args.length < 1){
			System.err.println("Please enter the names of some fruit to scan");
		}
		List<FruitInterface> items = new LinkedList<>();
		for (String item : args){
			switch(item.toLowerCase()){
				case "apple": {
					items.add(new Apple());
					break;
				}
				case "orange": {
					items.add(new Orange());
					break;
				}
			}
		}
		FruitScanner fs = new FruitScanner();
		int total = fs.getTotal(items);
		System.out.println("The total bill is " + total + " pence");
	}

}
