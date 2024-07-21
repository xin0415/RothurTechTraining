package org.example.day3;

import org.example.exception.UserNotFoundException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.*;

public class ExceptionTest {
    /*
     *                      Object
     *                    Throwable
     *          Exception           Error
     *      Checked Exception       Virtual Error
     *      unchecked Exception     Assertion Error
     *
     *
     *  1. you can create you own exception in the exception file
     *  2. always need catch, cannot use try alone
     *  3. is Ok to use try and finally without catch
     *  4. for multiple catch, subclass must write before super class
     *  5. only the class that implement the AutoCloseable interface can put into try()
     *  6. try-with resource will handle the exception to close the resource, you need to use try-catch inside the finally to close to resource
     * */
    public static void main(String[] args)  {

        // way to use customized exception
        //throw new UserNotFoundException("User not found");

        testFinally();
        multipleCatch();
        try {
            fileReader("/");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void multipleCatch() {
        try{
            System.out.println("multipleCatch try");
        }catch (UserNotFoundException | NullPointerException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void fileReader(String path) throws FileNotFoundException{
        System.out.println("Here");
//        FileInputStream fis = new FileInputStream(path);
    }
//    public static void customizedException() throws UserNotFoundException {}
    public static void testFinally(){
        System.out.println("testFinally");
        try{
            System.out.println("in try");
            //return;             // if yuou add return here, finally will still run, but it won't run testFinally end
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("in finally");
        }
        System.out.println("testFinally End");
    }
    public static void withoutUseTryWithResources(){
        BufferedReader br=null;
        try {
            br=new BufferedReader(new FileReader("/"));
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
        try {
            br.readLine();
        }catch (IOException e){
            throw new RuntimeException(e);
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
