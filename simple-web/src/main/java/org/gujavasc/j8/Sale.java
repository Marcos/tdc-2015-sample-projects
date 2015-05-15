package org.gujavasc.j8;

import java.math.BigDecimal;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Sale {
	
	private List<Item> items;
	private BigDecimal total;
	private BigDecimal totalShipping;

}
