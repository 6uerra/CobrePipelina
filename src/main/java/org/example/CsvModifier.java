package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class CsvModifier {

    public void modifyCsv(String fileName, String documentId, Map<String, String> updates) {
        File csvFile = new File(Constants.INPUT_DIRECTORY + fileName + Constants.CSV_EXTENSION);
        StringBuilder output = new StringBuilder();
        boolean documentFound = false;

        // Ruta para mover el archivo procesado
        String processedFilePath = Constants.OUTPUT_PATH + normalize(fileName) + Constants.CSV_EXTENSION;

        // Validar que archivo exista
        if (!csvFile.exists()) {
            System.err.println(Constants.ERROR_NO_CSV_FILES);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             BufferedWriter bwProcessed = new BufferedWriter(new FileWriter(processedFilePath))) {

            // Leer y almacenar encabezado
            String headerLine = br.readLine();
            output.append(headerLine).append("\n");

            // Construir índice de encabezados
            Map<String, Integer> headerIndexMap = buildHeaderIndexMap(headerLine);
            int documentIndex = getDocumentIndex(headerIndexMap);

            // Validación de encabezado para el documento a ser buscado
            if (documentIndex == -1) {
                System.err.println(Constants.ERROR_HEADER_NOT_FOUND);
                return;
            }

            // Leer y procesar cada línea del archivo CSV
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");

                if (columns.length > documentIndex && columns[documentIndex].equals(documentId)) {
                    updateColumns(columns, headerIndexMap, updates);
                    documentFound = true;
                }

                output.append(String.join(",", columns)).append("\n");
            }

            // Verificar si se encontró el documento
            if (!documentFound) {
                System.err.println(Constants.ERROR_NO_DOCUMENT_FOUND);
            } else {
                bwProcessed.write(output.toString());
                System.out.println(Constants.MESSAGE_FILE_PROCESSED + processedFilePath);

                // Intentar eliminar el archivo original de input
                if (csvFile.delete()) {
                    System.out.println(Constants.MESSAGE_FILE_DELETED);
                } else {
                    System.err.println(Constants.MESSAGE_FILE_NOT_DELETED);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Construir mapa de índice de encabezado
    private Map<String, Integer> buildHeaderIndexMap(String headerLine) {
        String[] headers = headerLine.split(",");
        Map<String, Integer> headerIndexMap = new HashMap<>();

        for (int i = 0; i < headers.length; i++) {
            headerIndexMap.put(headers[i].trim(), i);
        }
        return headerIndexMap;
    }

    // Obtener índice de "Número de documento"
    private int getDocumentIndex(Map<String, Integer> headerIndexMap) {
        return headerIndexMap.getOrDefault("Número de documento", -1);
    }

    // Actualizar columnas según el mapa de actualizaciones
    private void updateColumns(String[] columns, Map<String, Integer> headerIndexMap, Map<String, String> updates) {
        for (Map.Entry<String, String> entry : updates.entrySet()) {
            Integer index = headerIndexMap.get(entry.getKey().trim());
            if (index != null) {
                columns[index] = entry.getValue();
            }
        }
    }

    // Se utiliza para quitar los caracteres especiales
    private static String normalize(String input) {
        return input.replaceAll("[^\\p{ASCII}]", "").trim().toLowerCase();
    }
}
