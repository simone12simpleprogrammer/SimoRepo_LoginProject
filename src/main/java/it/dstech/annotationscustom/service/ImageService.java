package it.dstech.annotationscustom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.dstech.annotationscustom.model.User;
import it.dstech.annotationscustom.repository.ImageRepository;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public User getFile(Long id) {
        return imageRepository.findById(id).orElseThrow(() -> null);
    }
}