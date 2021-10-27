package stream.com.xh.service.tester;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import stream.com.xh.entiy.TestEntity;
import stream.com.xh.entiy.Tester;

/**
 * author  Xiao Hong
 * date  2021/6/24 20:22
 * description
 */
@Repository
public interface TesterDao extends JpaRepository<Tester, Long>, JpaSpecificationExecutor<Tester> {

}
