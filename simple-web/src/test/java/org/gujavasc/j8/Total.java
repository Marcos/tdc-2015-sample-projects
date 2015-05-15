package org.gujavasc.j8;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Total {
	
	private BigDecimal totalItems;
	private BigDecimal totalShipping;

}
