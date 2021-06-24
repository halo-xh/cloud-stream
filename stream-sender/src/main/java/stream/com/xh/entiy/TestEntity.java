package stream.com.xh.entiy;

import lombok.Data;

import javax.persistence.*;

/**
 * author  Xiao Hong
 * date  2021/6/24 19:59
 * description
 */
@Entity
@Data
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

}
