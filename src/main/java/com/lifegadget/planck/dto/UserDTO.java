package com.lifegadget.planck.dto;

import com.lifegadget.planck.core.utils.customAnnotations.ValidCountryName;
import com.lifegadget.planck.database.sqlModels.Link;
import com.lifegadget.planck.database.sqlModels.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    private Role role;
    private List<Link> links = new ArrayList<>();
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
