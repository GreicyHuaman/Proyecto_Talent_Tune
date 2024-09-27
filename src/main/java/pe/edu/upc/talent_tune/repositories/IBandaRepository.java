package pe.edu.upc.talent_tune.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.talent_tune.entities.Banda;

import java.util.List;

@Repository
public interface IBandaRepository extends JpaRepository<Banda, Integer> {

    @Query(value = "SELECT b.nombre_banda, COUNT(c.id_contrato) AS contratos_activos\n" +
            " FROM banda b\n" +
            " JOIN contrato c ON b.id_banda = c.id_banda\n" +
            " WHERE c.estado_contrato = 'Activo'\n" +
            " GROUP BY b.id_banda, b.nombre_banda\n" +
            " ORDER BY contratos_activos DESC\n" +
            " LIMIT 3;\n",nativeQuery = true)

    List<String[]> BandasMasContratosActivos();

}
