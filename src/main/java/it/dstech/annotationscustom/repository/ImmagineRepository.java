package it.dstech.annotationscustom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.dstech.annotationscustom.model.Immagine;

@Repository
public interface ImmagineRepository extends JpaRepository<Immagine, Long> {

}