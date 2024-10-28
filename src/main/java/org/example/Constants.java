package org.example;

public class Constants {
    // Mensajes de error
    public static final String ERROR_NO_CSV_FILES = "No se encontró el archivo CSV especificado en la carpeta de entrada.";
    public static final String ERROR_HEADER_NOT_FOUND = "No se encontró el encabezado 'Número de documento' en el archivo CSV.";
    public static final String ERROR_NO_DOCUMENT_FOUND = "No se encontró el documento especificado en el archivo CSV.";

    // Mensajes de éxito y estado
    public static final String MESSAGE_FILE_PROCESSED = "Archivo procesado y guardado en: ";
    public static final String MESSAGE_FILE_DELETED = "Archivo original eliminado de la carpeta de input.";
    public static final String MESSAGE_FILE_NOT_DELETED = "No se pudo eliminar el archivo original de la carpeta de entrada.";

    // Rutas y extensiones de archivo
    public static final String INPUT_DIRECTORY = "src/main/java/dataFile/input/";  // Ruta de entrada
    public static final String OUTPUT_PATH = "src/main/java/dataFile/output/";     // Ruta de salida
    public static final String CSV_EXTENSION = ".csv";
}
