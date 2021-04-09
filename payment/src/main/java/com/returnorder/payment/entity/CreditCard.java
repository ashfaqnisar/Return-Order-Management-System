package com.returnorder.payment.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "credits")
public class CreditCard {
    @Id
    private Long cardNumber;
    private double cardLimit;

}
