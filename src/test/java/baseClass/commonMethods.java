package baseClass;

import java.util.Calendar;

public class commonMethods {
	
public static Calendar selectCheckindate() {
		
	 Calendar calendar= Calendar.getInstance();
	 calendar.add(Calendar.MONTH, 3);	
	 return calendar;
	}

public static Calendar selectCheckoutdate() {
	
	 Calendar calendar =selectCheckindate();
	 calendar.add(Calendar.DATE,1);
	 return calendar;
	}
}
