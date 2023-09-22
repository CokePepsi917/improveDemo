package com.cokepepsi.querydsldemo.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author CokePepsi
 * @date 2023/9/22 16:11
 */
@Entity
@Table(name = "SYS_DEPT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentPO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DEPT_NAME", length = 20)
    private String deptName;
}
