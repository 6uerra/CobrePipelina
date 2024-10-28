package org.example;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class App
{


    public static void main( String[] args )
    {
        CsvModifier modifier = new CsvModifier();

        // Nombre del archivo (sin extensión)
        String fileName = "recaudoTemplateDatosCorrectos";

        // ID del documento a buscar en el CSV
        String documentId = "82954306";

        // Encabezado y valor actualizar , se puede agregar N actualizacion sobre el documento
        Map<String, String> updates = new HashMap<>();
        updates.put("Fecha de Vencimiento", "2020-01-01"); // Ejemplo: nueva fecha de vencimiento

        // Modificar el CSV
        modifier.modifyCsv(fileName, documentId, updates);


    }


}
