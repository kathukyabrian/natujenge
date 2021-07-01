package tech.kitucode.demo.processors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.kitucode.demo.core.Processor;
import tech.kitucode.demo.domain.Request;
import tech.kitucode.demo.domain.enumerations.Event;

public class PreProcessor {

    private final Logger logger = LogManager.getLogger(PreProcessor.class);

    Processor processor = new Processor();

    public void process(Request request){

        logger.debug("Received a request : {}",request);

        Event event = request.getEvent();
        // check event and route

        try{
            if(event.equals(Event.BAL)){
                processor.queue("tech.kitucode.demo.processors.BalanceProcessor",request);
            }else if (event.equals(Event.BUY)){
                processor.queue("tech.kitucode.demo.processors.RechargeProcessor",request);
            }
        }catch(Exception e){
            logger.error(e.getMessage());
        }

    }
}
