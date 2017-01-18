package uk.gov.hmrc;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import uk.gov.hmrc.checkout.CheckoutInterface;
import uk.gov.hmrc.checkout.FruitScanner;
import uk.gov.hmrc.items.Apple;
import uk.gov.hmrc.items.FruitInterface;
import uk.gov.hmrc.items.Orange;

public class CheckoutTest {
	
	CheckoutInterface<FruitInterface> checkout;
	Apple apple;
	Orange orange;
	
	@Before
	public void setup(){
		checkout = new FruitScanner();
		apple = new Apple();
	 	orange = new Orange();
	}
	
	@Test
	public void testSingleItem(){
		Apple apple = new Apple();
		assertEquals(apple.getPrice(), 
				checkout.getTotal(Stream.of(new Apple()).collect(Collectors.toList())));
	}
	
	@Test
	public void testTwoDifferentItems(){
		assertEquals(apple.getPrice()+orange.getPrice(), 
				checkout.getTotal(Stream.of(new Apple(), new Orange()).collect(Collectors.toList())));
		
	}
	
	@Test
	public void testNoItems(){
		assertEquals(0, 
				checkout.getTotal(new LinkedList<>()));
		
	}
}
