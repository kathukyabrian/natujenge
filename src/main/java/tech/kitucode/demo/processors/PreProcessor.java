package tech.kitucode.demo.processors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.kitucode.demo.core.Processor;
import tech.kitucode.demo.domain.enumerations.Event;
import tech.kitucode.demo.repository.CustomerRepository;
import tech.kitucode.demo.utilities.BasicUtils;

import javax.sql.DataSource;
import java.util.Map;


public class PreProcessor {

    private final Logger logger = LogManager.getLogger(PreProcessor.class);

    Processor processor = new Processor();

    public void process(String request, CustomerRepository customerRepository, DataSource dataSource, Map<String, String> processorConfig){

        logger.debug("Received a request : {}",request);
        // check event and route

        String event = BasicUtils.getFirstWord(request);

        if(event==null){
            logger.debug("An event is required to continue.....");
        }

        logger.debug("Received a {} request",event);

        try{
            if(event.equals(Event.BAL.toString())){
                processor.queue(processorConfig.get("BALANCE"),request,customerRepository,dataSource,processorConfig);
            }else if (event.equals(Event.BUY.toString())){
                processor.queue(processorConfig.get("RECHARGE"),request,customerRepository,dataSource,processorConfig);
            }else if(event.equals(Event.CREATE.toString())){
                processor.queue(processorConfig.get("CUSTOMER"),request,customerRepository,dataSource,processorConfig);
            }else{
                logger.debug("Received an invalid request");
            }
        }catch(Exception e){
            logger.error(e.getMessage());
        }

    }
}
