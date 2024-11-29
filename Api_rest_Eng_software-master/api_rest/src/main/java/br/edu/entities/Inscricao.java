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

@SuppressWarnings("unused")
@Entity
@Table(name = "tb_inscricao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inscricao implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "palestrante")
  private String palestrante;

  @Column(name = "data")
  @DateTimeFormat(pattern = "dd-MM-yyyy")
  private String data;

  @Column(name = "modalidade")
  private String modalidade;

  @Column(name = "tipo")
  private String local;

  @Column(name = "descricao")
  private String descricao;

}
