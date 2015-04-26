package org.gujavasc.jobs;

import java.util.Date;

import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class UserJob {

	@Schedule(persistent = false, hour = "*", minute = "*", second = "*/20")
	public void schedule(){
		System.out.println("Checking status: " + new Date());
	}
	
}
