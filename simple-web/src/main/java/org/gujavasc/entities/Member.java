package org.gujavasc.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Member {
	
	@Id
	private Long id;
	private String name;

}
