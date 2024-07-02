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
@Table(name="e_citations")
public class ECitation {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Integer id;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "court_id")
   private Court court;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "officer_id")
   private Officer officer;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "violation_id")
   private Violation violation;

}
