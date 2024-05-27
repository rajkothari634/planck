package com.lifegadget.planck.database.noSQLModels;

import com.fasterxml.jackson.databind.JsonNode;
import com.lifegadget.planck.core.utils.customAnnotations.ValidCountryName;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.HashIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "link_activity_logs")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LinkActivityLog implements Serializable {

    @Id
    private String id;

    @NotNull
    @Indexed
    @HashIndexed
    private Long linkId;

    private String ipAddress;

    @ValidCountryName
    private String country;

    private String city;

    private String device;

    @Field("jsonField")
    private JsonNode requestData;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;
}
