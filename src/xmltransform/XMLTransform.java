package xmltransform;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author farnauvi
 */
public class XMLTransform {

  private static Document document;

  public static void main(String[] args) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    String fileXML="standalone-full.xml";
    String fileXSL="transformacion.xsl";
    String fileSH="/tmp/creaDataSources.sh";   
    if (args.length < 2) 
    {
        System.out.println("Recuerde sintaxis: java -jar XMLTransforms.jar ficheroDatasouces.xml ficherotransformaciones.xsl");
        System.out.println("En caso de no pasar ficheros, se busca -> standalone-full.xml y -> transformacion.xsl");
    } else {
        fileXML=args[0];
        fileXSL=args[1];
    }
    
    try {
        File xml = new File(fileXML);
        File xsl = new File(fileXSL);
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(xml);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        StreamSource style = new StreamSource(xsl);
        Transformer transformer = transformerFactory.newTransformer(style);

        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(fileSH));
        transformer.transform(source, result);
        System.out.println("Resultado de la transformación en > "+fileSH);
        System.out.println("Recuerde aplicar los permisos adecuados y ejecutarlo como usuario jboss6 o jboss");
    } catch (FileNotFoundException e) {
        System.out.println("Archivo no encontrado: Recuerde sintaxis Run as: java -jar XMLTransforms.jar ficheroDatasouces.xml ficherotransformaciones.xsl");
    }
  }
    
}
