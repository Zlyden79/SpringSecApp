package ru.netology.zlyden.DaoHibernate.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persons")
public class Person {
    @EmbeddedId
    private Human human;
    @Column(name = "phone_number", length = 20)
    private String phoneNumber;
    @Column(name = "city_of_living", nullable = false, length = 50)
    private String cityOfLiving;
}
