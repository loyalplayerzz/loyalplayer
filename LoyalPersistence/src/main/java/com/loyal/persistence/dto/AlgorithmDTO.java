package com.loyal.persistence.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * Algorithm entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALGORITHM"
    ,catalog="mysql"
)

public class AlgorithmDTO  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String paramTable;
     private String description;


    // Constructors

    /** default constructor */
    public AlgorithmDTO() {
    }

    
    /** full constructor */
    public AlgorithmDTO(String paramTable, String description) {
        this.paramTable = paramTable;
        this.description = description;
    }

   
    // Property accessors
    //@SequenceGenerator(name="generator")@Id @GeneratedValue(strategy=SEQUENCE, generator="generator")
    @Id
    @Column(name="id", unique=true, nullable=false)

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="param_table", length=100)

    public String getParamTable() {
        return this.paramTable;
    }
    
    public void setParamTable(String paramTable) {
        this.paramTable = paramTable;
    }
    
    @Column(name="description", length=100)

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
   








}