package board03;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateEx {
	public static void main(String[] args) {
		//Date d = new Date(); >>����
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� HH:mm:ss");
		System.out.println(sdf.format(c.getTime()));
		c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR)+ 3);
		System.out.println(sdf.format(c.getTime()));
		
		
		Date d = new Date(c.getTimeInMillis()); //SQL���� �����ִ� �ð� �ڵ�~~
	}

}
