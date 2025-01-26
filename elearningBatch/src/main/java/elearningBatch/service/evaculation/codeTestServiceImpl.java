package elearningBatch.service.evaculation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import elearningBatch.service.Tasklets;

@Service
public class codeTestServiceImpl extends Tasklets {

    Logger logger = LoggerFactory.getLogger(codeTestServiceImpl.class);
    
    @Override
    public Status process(List<String> input) {
        logger.debug("---------------start---------------");
        /*DB select*/

        /*target java create*/

        /*java test*/

        /*result db update*/

        logger.debug("---------------end---------------");
        return Status.OK;
    }

}
