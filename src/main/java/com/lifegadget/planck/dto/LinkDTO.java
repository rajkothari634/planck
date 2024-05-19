package com.lifegadget.planck.dto;

import com.lifegadget.planck.database.sqlModels.LinkActivityLog;
import com.lifegadget.planck.database.sqlModels.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkDTO {
    private Long id;

    private String originalLink;

    private String shortCode;

    private UserDTO userDTO;

    private List<LinkActivityLogDTO> linkActivityLogDTOs = new ArrayList<>();

    private java.sql.Timestamp createdAt;

    private Timestamp updatedAt;
}