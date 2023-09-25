package cl.usm.taller1.entities;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.lang.NonNullFields;


@Setter
@Getter
@ToString
@Document("cliente")

public class Cliente {

    @MongoId

    private String id;
    private String nombre;
    private String apellidos;
    // Ejemplos de rut Correctos
    // 20440649-9 🆗
    // 204406499 ✖️
    // 20.440.649-9 ✖️
    // 20440649-2 ✖️ -> DV incorrecto
    private String rut;
    private int numero_de_serie;
    private EstadoCliente estadoCliente;

    public enum EstadoCliente {
        Habilitado,
        ConDeuda,
        Enlistanegra,
    }

}