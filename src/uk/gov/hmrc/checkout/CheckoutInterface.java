package uk.gov.hmrc.checkout;

import java.util.List;

public interface CheckoutInterface<T> {
	
	public abstract int getTotal(List<? extends T> items);

}
