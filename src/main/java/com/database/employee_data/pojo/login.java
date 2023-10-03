package com.database.employee_data.pojo;

import lombok.*;

import javax.swing.*;
import java.sql.Blob;

/**
 * @Author BMQAQ
 * @Date 2023/6/12 22:53
 * @Version 1.0
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class login {
    private String Eno;
    private String Userpasswd ;
    private Integer Upos;
    private String Picture;


}
