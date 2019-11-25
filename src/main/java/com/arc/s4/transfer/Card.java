package com.arc.s4.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Card {
	
	@After("execution(* com.arc.s4.transfer.Transfer.taxi())")
	public void cash() {
		System.out.println("==== ���� ���� ====");
	}
	
	@Around("execution(* com.arc.s4.transfer.Transfer.get*(..))")
	public Object cardCheck(ProceedingJoinPoint join) {
		System.out.println("==== ������ ī�� ��� ====");
		Object obj = null;
		try {
			Object [] args = join.getArgs();
			for(Object object:args) {
				System.out.println(object);
			}
			obj = join.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("==== ������ ī�� ��� ====");
		
		return obj;
	}
}
