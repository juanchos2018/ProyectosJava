/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Conexion.clsConexion;
import Entidad.ClsEntComunicados;
import Interface.InterfaceComunicados;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author usuario
 */
public class ClsNegComunicados implements InterfaceComunicados{

     private Connection conexion= new clsConexion().getConnection();
     
    @Override
    public void AgregarComunicado(ClsEntComunicados Comunicado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ModificarComunicado(String codigo, ClsEntComunicados Comunicado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EliminarComunicado(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList ListarComunicado() {
        
         ArrayList <ClsEntComunicados> Escuela=new ArrayList<ClsEntComunicados>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Comunicado_S()}");
            ResultSet rs=cst.executeQuery();
            while (rs.next()) {
                ClsEntComunicados facu = new ClsEntComunicados();
                
                facu.setCodig_estu(rs.getInt("codigo_estu"));
                facu.setAsunComu(rs.getString("asunto_com"));
                facu.setFechComu(rs.getString("fecha_com"));    
                            
                Escuela.add(facu);
                
                //id_escu,iniciales_escu,nombre_escu
            }
            return Escuela;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList BuscarComunicado(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
      public boolean EnviarCorreos(ClsEntComunicados c)
    {
        try {
            Properties p = new Properties();
            p.put("mail.smtp.host","smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.setProperty("mail.smtp.port","587");
            p.setProperty("mail.smtp.user",c.getUsuario());
            p.setProperty("mail.smtp.auth","true");
            
            Session s = Session.getDefaultInstance(p,null);
            BodyPart texto = new MimeBodyPart();
            texto.setText(c.getMensComu());
            BodyPart adjunto=new MimeBodyPart();
            
            if (!c.getRutaArchivo().equals("")) {
                adjunto.setDataHandler(new DataHandler(new FileDataSource(c.getRutaArchivo())));
                adjunto.setFileName(c.getArchComu());
            }
            MimeMultipart m = new MimeMultipart();
            m.addBodyPart(texto);
            if (!c.getRutaArchivo().equals("")) {
                m.addBodyPart(adjunto);
            }
            
            MimeMessage mensaje = new  MimeMessage(s);
            mensaje.setFrom(new InternetAddress(c.getUsuario()));
            for(String email:c.getDestino().split(",")){
                System.out.println("Send:" + email);
                mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            }
            mensaje.setSubject(c.getAsunComu());
            mensaje.setContent(m);
            
            Transport t =s.getTransport("smtp");
            t.connect(c.getUsuario(),c.getPassword());
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            
            t.close();
            return true;
        }catch(Exception ex)
        {
            System.out.println("errorRR");
            ex.printStackTrace();
            return false;
        }
    }
}
