package tech.kitucode.demo.processors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.kitucode.demo.domain.Request;

public class BalanceProcesssor {

    private final Logger logger = LogManager.getLogger(BalanceProcesssor.class);


    public void process(Request request){
        logger.debug("Received a balance check request : {}"+request);

        
    }
}
