package com.cokepepsi.querydsldemo.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;

/**
 * @author CokePepsi
 * @date 2023/9/22 16:12
 */
@Entity
@Table(name = "SYS_ROLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RolePO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ROLE_NAME", length = 20)
    private String roleName;
}
