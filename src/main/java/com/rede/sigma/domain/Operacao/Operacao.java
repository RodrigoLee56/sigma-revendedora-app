package com.rede.sigma.domain.Operacao;

import java.math.BigDecimal;
import java.util.Date;

import com.rede.sigma.domain.Cliente.Cliente;
import com.rede.sigma.domain.Veiculo.Veiculo;
import com.rede.sigma.domain.Vendedor.Vendedor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "operacoes")
public class Operacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;

    @Temporal(TemporalType.DATE)
    private Date data;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Vendedor vendedor;

    @ManyToOne
    @JoinColumn(name = "veiculo_numero_chassi")
    private Veiculo veiculo;

    @Column(name = "valor_entrada")
    private BigDecimal valorEntrada;

    @Column(name = "valor_financiado")
    private BigDecimal valorFinanciado;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_operacao")
    private TipoOperacao tipo; 
}
