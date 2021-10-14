package com.developer.forum;

public class createRecord {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println("insert into board_job values(idx_seq.nextval, 'myId', '" + "title" + i +"', '" + "content" + i + "', sysdate, 0);");
		}
	}
}
