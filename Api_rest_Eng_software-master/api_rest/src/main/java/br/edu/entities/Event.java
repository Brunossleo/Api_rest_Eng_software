package br.edu.entities;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_event")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "startingDate")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date startingDate;
    @Column(name = "finishDate")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date finishDate;
    private String type;
    private String category;
    private Blob image;
    private String address;
    private String description;

}
