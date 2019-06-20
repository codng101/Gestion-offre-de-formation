/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.front.lo54_projet_front_end.jasperReport;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.apache.derby.jdbc.*;


public class GeneratePDF {

    public  void ListeClient() {

        // - Paramètres de connexion à la base de données
        String url = "jdbc:derby://localhost:1527/courses";
        String login = "Courses";
        String password = "Courses";
        Connection connection = null;

        try {
            // - Connexion à la base
            Driver monDriver = new org.apache.derby.jdbc.ClientDriver();
            DriverManager.registerDriver(monDriver);
            connection = DriverManager.getConnection(url, login, password);

            // - Chargement et compilation du rapport
            JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\guill\\Documents\\GitHub\\Gestion-offre-formation-\\LO54_Projet_Front_End\\src\\main\\resources\\jasperReportFile\\ListeClient.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            System.out.print("1");
            // - Paramètres à envoyer au rapport
            Map parameters = new HashMap();
            parameters.put("Titre", "Titre");
            System.out.print("2");

            // - Execution du rapport
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
            System.out.print("3");
            // - Création du rapport au format PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\guill\\Documents\\GitHub\\Gestion-offre-formation-\\LO54_Projet_Front_End\\src\\main\\resources\\jasperReportFile\\ListeClient.pdf");
        } catch (JRException e) {

            e.printStackTrace();
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            try {
                 connection.close();
                } catch (SQLException e) {

                        e.printStackTrace();
                }
        }

    }
    
    public  void ListeCourse() {

        // - Paramètres de connexion à la base de données
        String url = "jdbc:derby://localhost:1527/courses";
        String login = "Courses";
        String password = "Courses";
        Connection connection = null;

        try {
            // - Connexion à la base
            Driver monDriver = new org.apache.derby.jdbc.ClientDriver();
            DriverManager.registerDriver(monDriver);
            connection = DriverManager.getConnection(url, login, password);

            // - Chargement et compilation du rapport
            JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\guill\\Documents\\GitHub\\Gestion-offre-formation-\\LO54_Projet_Front_End\\src\\main\\resources\\jasperReportFile\\ListeCourses.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

            // - Paramètres à envoyer au rapport
            Map parameters = new HashMap();
            parameters.put("Titre", "Titre");

            // - Execution du rapport
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);

            // - Création du rapport au format PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\guill\\Documents\\GitHub\\Gestion-offre-formation-\\LO54_Projet_Front_End\\src\\main\\resources\\jasperReportFile\\ListeCourse.pdf");
        } catch (JRException e) {

            e.printStackTrace();
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            try {
                 connection.close();
                } catch (SQLException e) {

                        e.printStackTrace();
                }
        }

    }
}
