package br.com.alura.enviadorEmail.enviadorEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public void enviar(String nome, String emailDestinatario){
        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator("email", "password"));
            email.setSSLOnConnect(true);

            email.setFrom("email");
            email.setSubject("Você foi convidado pelo ListaVip");
            email.setMsg("Olá "+ nome + ". Você acaba de ser convidado pelo ListaVip.");
            email.addTo(emailDestinatario);
            email.send();

        }catch (EmailException e){
            e.printStackTrace();
        }
    }
}
