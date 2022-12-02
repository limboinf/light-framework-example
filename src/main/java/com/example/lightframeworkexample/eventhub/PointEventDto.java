package com.example.lightframeworkexample.eventhub;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PointEventDto {

    private String id;
    private String event;
}
