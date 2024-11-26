package com.rede.sigma.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rede.sigma.domain.Operacao.Operacao;

public interface OperacaoRepository extends JpaRepository<Operacao, Long> {
	// Buscar operações por cliente
	@Query("SELECT o FROM Operacao o WHERE o.cliente.cpf = :cpf")
	List<Operacao> findByClienteCpf(@Param("cpf") String cpf);

	// Buscar operações por vendedor
	@Query("SELECT o FROM Operacao o WHERE o.vendedor.codigo = :codigo")
	List<Operacao> findByVendedorCodigo(@Param("codigo") Integer codigo);

	// Buscar operações entre datas
	@Query("SELECT o FROM Operacao o WHERE o.data BETWEEN :startDate AND :endDate")
	List<Operacao> findByDataBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

	// Buscar operações com valor total maior que um valor específico
	@Query("SELECT o FROM Operacao o WHERE o.valorTotal > :valor")
	List<Operacao> findByValorTotalGreaterThan(@Param("valor") Double valor);
}
