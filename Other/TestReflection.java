import java.lang.reflect.Method;
class TestReflection
{
    public static void main()
    {
        Class reflect = Math.class;
        String className = reflect.getName();
        System.out.println(className);
        Method[] classMethods = reflect.getMethods();
        int i=0;
        for (Method method:classMethods) {
            System.out.print(i+") Math."+method.getName()+" ");
            Class[] para = method.getParameterTypes();
            for (Class p:para)
                System.out.print(p+" ");
            System.out.println();
            i++;
        }
        
        try {
            double ans=(double)classMethods[29].invoke(null,1);
            System.out.println(ans);
        } catch (Exception e) {
            System.out.println("Error");
        }
        
    }
}