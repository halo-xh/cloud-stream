package stream.com.xh.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import stream.com.xh.entiy.TestEntity;

/**
 * author  Xiao Hong
 * date  2021/6/24 20:22
 * description
 */
@Repository
public interface TestDao extends JpaRepository<TestEntity, Long>, JpaSpecificationExecutor<TestEntity> {

}
