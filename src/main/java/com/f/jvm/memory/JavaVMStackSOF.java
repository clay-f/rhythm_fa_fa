package com.f.jvm.memory;

/**
 *VM Args:-Xss128k
 */
public class JavaVMStackSOF{
    private int stackLength=1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }
    
    public static void main(String[]args)throws Throwable{
        JavaVMStackSOF oom=new JavaVMStackSOF();
        assert 0 > 1;
        try{
            oom.stackLeak();
        }catch(Throwable e){
            System.out.println("stack length:"+oom.stackLength);
            throw e;
        }
    }
}