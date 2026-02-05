package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Payment;

import java.time.Instant;

public class PaymentDTO {

    private Long id;
    private Instant momment;

    public PaymentDTO(Long id, Instant momment) {
        this.id = id;
        this.momment = momment;
    }

    public PaymentDTO(Payment entity) {
        id = entity.getId();
        momment = entity.getMoment();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomment() {
        return momment;
    }

    public void setMomment(Instant momment) {
        this.momment = momment;
    }
}
