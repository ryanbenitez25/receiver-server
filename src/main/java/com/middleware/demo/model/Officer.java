package com.middleware.demo.model;

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
@Table(name="officers")
public class Officer {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Integer id;

   @Column(name="first_name")
   private String firstName;

   @Column(name="last_name")
   private String lastName;

   @JsonIgnore
   @OneToOne(mappedBy = "officer")
   private ECitation eCitation;

}

