package tech.kitucode.demo.processors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.kitucode.demo.utilities.BasicUtils;

public class RechargeProcessor {
    private final Logger logger = LogManager.getLogger(RechargeProcessor.class);

    public void process(String request){
        logger.debug("Received a recharge request for account number : {} with amount : {}", BasicUtils.getSecondWord(request),BasicUtils.getThirdWord(request));
    }
}
