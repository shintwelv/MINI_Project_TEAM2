package com.developer.forum;

public class createRecord {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println("insert into board_free values(idx_seq.nextval, 'myId', '" + "title" + i +"', '" + "content" + i + "', sysdate, 0);");
			System.out.println("insert into board_job values(idx_seq.nextval, 'myId', '" + "title" + i +"', '" + "content" + i + "', sysdate, 0);");
			System.out.println("insert into board_news values(idx_seq.nextval, 'myId', '" + "title" + i +"', '" + "content" + i + "', sysdate, 0);");
			System.out.println("insert into board_qna values(idx_seq.nextval, 'myId', '" + "title" + i +"', '" + "content" + i + "', sysdate, 0);");
			System.out.println("insert into board_tip values(idx_seq.nextval, 'myId', '" + "title" + i +"', '" + "content" + i + "', sysdate, 0);");
		}
	}
}
