package org.gujavasc.j8;

import static java.math.BigDecimal.ZERO;
import static java.util.stream.Collectors.reducing;

import java.math.BigDecimal;
import java.util.List;

public class TotalService {

	public BigDecimal totalItems8(List<Item> items) {
		return items.stream()
				.collect(reducing(ZERO, 
						item->item.getQuantity().multiply(item.getValue()), 
						BigDecimal::add));
	}
	
	public BigDecimal totalItems(List<Item> items) {
		BigDecimal total = ZERO;
		for(Item item : items)
			total = total.add(item.getQuantity().multiply(item.getValue()));
		return total;
	}

	
}
