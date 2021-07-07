package com.xh.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/5 9:35
 * @description
 */
@Entity(name = "orderr")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    private String uuid;

    private BigDecimal price;

    private String name;

    private Date date;
}
