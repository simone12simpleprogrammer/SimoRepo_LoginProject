package it.dstech.annotationscustom.service;

import javax.mail.MessagingException;

public interface MailService {
	public void inviaMail(String destinatarioMail, String oggettoMail, String messaggioMail) throws MessagingException;

}