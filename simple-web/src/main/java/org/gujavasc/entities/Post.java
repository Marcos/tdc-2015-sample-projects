package org.gujavasc.entities;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.AUTO;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.mysema.query.annotations.QueryProjection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
	
	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;
	@ManyToOne(fetch=LAZY)
	private Member member;
	private Date date;
	private String title;
	private String content;
	private Status status;
	
	@QueryProjection
	public Post(String member, String title, String content){
		this.member = Member.builder().name(member).build();
		this.title = title;
		this.content = content;
	}

}
