package com.arc.s4.transfer;

import org.springframework.stereotype.Component;

@Component
public class Transfer { //join point

	public void car() {
		System.out.println("---- MyCar ----");
		System.out.println("�����ϱ�");
		System.out.println("---- MyCar ----");
	}
	
	public void taxi() {
		System.out.println("---- Taxi ----");
		System.out.println("���԰� ��ȭ�ϱ�");
		System.out.println("---- Taxi ----");
	}
	
	public void getBus(String cardName) { //point cut
		System.out.println("---- Bus ----");
		System.out.println("���� ���");
		System.out.println("---- Bus ----");
	}
	
	public void getSubway(String cardName) { //point cut
		System.out.println("---- Subway ----");
		System.out.println("�ڵ��� ����");
		System.out.println("---- Subway ----");
	}
}
