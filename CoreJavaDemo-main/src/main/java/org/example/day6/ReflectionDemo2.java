package org.example.day6;

import java.beans.BeanProperty;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionDemo2 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RunningTestInstance2 obj = new RunningTestInstance2();
        Class cls = obj.getClass();
//        System.out.println("The class name: " + cls.getName());
//        Constructor constructor=cls.getConstructor();
//        System.out.println("the constructor name: " + constructor.getName());
//        Method[] methods = cls.getMethods();
        // get the method from RunningTestInstance2 class including the method from object class
//        System.out.println(Arrays.toString(methods));
//        for(Method method:methods){
//            System.out.println(method);     // most methods come from object class
//        }
//
//        System.out.println("-------------------------------------------------");
        // get the method from RunningTestInstance2 class
//        Method[] methods2 = cls.getDeclaredMethods();
//        for(Method method:methods2){
//            System.out.println(method);     // most methods come from object class
//        }
        obj.method2(2);
        // change the value in method 2, modify the code in running time
        Method reflectMethod2 = cls.getDeclaredMethod("method2", int.class);
        reflectMethod2.invoke(obj,19);

        // change the private method can be accessed
        Method reflectMethod3 = cls.getDeclaredMethod("method3");
        reflectMethod3.setAccessible(true);
        reflectMethod3.invoke(obj);

//        RunningTestInstance2 obj = new RunningTestInstance2();
//        Class cls = obj.getClass();
        // same as above
        Class testClass=RunningTestInstance2.class;
        Method reflectMethod4 = testClass.getDeclaredMethod("method4");
        // get annotation from method
        Annotation[] classAnnotations = reflectMethod4.getAnnotations();
        for (Annotation annotation : classAnnotations) {
            System.out.println(annotation.annotationType());
        }

        /*
        *   if you detect the annotation1, do logic about annotation1
        *   if you detect the annotation2, do logic about annotation2
        * */

        // find annotation for class
        System.out.println("-------------find annotation for class-------------------");
        Annotation[] annotations = testClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType());
            MyAnnotation2 myAnnotation2 = (MyAnnotation2)annotation;
            // get the value from annotation
            System.out.println(myAnnotation2.name());
            System.out.println(myAnnotation2.value());
        }
    }
    public void writeLogMethod(){
        // if detect @MyLogger on any method, log the data
    }
}

@MyAnnotation2(name="bob",value = "123")
class RunningTestInstance2 {
    private String val;

    public RunningTestInstance2() {
        this.val = "12345";
    }

    public void method1() {
        System.out.println("the value is " + val );
    }


    public void method2 (int n){
        System.out.println("the number is " + n);
    }

    private void method3() {
        System.out.println("private method");
    }


    @BeanProperty
//    @MyLogger
    public void method4 () {
        System.out.println("method with annotation");

    }
}

// reflection can only detect annotation during the runtime
@Retention(RetentionPolicy.RUNTIME)
// where you want to put annotation
@Target(ElementType.TYPE)
@interface MyAnnotation2{
    public String name();
    public String value();
}