package com.learn.soap.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * @author Mohammed Abdu
 * @version vr0.1
 * @email eng.mo.abdu@gmail.com
 * @creationDate 25 Oct 2024
 */

@Entity
@Data
public class ProductEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private double price;
    private String description;
}
