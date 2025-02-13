package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entities.Inscricao;
import repositories.InscricaoRepository;

@Service
public class InscricaoService {

    @Autowired 
    InscricaoRepository inscricaoRepository;

    @Transactional(readOnly = true)
    public List<Inscricao> findAll() {
        return inscricaoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Inscricao> findById(Long id){
        return inscricaoRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Inscricao> findByTipoins(String tipoins){
        return inscricaoRepository.findBytipoins(tipoins);
    }

    @Transactional(readOnly = true)
    public Optional<Inscricao> findByTipopartic(String tipopartic){
        return inscricaoRepository.findBytipopartic(tipopartic);
    }
    
    @Transactional
    public Inscricao insert(Inscricao inscricao) throws Exception{
        if (inscricao.getId() != null && inscricaoRepository.existsById(inscricao.getId())) {
            throw new Exception("ID já existe: " + inscricao.getId());
        }
        return inscricaoRepository.save(inscricao);
    }


    @Transactional
    public List<Inscricao> insertAll(List<Inscricao> inscricoes) {
        return inscricaoRepository.saveAll(inscricoes);
    }

    @Transactional
    public Inscricao update(Long id, Inscricao updatedInscricao) {
    Inscricao entity = inscricaoRepository.findById(id).orElseThrow(() -> new
        RuntimeException("Inscricao not found"));
        entity.setTipoins(updatedInscricao.getTipoins());
        entity.setTipapartic(updatedInscricao.getTipapartic());
        return inscricaoRepository.save(entity);
    }

    @Transactional
    public void deleteById(Long id){
        inscricaoRepository.deleteById(id);
    }

    @Transactional
    public void deleteByTipoins(String tipoins){
        inscricaoRepository.deleteByTipoins(tipoins);
    }

    @Transactional
    public void deleteByTipopartic(String tipopartic){
        inscricaoRepository.deleteByTipopartic(tipopartic);
    } 
    
    

}
