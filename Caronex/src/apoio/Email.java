/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import java.io.IOException;
import java.util.Properties;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author yNot
 */
public class Email {

    public static void enviar() throws IOException {

        Properties props = new Properties();

        //Parâmetros de conexão com servidor Gmail
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("trabalhocaronex@gmail.com",
                        "Teste123");
            }
        });
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("trabalhocaronex@gmail.com"));//Remetente

            Address[] toUser = InternetAddress
                    .parse("rhklein@universo.univates.br"); //Destinatário(s)

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Teste Envio de email's");//Titulo
            message.setText("Testando o teste!");//Assunto 

            Multipart emailContent = new MimeMultipart();
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText("teste anexo");
            MimeBodyPart anexo = new MimeBodyPart();
            anexo.attachFile("C:/Users/Everton/Documents/NetBeansProjects/Caronex2/Caronex/logs.txt");
            emailContent.addBodyPart(textBodyPart);
            emailContent.addBodyPart(anexo);

            message.setContent(emailContent);

            //  Método para enviar a mensagem criada
            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Email enviado com sucesso!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void enviar(String text, JasperReport relatorio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
