package com.github.liuxg.jvm.javassist;

import javassist.*;

public class JavassistDemo {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.get("com.github.liuxg.jvm.javassist.Base");
        CtMethod process = ctClass.getDeclaredMethod("process");
        process.insertBefore("System.out.println(\"start\");");
        process.insertAfter("System.out.println(\"end\");");
        Class<?> aClass = ctClass.toClass();
        Base base = (Base)aClass.newInstance();
        base.process();
    }
}
