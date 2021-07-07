package tech.kitucode.demo.core;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.kitucode.demo.repository.CustomerRepository;

import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class Processor {

    private static Logger logger = LogManager.getLogger(Processor.class);

    public  void queue(String className, String request, CustomerRepository customerRepository, DataSource dataSource, Map<String,String> processorConfig){
        try {
            Class cls = Class.forName(className);

            Method method = cls.getMethod("process",String.class, CustomerRepository.class, DataSource.class, Map.class);

            method.invoke(cls.newInstance(),request,customerRepository,dataSource, processorConfig);

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
