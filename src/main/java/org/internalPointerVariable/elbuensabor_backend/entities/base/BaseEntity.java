package org.internalPointerVariable.elbuensabor_backend.entities.base;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", length = 256)
    private LocalDate createdAt;

    @Column(name = "is_deleted", length = 256)
    private boolean isDeleted;

    @Column(name = "deleted_at", length = 256)
    private LocalDate deletedAt;

}
