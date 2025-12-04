package com.nnk.springboot.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;


@Entity
@Table(name = "trade")
@EntityListeners(AuditingEntityListener.class) // Enable auditing for fields annotated with (@CreatedDate, @CreatedBy, @LastModifiedDate, @LastModifiedBy)
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Trade {

    @Id  // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    @Column(name="trade_id") // Map the field name to a DB column name
    @EqualsAndHashCode.Include
    private Integer tradeId;

    @Column(name = "account", nullable = false)
    @NotBlank
    private String account;

    @Column(name = "type", nullable = false)
    @NotBlank
    private String type;

    @Column(name = "buy_quantity")
    private Double buyQuantity;

    @Column(name = "sell_quantity")
    private Double sellQuantity;

    @Column(name = "buy_price")
    private Double buyPrice;

    @Column(name = "sell_price")
    private Double sellPrice;

    @Column(name = "trade_date")
    private Timestamp tradeDate;

    @Column(name = "security")
    private String security;

    @Column(name = "status")
    private String status;

    @Column(name = "trader")
    private String trader;

    @Column(name = "benchmark")
    private String benchmark;

    @Column(name = "book")
    private String book;

    @Column(name = "creation_name")
    @CreatedBy
    private String creationName;

    @Column(name = "creation_date", nullable = false, updatable = false)
    private Timestamp creationDate;

    @Column(name = "revision_name", nullable = false)
    @CreatedBy
    private String revisionName;

    @Column(name = "revision_name", nullable = false)
    @LastModifiedBy
    private Timestamp revisionDate;

    @Column(name = "deal_name")
    private String dealName;

    @Column(name= "deal_type")
    private String dealType;

    /**
     * Exclude this field from <code>toString()</code>,
     * assuming this field is a foreign key to another entity.
     */
    @Column(name = "source_list_id")
    @ToString.Exclude
    private String sourceListId;

    @Column(name = "side")
    private String side;
}
