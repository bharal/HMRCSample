package uk.gov.hmrc;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
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
	
	private List<? extends FruitInterface> makeList(FruitInterface f, int numberFruits){
		List<FruitInterface> items = new LinkedList<>();
		for (int i = 0; i < numberFruits; i++){
			items.add(f);
		}
		return items;
	}
	
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
	public void testTwoApples(){
		assertEquals(apple.getPrice(), checkout.getTotal(makeList(new Apple(), 2)));
		
	}
	
	@Test
	public void testThreeApples(){
		assertEquals(apple.getPrice()*2, 
				checkout.getTotal(makeList(new Apple(), 3)));
	}
	
	@Test
	public void testFourApples(){
		assertEquals(apple.getPrice()*2, 
				checkout.getTotal(makeList(new Apple(), 4)));
	}
	
	@Test
	public void testTwoOranges(){
		assertEquals(orange.getPrice()*2, 
				checkout.getTotal(makeList(new Orange(), 2)));
	}
	
	@Test
	public void testThreeOranges(){
		assertEquals(orange.getPrice()*2, 
				checkout.getTotal(makeList(new Orange(), 3)));
	}
	
	@Test
	public void testSixOranges(){
		assertEquals(orange.getPrice()*4, 
				checkout.getTotal(makeList(new Orange(), 6)));
	}
	
	@Test
	public void testThreeApplesFourOranges(){
		assertEquals(apple.getPrice()*2+orange.getPrice()*3,
				checkout.getTotal(
						Stream.concat(makeList(new Apple(), 3).stream(), makeList(new Orange(), 4).stream())
						.collect(Collectors.toList())));
	}
	
	@Test
	public void testNoItems(){
		assertEquals(0, 
				checkout.getTotal(new LinkedList<>()));
		
	}
}
