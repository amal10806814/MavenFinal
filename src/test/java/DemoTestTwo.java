import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTestTwo {

    @Test
    public void sum()
    {
        System.out.println("SUM");
        int a = 10 ;
        int b = 20 ;
        Assert.assertEquals(30 , b+a);
    }

    @Test
    public void minus()
    {
        System.out.println("SUB");
        int a = 10 ;
        int b = 20 ;
        Assert.assertEquals(10 , b-a);
    }
    @Test
    public void multiply()
    {
        System.out.println("MUL");
        int a = 10 ;
        int b = 20 ;
        Assert.assertEquals(200 , b*a);
    }


    @Test
    public void divide()
    {
        System.out.println("DIV");
        int a = 10 ;
        int b = 20 ;
        Assert.assertEquals(2 , b/a);
    }
}
