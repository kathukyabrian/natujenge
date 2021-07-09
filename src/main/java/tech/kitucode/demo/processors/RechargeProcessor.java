package tech.kitucode.demo.processors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.kitucode.demo.repository.CustomerRepository;
import tech.kitucode.demo.utilities.BasicUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

public class RechargeProcessor {
    private final Logger logger = LogManager.getLogger(RechargeProcessor.class);

    public void process(String request, CustomerRepository customerRepository, DataSource dataSource, Map<String, String> processorConfig, Socket socket){
        logger.debug("Received a recharge request for account number : {} with amount : {}", BasicUtils.getSecondWord(request),BasicUtils.getThirdWord(request));

        double unitCost = 30;

        String accountNumber = BasicUtils.getSecondWord(request);

        double rechargeAmount = Double.parseDouble(BasicUtils.getThirdWord(request));

        customerRepository.updateBalance(accountNumber,rechargeAmount,dataSource,unitCost);

        BasicUtils.writeToSocket(socket,"Successfully credited your account with "+rechargeAmount/unitCost + " units");

    }

}
