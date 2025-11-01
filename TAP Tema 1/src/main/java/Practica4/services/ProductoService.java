/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica4.services;

import Practica4.models.Producto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import com.google.gson.Gson;

public class ProductoService {
    public static final String ARCHIVO = "productos.json";
    
    public static ArrayList<Producto> getLista()
    {
        ArrayList<Producto> productos = new ArrayList<>();
        
        try {
            BufferedReader br = new BufferedReader(
                new FileReader(ARCHIVO)
            );
            String resultado = "";
            String lectura = null;
            while((lectura = br.readLine()) != null) {
                resultado += lectura;
            }
            br.close();
            
            // Se transforma la lectora a arreglo de JSON
            JSONParser jParser = new JSONParser();
            JSONArray jArray = (JSONArray)jParser.parse(resultado);
            
            // Se recorre el array y se transforma elemento por elemento en Producto
            for (int i = 0; i < jArray.size(); i++) {
                Producto p = new Gson().fromJson(
                    jArray.get(i).toString(), Producto.class
                );
                productos.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return productos;
    }
    
    public static boolean writeProductos(ArrayList<Producto> productos) 
    {
        try {
            // Se transforma la lista de productos a JSONArray
            String json = new Gson().toJson(productos);
            
            // Se guarda el json en el archivo
            BufferedWriter bw = new BufferedWriter(
                new FileWriter(ARCHIVO, false)
            );
            bw.write(json);
            bw.close();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }    
    
}
