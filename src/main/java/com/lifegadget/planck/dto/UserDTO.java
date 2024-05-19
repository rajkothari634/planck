package com.lifegadget.planck.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String country;
    private RoleDTO roleDTO;
    private List<LinkDTO> linkDTOs = new ArrayList<>();
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
