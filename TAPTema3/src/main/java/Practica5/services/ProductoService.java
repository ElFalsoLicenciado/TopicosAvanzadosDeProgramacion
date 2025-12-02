package Practica5.services;

import com.google.gson.Gson;
import java.util.ArrayList;
import Practica5.models.Producto;
import org.apache.hc.client5.http.fluent.Request;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import org.apache.hc.client5.http.fluent.Form;

public class ProductoService {
    
    private String urlBase = "http://localhost/TAP_2025/TAP_U3P5/";
    
    public ArrayList<Producto> getProductos() throws Exception {
        ArrayList<Producto> productos = new ArrayList<>();

        String results = Request.get(
            urlBase + "end_point_productos.php?operation=read"
        ).execute().returnContent().asString();

        Type listType = new TypeToken<ArrayList<Producto>>(){}.getType();
        productos = new Gson().fromJson(results, listType);
        
        return productos;
    }
    
    public boolean deleteProducto(String id) throws Exception {
        Form form = Form.form();
        form.add("operation", "delete");
        form.add("id", id);
        
        String result = Request.post(
            urlBase + "end_point_productos.php"
        ).bodyForm(form.build()).execute().returnContent().asString();
        
        System.out.println(result);
        
        return !result.contains("\"error\":");
    }

    public boolean addProducto(String nombre) throws Exception {
        Form form = Form.form();
        form.add("operation", "create");
        form.add("nombre", nombre);

        String result = Request.post(
                urlBase + "end_point_productos.php"
        ).bodyForm(form.build()).execute().returnContent().asString();

        System.out.println(result);

        return !result.contains("\"error\":");
    }

    public boolean editProducto(String id, String nombre) throws Exception {
        Form form = Form.form();
        form.add("operation", "update");
        form.add("id", id);
        form.add("nombre", nombre);

        System.out.println( Request.post(urlBase + "end_point_productos.php").bodyForm(form.build()));

        String result = Request.post(
                urlBase + "end_point_productos.php"
        ).bodyForm(form.build()).execute().returnContent().asString();

        System.out.println(result);

        return !result.contains("\"error\":");
    }
    
}
