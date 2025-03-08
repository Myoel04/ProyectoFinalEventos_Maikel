package modelo;

import java.util.Date;

/**
 * Clase para representar la relación entre un evento y un usuario, incluyendo el rol del usuario en dicho evento.
 */
public class eventoUsuario {
    private int idEvento;
    private String tituloEvento;
    private String tipoEvento;
    private Date fecha;
    private int idUsuario;
    private String nombreUsuario;
    private String email;
    private String rolEnEvento;

    public eventoUsuario(int idEvento, String tituloEvento, String tipoEvento, Date fecha, int idUsuario, 
                        String nombreUsuario, String email, String rolEnEvento) {
        this.idEvento = idEvento;
        this.tituloEvento = tituloEvento;
        this.tipoEvento = tipoEvento;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.rolEnEvento = rolEnEvento;
    }

    // Getters y Setters
    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getTituloEvento() {
        return tituloEvento;
    }

    public void setTituloEvento(String tituloEvento) {
        this.tituloEvento = tituloEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRolEnEvento() {
        return rolEnEvento;
    }

    public void setRolEnEvento(String rolEnEvento) {
        this.rolEnEvento = rolEnEvento;
    }

    @Override
    public String toString() {
        return "EventoUsuario{" +
               "idEvento=" + idEvento +
               ", tituloEvento='" + tituloEvento + '\'' +
               ", tipoEvento='" + tipoEvento + '\'' +
               ", fecha=" + fecha +
               ", idUsuario=" + idUsuario +
               ", nombreUsuario='" + nombreUsuario + '\'' +
               ", email='" + email + '\'' +
               ", rolEnEvento='" + rolEnEvento + '\'' +
               '}';
    }
}