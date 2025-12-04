package com.nnk.springboot.domain;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "rule_name")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RuleName {

    @Column(name = "id")
    @Id  // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "json")
    private String json;

    @Column(name = "template")
    private String template;

    @Column(name = "sql_str")
    private String sqlStr;

    @Column(name = "sql_part")
    private String sqlPart;
}
