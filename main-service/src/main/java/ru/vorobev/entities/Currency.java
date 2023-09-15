package ru.vorobev.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "currencies")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Currency {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "num_code")
    private int numCode;

    @Column(name = "char_code")
    private String charCode;

    @Column(name = "nominal")
    private int nominal;

    @Column(name = "name")
    private String name;

}