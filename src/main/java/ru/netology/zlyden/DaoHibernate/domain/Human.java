package ru.netology.zlyden.DaoHibernate.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Human implements Serializable {
    @NonNull
    @Column(length = 50, nullable = false)
    private String name;
    @NonNull
    @Column(length = 50, nullable = false)
    private String surname;
    @NonNull
    @Column(nullable = false)
    private int age;
}
