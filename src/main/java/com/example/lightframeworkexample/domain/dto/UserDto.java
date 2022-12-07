package com.example.lightframeworkexample.domain.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * description
 *
 * @author limbo
 * @since 2022/12/6 14:39
 */
@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1691626132760693307L;

    @NotNull
    @Max(100000)
    @Min(1)
    private Integer userId;

    @NotEmpty
    private String userName;
}
