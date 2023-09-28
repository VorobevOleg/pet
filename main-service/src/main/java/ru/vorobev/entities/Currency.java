package ru.vorobev.entities;


import com.fasterxml.jackson.annotation.JsonAlias;
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
    @JsonAlias("ID")
    private String id;

    @Column(name = "num_code")
    @JsonAlias("NumCode")
    private int numCode;

    @Column(name = "char_code")
    @JsonAlias("CharCode")
    private String charCode;

    @Column(name = "nominal")
    @JsonAlias("Nominal")
    private int nominal;

    @Column(name = "name")
    @JsonAlias("Name")
    private String name;

}