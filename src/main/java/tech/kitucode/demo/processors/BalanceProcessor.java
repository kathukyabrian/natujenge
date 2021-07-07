package tech.kitucode.demo.processors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.kitucode.demo.repository.CustomerRepository;
import tech.kitucode.demo.utilities.BasicUtils;

import javax.sql.DataSource;
import java.util.Map;

public class BalanceProcessor {

    private final Logger logger = LogManager.getLogger(BalanceProcessor.class);


    public void process(String request, CustomerRepository customerRepository, DataSource dataSource, Map<String, String> processorConfig){
        logger.debug("Received a balance check request : {}",request);

        String accountNumber = BasicUtils.getSecondWord(request);

        System.out.println(accountNumber);

        logger.debug("Balance : {}",customerRepository.getBalance(accountNumber,dataSource));
    }
}
