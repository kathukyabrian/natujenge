package tech.kitucode.demo.core;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.kitucode.demo.domain.Request;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Processor {

    private static Logger logger = LogManager.getLogger(Processor.class);

    public  void queue(String className, Request request){
        try {
            Class cls = Class.forName(className);

            Method method = cls.getMethod("process",Request.class);

            method.invoke(cls.newInstance(),request);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}
