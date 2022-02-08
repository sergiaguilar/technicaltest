package com.tappx;

import org.json.JSONException;

public class Launcher 
{
    public static void main( String[] args )
    {
        if(args.length != 2) System.out.println("Argumentos input incorrectos. Se deben pasar dos campos de forma obligatoria: 1- Path del fichero de consulta. 2- Timeout de la llamada a la API externa (Integer). ");
        else {
            String pathFile = args[0];
            Integer timeout = Integer.valueOf(args[1]);
            Tappx tappx = new Tappx(timeout, pathFile);
            String urlEncoded;
            if(!tappx.checkFileExists()) {
                System.out.println("Error: el fichero que se ha pasado no existe.");
            }
            else {
                try {
                    urlEncoded = tappx.calculateURL();
                    tappx.sendHttpRequest(urlEncoded);
            
                    Integer code = tappx.getStatusCode();
                    String advert = tappx.getAdvert();
            
                    switch (code) {
                        case 200: {
                            System.out.println("Status code: 200; Consulta correcta, a continuación mostramos el anuncio:");
                            System.out.println(advert);
                            break;
                        }
                        case 204: {
                            System.out.println("Status code: 204; Consulta correcta, pero no ha devuelto contenido.");
                            break;
                        }
                        default: {
                            System.out.println("Status code: "+ code +"; Error al obtener el anuncio.");
                        }
                    }
                } catch (JSONException e) {
                    System.out.println("Error: el fichero input no tiene el formato JSON.");
                }
            }    
        }
        
    }
}
