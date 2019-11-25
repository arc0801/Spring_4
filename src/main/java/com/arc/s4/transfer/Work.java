package com.arc.s4.transfer;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component
public class Work {
	
	@Inject
	private Transfer transfer;
	
	public void goTaxi() {
		transfer.taxi();
	}
	
	public void goWork() {
		transfer.getBus("Samsung");
		transfer.getSubway("Kakao");
	}
}
