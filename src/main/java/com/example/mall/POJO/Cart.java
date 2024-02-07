package com.example.mall.POJO;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart")
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id; 
    private Long userId; 
    private Long goodsId; 
    private Long num;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cart cart = (Cart) o;
        return Id != null && Objects.equals(Id, cart.Id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "Id=" + Id +
                ", userId=" + userId +
                ", goodsId=" + goodsId +
                ", num=" + num +
                '}';
    }
}
