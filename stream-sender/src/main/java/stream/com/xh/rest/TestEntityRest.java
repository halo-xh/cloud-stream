package stream.com.xh.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stream.com.xh.entiy.TestEntity;
import stream.com.xh.service.EntityService;

/**
 * author  Xiao Hong
 * date  2021/6/24 20:26
 * description
 */
@RestController
@RequestMapping("/entity")
public class TestEntityRest {

    @Autowired
    private EntityService entityService;

    @RequestMapping("/add/{name}")
    public String sendOrder(@PathVariable String name) {
        TestEntity testEntity = new TestEntity();
        testEntity.setName(name);
        entityService.save(testEntity);
        return testEntity.toString();
    }
}
