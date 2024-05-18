package com.lifegadget.planck.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lifegadget.planck.constants.RoleType;
import com.lifegadget.planck.core.utils.customAnnotations.ValidCountryName;
import com.lifegadget.planck.database.sqlModels.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
    private Integer id;

    private RoleType roleName;

    private List<User> users = new ArrayList<>();

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
