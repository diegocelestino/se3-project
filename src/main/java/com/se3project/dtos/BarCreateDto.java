
package com.se3project.dtos;

import lombok.Getter;
import lombok.Value;

import java.util.UUID;

@Value
@Getter
public class BarCreateDto {
    String name;
    UUID eventId;
}
