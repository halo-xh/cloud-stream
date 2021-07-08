package stream.com.xh.rest;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/6/16 17:44
 * @description
 */
@Data
public class Pools {

    @NotBlank(message = "1 b")
    String name;

    @NotNull(message = "2 n")
    Integer age;
}
