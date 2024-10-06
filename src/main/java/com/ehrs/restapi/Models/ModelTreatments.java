package com.ehrs.restapi.Models;

import jakarta.persistence.*;
import java.util.Date;

//import org.hibernate.annotations.Entity;
//new file updated
import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name = "treatments")
public class ModelTreatments {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    int	sys_id 	;
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paitents_panumber_seq")
   //@SequenceGenerator(name = "paitents_panumber_seq", sequenceName = "paitents_panumber_seq", allocationSize = 1)
    @Column(name = "treat_disease")
    String	treat_disease 	;
    @Column(name="treat_symptoms")
    String	treat_symptoms 	;
    @Column(name="treat_diagnosis")
    String	treat_diagnosis 	;
    @Column(name = "treat_treatment")
    String	treat_treatment 	;
    @Column(name = "treat_spcode")
    String	treat_spcode 	;
    @Column(name = "remarks")
    String	remarks 	;
    @Column(name = "status")
    String	status 	;
    //system columns
    @Column(name = "created")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    Date	created 	;
    @Column(name = "created_by")
    int	created_by 	;
    @Column(name = "updated")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    Date	updated 	;
    @Column(name = "updated_by")
    int	updated_by 	;
}
