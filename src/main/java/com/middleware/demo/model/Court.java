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
@Table(name="courts")
public class Court {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Integer id;

   @Column(name="name")
   private String name;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "judge_id")
   private Judge judge;

   @JsonIgnore
   @OneToOne(mappedBy = "court")
   private ECitation eCitation;

}
