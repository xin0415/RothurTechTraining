package com.homework.training.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_product")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int quantity;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.DETACH)
    private Order order;
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.DETACH)
    private Product product;
}
