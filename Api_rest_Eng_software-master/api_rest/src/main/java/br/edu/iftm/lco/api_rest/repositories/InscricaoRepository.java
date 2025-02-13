package repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Inscricao;

@Repository
public interface InscricaoRepository extends JpaRepository <Inscricao,Long>{

    Optional<Inscricao> findBytipoins(String tipoins);

    Optional<Inscricao> findBytipopartic(String tipopartic);

    void deleteByTipoins(String tipoins);
    
    void deleteByTipopartic(String tipopartic);




}
