package tech.kitucode.demo.processors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.kitucode.demo.repository.CustomerRepository;
import tech.kitucode.demo.utilities.BasicUtils;

import javax.sql.DataSource;
import java.util.Map;

public class RechargeProcessor {
    private final Logger logger = LogManager.getLogger(RechargeProcessor.class);

    public void process(String request, CustomerRepository customerRepository, DataSource dataSource, Map<String, String> processorConfig){
        logger.debug("Received a recharge request for account number : {} with amount : {}", BasicUtils.getSecondWord(request),BasicUtils.getThirdWord(request));
    }
}
