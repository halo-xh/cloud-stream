package stream.com.xh.event;

import lombok.Data;
import stream.com.xh.entiy.TestEntity;

/**
 * author  Xiao Hong
 * date  2021/6/24 20:41
 * description
 */
@Data
public class TestEvent {

    private String biz;

    private TestEntity entity;

}
