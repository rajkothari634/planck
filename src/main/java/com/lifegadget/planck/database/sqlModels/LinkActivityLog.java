package com.lifegadget.planck.database.sqlModels;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lifegadget.planck.core.utils.customAnnotations.ValidCountryName;
import jakarta.persistence.*;
import lombok.*;
import netscape.javascript.JSObject;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "link_activity_logs")
public class LinkActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "link_id", nullable = false)
    @JsonIgnore
    @JsonBackReference
    private Link link;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column()
    @ValidCountryName
    private String country;

    @Column()
    private String city;

    @Column()
    private String device;

    @Column(name = "request_data")
    private String requestData;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private java.sql.Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private Timestamp updatedAt;
}
