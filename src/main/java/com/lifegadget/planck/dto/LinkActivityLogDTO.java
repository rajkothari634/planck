package com.lifegadget.planck.dto;
import com.lifegadget.planck.database.sqlModels.Link;
import lombok.*;
import java.security.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkActivityLogDTO {

    private Long id;
    private LinkDTO linkDTO;
    private String ipAddress;
    private String country;

    private String city;

    private String device;

    private String requestData;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
