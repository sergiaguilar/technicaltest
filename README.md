# technicaltest
Código JAVA que llama a una API externa para obtener un anuncio en formato HTML. El proceso precisa de dos variables INPUTS.

Se trata de un proceso JAVA que recibirá por input dos variables:
- Filepath: ruta donde se encuentra un fichero en formato JSON, que el proceso se encargará de validar, leer y mapearlo según las necesidades.
- Timeoout: variable en formato Integer que servirá para llamar a la API externa.

Una vez validado el fichero JSON, se realizará una llamada a una API externa con una serie de prámetros mapeados con elfichero input. Esta llamada puede ser OK y que nos devuelva un anuncio en formato HTML, OK pero que no pueda devolvernos anuncio o KO por algún error en la llamada.

Para ejecutar el proceso bastará con ejecutar el siguiente comando:
java -jar {RUTA DONDE SE ENCUENTRA EL JAR}\technicaltest-1.0-jar-with-dependencies.jar {RUTA AL FICHERO INPUT} {TIMEOUT}
