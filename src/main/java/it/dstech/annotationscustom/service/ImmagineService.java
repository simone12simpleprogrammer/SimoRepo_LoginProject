package it.dstech.annotationscustom.service;
import org.springframework.web.multipart.MultipartFile;

import it.dstech.annotationscustom.model.Immagine;

public interface ImmagineService {

	public Immagine salvaFile(MultipartFile file); // upload

	public Immagine recuperaFile(Long fileId); // download

}