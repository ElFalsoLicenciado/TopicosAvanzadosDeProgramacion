package Practica4.services;

import Practica4.models.Venta;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class VentaService {

    public static final String ARCHIVO = "ventas.json";
    
    public static ArrayList<Venta> getVentas(){
        ArrayList<Venta> ventas = new ArrayList<>();
        
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(ARCHIVO)
            );
            String resultado = "";
            String lectura = null;
            while((lectura = br.readLine()) != null){
                resultado += lectura;
            }
            br.close();
            
            // Se transforma la lectora a arreglo de JSON
            JSONParser jParser = new JSONParser();
            JSONArray jArray = (JSONArray)jParser.parse(resultado);
            
            // Se recorre el array y se transforma elemento por elemento en Producto
            for (int i = 0; i < jArray.size(); i++) {
                Venta v = new Gson().fromJson(
                    jArray.get(i).toString(), Venta.class
                );
                ventas.add(v);
            }
            
//            Type listType = new TypeToken<ArrayList<Venta>>(){}.getType();
//            
//            ventas = new Gson().fromJson(resultado, listType);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ventas;
    } 
    
    public static boolean writeVentas(ArrayList<Venta> ventas){
        try{
        String json = new Gson().toJson(ventas);
        
        BufferedWriter bw = new BufferedWriter(
                new FileWriter(ARCHIVO, false)
        );
        bw.write(json);
        bw.close();
        return true;
        } catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
}
