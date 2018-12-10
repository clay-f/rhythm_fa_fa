package com.f.java.base.util.annotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseCaseTracker {
    public static void trackUseCase(List<Integer> useCases, Class<?> cl) {
        for (Method method : cl.getDeclaredMethods()) {
           UseCase useCase = method.getAnnotation(UseCase.class);
           if (useCase != null) {
               System.out.println(useCase.des());
               System.out.println(useCase.id());
           }
        }

        for ( int i : useCases) {
            System.out.println("missing use case :" + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> usecacse = new ArrayList<>();
        Collections.addAll(usecacse, 1, 2, 3);
        trackUseCase(usecacse, PasswordUtils.class);
    }
}
