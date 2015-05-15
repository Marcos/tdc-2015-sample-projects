package org.gujavasc.j8;

import static java.math.BigDecimal.valueOf;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class TotalServiceTest {

	private TotalService saleService = new TotalService();
	
	@Test
	public void totalItems() {
		Item firstItem = Item.builder()
				.quantity(valueOf(3))
				.value(valueOf(15))
				.build();
		
		Item secondItem = Item.builder()
				.quantity(valueOf(3))
				.value(valueOf(12))
				.build();
		
		
		BigDecimal total = saleService.totalItems(asList(firstItem, secondItem));
		assertThat(total, comparesEqualTo(valueOf(81)));
		
		BigDecimal total8 = saleService.totalItems8(asList(firstItem, secondItem));
		assertThat(total8, comparesEqualTo(valueOf(81)));
	}
	

}
