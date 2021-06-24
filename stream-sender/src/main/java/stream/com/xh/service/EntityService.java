package stream.com.xh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import stream.com.xh.entiy.TestEntity;
import stream.com.xh.event.TestEvent;

import javax.transaction.Transactional;

/**
 * author  Xiao Hong
 * date  2021/6/24 20:21
 * description
 */
@Service
@Transactional
public class EntityService implements EntityServicer {


    @Autowired
    private TestDao testDao;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public TestEntity save(TestEntity testEntity) {
        TestEvent testEvent = new TestEvent();
        testEvent.setEntity(testEntity);
        testEvent.setBiz("biz1-a");
        TestEntity save = testDao.save(testEntity);
        publisher.publishEvent(testEvent);
        System.out.println("save Thread.currentThread().getName() = " + Thread.currentThread().getName() + "event = " + testEvent);
        return save;
    }
}
