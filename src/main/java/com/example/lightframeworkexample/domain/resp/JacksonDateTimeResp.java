package com.example.lightframeworkexample.domain.resp;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class JacksonDateTimeResp {
    private Long id;
    private BigDecimal price;
    private BigInteger amount;
    private Date date;
    private LocalDateTime localDateTime;
}
