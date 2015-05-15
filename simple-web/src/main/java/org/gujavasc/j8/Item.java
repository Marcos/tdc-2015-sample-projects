package org.gujavasc.j8;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Item {

	private BigDecimal quantity;
	private BigDecimal value;
	private BigDecimal shipping;
	
}
