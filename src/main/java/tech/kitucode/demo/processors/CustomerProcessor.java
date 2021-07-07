package tech.kitucode.demo.processors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.kitucode.demo.repository.CustomerRepository;
import tech.kitucode.demo.utilities.BasicUtils;

import javax.sql.DataSource;
import java.util.Map;

public class CustomerProcessor {

    private final Logger logger = LogManager.getLogger(CustomerProcessor.class);

    public void process(String request, CustomerRepository customerRepository, DataSource dataSource, Map<String, String> processorConfig){

        String accountNumber = BasicUtils.getSecondWord(request);

        logger.debug("Received request to create customer with account number : {}", accountNumber);

        customerRepository.save(accountNumber,dataSource);

        logger.debug("Saved a new customer");

    }
}
