package tech.kitucode.demo.processors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.kitucode.demo.core.Processor;
import tech.kitucode.demo.domain.Request;
import tech.kitucode.demo.domain.enumerations.Event;
import tech.kitucode.demo.utilities.BasicUtils;

public class PreProcessor {

    private final Logger logger = LogManager.getLogger(PreProcessor.class);

    Processor processor = new Processor();

    public void process(String request){

        logger.debug("Received a request : {}",request);
        // check event and route

        String event = BasicUtils.getFirstWord(request);

        logger.debug("Received a {} request",event);

        try{
            if(event.equals(Event.BAL.toString())){
                processor.queue("tech.kitucode.demo.processors.BalanceProcessor",request);
            }else if (event.equals(Event.BUY.toString())){
                processor.queue("tech.kitucode.demo.processors.RechargeProcessor",request);
            }
        }catch(Exception e){
            logger.error(e.getMessage());
        }

    }
}
