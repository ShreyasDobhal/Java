import java.util.Calendar;
import java.text.SimpleDateFormat;

public class DateUtils
{
    public static final 
    public static String now()
    {
        String DATE_FORMAT_NOW="hh:mm dd-MM-yyyy";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());
    }
    public static void main(String args[])
    {
        System.out.println("Now : "+now());
    }
}