package taxislibres.jeffrey.maestre.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "facturas")
@Data
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El monto total no puede ser nulo")
    @Column(name = "total_amount")
    private Double totalAmount;

    @NotBlank(message = "La descripción no puede estar vacía")
    private String desc;

    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonBackReference
    private User user;

}
