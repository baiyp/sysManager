package org.demo;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "SELECT p.work_unit,p.full_name as full_name,p.id_number as id_number,p.sex,p.email,p.diploma,p.graduate_institutions,p.profession,a.* FROM ACCOUNT a FROM LEFT JOIN personal p on a.id = p.account_id where a.user_type=0  and a.user_level=0 limit 0,1";

		int lastIndex = str.lastIndexOf("limit");
		
		
		int beginIndex = str.indexOf("FROM");
		
		System.out.println(str.substring(beginIndex,lastIndex-1));
		
	}

}
