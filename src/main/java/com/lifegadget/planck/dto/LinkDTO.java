package com.lifegadget.planck.dto;

import lombok.*;

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

    private java.sql.Timestamp createdAt;

    private Timestamp updatedAt;
}