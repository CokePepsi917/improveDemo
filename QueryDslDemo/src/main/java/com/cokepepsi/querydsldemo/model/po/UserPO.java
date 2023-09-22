package com.cokepepsi.querydsldemo.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author CokePepsi
 * @date 2023/9/22 16:10
 */

@Entity
@Table(name = "SYS_USER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USER_NAME", length = 20)
    private String username;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "createTime")
    private Date createTime;
}
