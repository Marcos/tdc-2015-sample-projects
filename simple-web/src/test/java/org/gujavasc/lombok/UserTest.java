package org.gujavasc.lombok;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class UserTest {

	@Test
	public void testBuilder(){
		User user = User.builder()
						.age(25)
						.email("marcos.wp@gmail.com")
						.name("Marcos")
						.build();
		
		assertThat(user.getEmail(), equalTo("marcos.wp@gmail.com"));
		assertThat(user.getAge(), equalTo(25));
		assertThat(user.getName(), equalTo("Marcos"));
	}
	
}
