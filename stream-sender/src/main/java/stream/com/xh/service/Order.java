package stream.com.xh.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/5 9:35
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order")
public class Order {

    private String uuid;

    private BigDecimal price;

    private String name;

    private Date date;
}
