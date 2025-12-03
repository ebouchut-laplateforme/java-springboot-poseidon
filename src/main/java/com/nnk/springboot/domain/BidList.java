package com.nnk.springboot.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.sql.Timestamp;

/**
 * A domain object (entity) modeling a list of bids.
 * <p>
 * I explicitly declare the mapping field name to database column name
 * with <code>@Table(name= "...")</code>,
 * just for the sake of practicing even if this is redundant,
 * because the database column names  follow the Spring Boot convention.
 * <p>
 *  Why NOT annotating this entity class with <b><copde>@Data</copde></b> because:
 *   - <code>toString()</code> can trigger lazy-loading issues
 *   - <code>equals()/hashCode()</code> with all fields is problematic as this entity can mutate.
 *   - This can cause infinite recursion with bidirectional relationships!!!
 */
@Entity
@Table(name = "bid_list")
@Getter // Call the Lombok annotation family to the rescue ;-)
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BidList {
    @Id  // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    @Column(name="bid_list_id") // Map the field name to a DB column name
    @EqualsAndHashCode.Include
    private Integer bidListId;

    @Column(name = "account", nullable = false)
    @NotBlank
    private String account;

    @Column(name = "type", nullable = false)
    @NotBlank
    private String type;

    @Column(name="bid_quantity")
    @PositiveOrZero
    private Double bidQuantity;

    @Column(name="ask_quantity")
    @PositiveOrZero
    private Double askQuantity;

    @Column(name = "bid", nullable = false)
    @NotNull
    @Positive
    private Double bid;

    @Column(name = "ask")
    private Double ask;

    @Column(name = "benchmark")
    private String benchmark;

    @Column(name = "bid_list_date")
    private Timestamp bidListDate;

    @Column(name = "commentary")
    private String commentary;

    @Column(name = "security")
    private String security;

    @Column(name = "status")
    private String status;

    @Column(name = "trader")
    private String trader;

    @Column(name = "book")
    private String book;

    /**
     * Who created this <code>BidList</code>.
     */
    @Column(name = "creation_name")
    @CreatedBy
    private String creationName;

    /**
     * When was this <code>BidList</code> created
     */
    @Column(name = "creation_date", nullable = false)
    @CreatedDate
    private Timestamp creationDate;

    /**
     * Who updated this <code>BidList</code>.
     */
    @Column(name="revision_name")
    private String revisionName;

    /**
     * When was this <code>BidList</code> updated
     */
    @Column(name = "revision_date", nullable = false)
    private Timestamp revisionDate;

    @Column(name = "deal_name")
    private String dealName;

    @Column(name = "deal_type")
    private String dealType;

    /**
     * Exclude this field from toString(),
     * assuming this field is a foreign key to another entity.
     */
    @Column(name = "source_list_id")
    @ToString.Exclude
    private String sourceListId;

    @Column(name = "side")
    private String side;
}
