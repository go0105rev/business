package elearningBatch.service.evaculation;

import java.util.List;

import jakarta.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import elearningBatch.model.UnitTest;
import elearningBatch.repository.UnitTestRepository;
import elearningBatch.service.Tasklets;

@Service
public class codeTestServiceImpl extends Tasklets {

    Logger logger = LoggerFactory.getLogger(codeTestServiceImpl.class);

    @Inject
    UnitTestRepository repository;

    @Override
    public Status process(List<String> input) {
        logger.debug("---------------start---------------");

        List<UnitTest> targets = repository.findAsVersion0();

        targets.forEach(t -> {

            long a = repository.countAsQuesNum(t.getQuesNum(), t.getUserId());
            if (a > 1) {
                logger.error(
                        "[ONLY CAN HAVE ONE OF SINGLE QUESNUM SINGLE USERID]: "+t.getSourceId());
                // TODO 終了せず、次の要素移行するか要確認
                return;
            }

            /* target java create */

            /* java test */

            UnitTest e = new UnitTest();
            e.setScore(Long.valueOf(80));
            e.setVersion((short) 1);
            repository.updateAsQues(e, t.getSourceId());

        });

        logger.debug("---------------end---------------");

        return Status.OK;
    }

}
