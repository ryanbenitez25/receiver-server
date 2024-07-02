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
@Table(name="violations")
public class Violation {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Integer id;

   @Column(name="violation_type")
   private String violationType;

   @Column(name="violation_city")
   private String violationCity;

   @Column(name="violation_state")
   private String violationState;

   @JsonIgnore
   @OneToOne(mappedBy = "violation")
   private ECitation eCitation;
}
