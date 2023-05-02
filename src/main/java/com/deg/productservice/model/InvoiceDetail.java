package com.deg.productservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "invoice_details")
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int amoun;
    private double price;

    public InvoiceDetail() {
    }

}
