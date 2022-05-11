package com.javaex.phonebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBookApp {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		System.out.println("**********************");
		System.out.println("*  전화번호 관리 프로그램  *");
		System.out.println("**********************");
		System.out.println();

		List<Person> personList = new ArrayList<Person>();
		// 읽기
		Reader fr = new FileReader("./PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);

		while (true) {

			String str = br.readLine();

			if (str == null) {
				break;
			
			}
			String[] personInfo = str.split(",");

			String name = personInfo[0];
			String hp = personInfo[1];
			String company = personInfo[2];

			Person person = new Person(name, hp, company);

			personList.add(person);
			
			}
			boolean flag = true;
			
			while (flag) {

			System.out.println();
			System.out.println("1.리스트   2.등록   3.삭제   4.검색   5.종료");
			System.out.println("----------------------------------------------");
			System.out.print(">메뉴번호: ");
			int num = sc.nextInt();
			
			
			
			//메뉴
			
			
			FileWriter fw;
			switch (num) {
			case 1: //리스트출력
				System.out.println();
				System.out.println("<1.리스트>");
				System.out.println();
				
				for (Person p:personList) {
					System.out.println(".   "+p.getName()+"   "+p.getHp()+"  "+p.getCompany());
					
				}
				break;
			case 2://등록
				System.out.println("<2.등록>");
				sc.nextLine();
				System.out.print(">이름: ");
				String name = sc.nextLine();
				System.out.print(">휴대전화: ");
				String hp = sc.nextLine();
				System.out.print(">회사전화: ");
				String company = sc.nextLine();
				//리스트에추가
				
				Person person = new Person();
				person.setName(name);
				person.setHp(hp);
				person.setCompany(company);
				
				personList.add(person);
				
				//파일에 저장
				fw = new FileWriter("./phoneDB.txt");
				BufferedWriter bw = new BufferedWriter(fw);
					
				for (int i = 0; i < personList.size(); i++) {
					String str = personList.get(i).getName() + "," + personList.get(i).getHp() + "," + personList.get(i).getCompany();
					bw.write(str);
					bw.newLine();
				}
				bw.flush();
				bw.close();
				
				System.out.println("등록되었습니다.");
				
				break;
			case 3://삭제
				
				
				break;
			
			case 4://검색
				
				break;
				
				
			case 5://종료
				System.out.println("**********************");
				System.out.println("*   감사합니다   *");
				System.out.println("**********************");
				flag = false;
				break;
				
				
			default://없는메뉴선택햇을때
				System.out.println("다시 입력해 주세요");
				break;
			}
			

		}

		br.close();
		sc.close();
		
		
	}
}