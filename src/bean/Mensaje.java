package bean;


public class Mensaje {
   
    private String mensaje;
    private String criptograma;
    private String clave;

    public Mensaje() {
        mensaje = "";
        clave = "";
        criptograma = "";
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCriptograma() {
        return criptograma;
    }

    public void setCriptograma(String criptograma) {
        this.criptograma = criptograma;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    

   


    


}

