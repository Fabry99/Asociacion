/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASES;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
/**
 *
 * @author Fujitsu
 */
public class GeneradorPDF {
 
      

    public GeneradorPDF(String dato,String buscador,String mes, String y) {
  try {
            // Paso 3: crear una conexión a la base de datos MySQL
            String url = "jdbc:mysql://localhost:3306/dbcolegio";
            String user = "root";
            String password = "";
            Connection con = DriverManager.getConnection(url, user, password);

            // Paso 4: crear una consulta SQL
            String sql = "Select * from ingresos  where DUI_NIT="+(dato)+"&& MONTH(FECHA)='"+(mes)+"' && YEAR(FECHA)='"+(y)+"' && TIPO_CUENTA='"+(buscador)+"'";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            // Paso 5: crear un objeto de documento de iText
            Document documento = new Document(PageSize.LETTER);

            // Paso 6: crear un objeto de tabla de iText
            PdfPTable tabla = new PdfPTable(3);
            tabla.addCell("ID");
             tabla.addCell("INGRESO");
     tabla.addCell("CLIENTE");
     tabla.addCell("DUI");
    tabla.addCell("FORMA_PAGO");
   tabla.addCell("CANTIDAD $");
     tabla.addCell("FECHA");
     tabla.addCell("DESCRIPCION");

            while (rs.next()) {
                // agregar filas a la tabla
                tabla.addCell(rs.getString(1));
                tabla.addCell(rs.getString(2));
                tabla.addCell(rs.getString(3));
                 tabla.addCell(rs.getString(4));
                  tabla.addCell(rs.getString(5));
                   tabla.addCell(rs.getString(6));
                    tabla.addCell(rs.getString(7));
                     tabla.addCell(rs.getString(8));
            }

            // Paso 7: agregar la tabla al objeto de página y cerrar el documento
            PdfWriter.getInstance(documento, new FileOutputStream("clientes.pdf"));
            documento.open();
            documento.add(new Paragraph("Lista de clientes"));
            documento.add(tabla);
            documento.close();

            // liberar recursos
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(GeneradorPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(GeneradorPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public GeneradorPDF() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }

