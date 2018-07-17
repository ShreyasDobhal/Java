import java.util.regex.*;
class Regex
{
    public static void main(String args[])
    {
        String txt1="search for";//"shreyas@gmail.com";
        String txt2="searching";
        String reg="^[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}$";
        Pattern pattern = Pattern.compile(reg);
        
        //Matcher regex = pattern.matcher(txt1);
        if (!pattern.matcher(txt1).matches())
            System.out.println(txt1+" is Invalid email");
        else
            System.out.println(txt1+" is Valid email");   
        if (!pattern.matcher(txt2).matches())
            System.out.println(txt2+" is Invalid email");
        else
            System.out.println(txt2+" is Valid email"); 
    }
}