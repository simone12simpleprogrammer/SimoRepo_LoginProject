package it.dstech.annotationscustom.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Immagine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String fileName;

	private String fileType;

	@Lob
	private byte[] data;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private User user;

	public Immagine() {

	}

	public Immagine(String fileName, String fileType, byte[] data) {
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}