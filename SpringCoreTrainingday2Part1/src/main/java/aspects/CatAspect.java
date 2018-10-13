package aspects;

import beans.Dog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CatAspect {

    @Autowired
    private Dog dog;
/*    @Before("execution(* beans.Cat.sayMeow(..))")
    public void beforeMeow(){
        System.out.println("Purr,purr");
    }
    @After("execution(* beans.Cat.sayMeow(..))")
    public void afterMeow()
    {
        System.out.println("Mrr,mrr");
    }*/
    /*@Around("execution(* beans.Cat.sayMeow(..))")
    public void aroundMeow(ProceedingJoinPoint proceedingJoinPoint) //Proceeding Join point este metoda pe care o imbracam in aspect
    {

        System.out.println("Aspect called");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }*/
@Around("execution(* beans.Cat.sayMeow(..))")//modul in care aspectele se leaga de codul aspectat se numeste weaving-Spring AOP se face
                                            // la RunTime
public void aroundMeow(ProceedingJoinPoint proceedingJoinPoint) //Proceeding Join point este metoda pe care o imbracam in aspect
{

    try {
        proceedingJoinPoint.proceed();
    } catch (Throwable throwable) {
        throwable.printStackTrace();
    }
    dog.sayHam();
}

}
