package stream.com.xh.service.tester;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import stream.com.xh.entiy.Tester;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

/**
 * author  Xiao Hong
 * date  2021/7/10 12:25
 * description
 */
@Slf4j
@Service
public class TesterService {

    @Autowired
    private TesterDao testerDao;

    @Scheduled(fixedRate = 5000)
    public void addRandomRecord() {
        Tester tester = new Tester();
        tester.setId(System.currentTimeMillis());
        tester.setSdate(new Date());
        Random random = new Random();
        tester.setVal(random.nextInt(100000));
        tester.setName("user-" + random.nextInt(7));
        testerDao.save(tester);
        log.info("saved tester: {}", tester);
    }
}
