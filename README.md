# CSV Modifier Project

Este proyecto permite modificar un archivo CSV específico, ubicado en una carpeta de entrada (`input`), procesarlo para actualizar ciertos campos y luego guardar el archivo actualizado en una carpeta de salida (`output`). El programa está diseñado para buscar registros mediante un identificador y actualizar campos específicos. Si no se encuentra el registro o el encabezado deseado, el programa generará un mensaje de error adecuado.

## Funcionalidades

- **Búsqueda de registros**: Busca un registro en el archivo CSV en base a un número de documento.
- **Actualización de datos**: Permite actualizar campos específicos de cada registro usando una estructura `Map`.
- **Estructura de carpetas**: Gestiona un archivo de entrada y crea el archivo procesado en una carpeta de salida.
- **Mensajes y rutas centralizados**: Usa una clase `Constants` para gestionar todos los mensajes de error y las rutas de archivos.

## Requisitos previos

1. **Java**: Asegúrate de tener Java instalado en tu sistema (Java 8 o superior).
2. **Maven**: Este proyecto usa Maven para la gestión de dependencias y la compilación. Instálalo y asegúrate de que `mvn` esté en tu ruta.

## Estructura del proyecto

```plaintext
csv-modifier/
├── src/
│   └── main/
│       └── java/
│           └── org/
│               └── example/
│                   ├── CsvModifier.java
│                   ├── Constants.java
├── dataFile/
│   ├── input/       # Carpeta de entrada para archivos CSV a procesar
│   └── output/      # Carpeta de salida para archivos CSV procesados
├── README.md
└── pom.xml          # Archivo de configuración de Maven
