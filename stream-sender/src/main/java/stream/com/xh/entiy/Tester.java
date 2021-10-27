package stream.com.xh.entiy;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * author  Xiao Hong
 * date  2021/7/10 12:23
 * description
 */
@Entity
@Data
public class Tester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer val;

    @Column(nullable = false)
    private Date sdate;

}
