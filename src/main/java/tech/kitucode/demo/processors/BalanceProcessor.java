package tech.kitucode.demo.processors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BalanceProcessor {

    private final Logger logger = LogManager.getLogger(BalanceProcessor.class);


    public void process(String request){
        logger.debug("Received a balance check request : {}",request);

        
    }
}
