package Tarea1.model_layer.models;

public class Compositor {
    private int id_compositor;
    private byte[] foto_compositor;
    private String nombre_compositor;
    private Epoca epoca;
    private int num_composiciones;
    private Boolean vive;

    public Compositor(int id_compositor, byte[] foto_compositor, String nombre_compositor, Epoca epoca, int num_composiciones, Boolean vive) {
        this.id_compositor = id_compositor;
        this.foto_compositor = foto_compositor;
        this.nombre_compositor = nombre_compositor;
        this.epoca = epoca;
        this.num_composiciones = num_composiciones;
        this.vive = vive;
    }

    public int getId_compositor() {
        return id_compositor;
    }

    public byte[] getFoto_compositor() {
        return foto_compositor;
    }

    public String getNombre_compositor() {
        return nombre_compositor;
    }

    public Epoca getEpoca() {
        return epoca;
    }

    public int getNum_composiciones() {
        return num_composiciones;
    }

    public Boolean isVive() {
        return vive;
    }
}

