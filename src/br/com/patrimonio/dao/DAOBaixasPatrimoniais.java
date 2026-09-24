package br.com.patrimonio.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.patrimonio.pojo.BaixasPatrimoniais;

public class DAOBaixasPatrimoniais extends Conexao {

    // =========================
    // CADASTRAR
    // =========================
    public String cadastrar(BaixasPatrimoniais obj) {

        String msg = "Baixa patrimonial cadastrada com sucesso!";

        String sql = "INSERT INTO baixas_patrimoniais "
                   + "(patrimonio_id, usuario_registro_id, tipo_baixa, "
                   + "motivo, valor_recuperado, documento_comprobatorio) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try {

            abrirConexao();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getPatrimonio_id());
            stmt.setInt(2, obj.getUsuario_registro_id());
            stmt.setString(3, obj.getTipo_baixa());
            stmt.setString(4, obj.getMotivo());
            stmt.setBigDecimal(5, obj.getValor_recuperado());
            stmt.setString(6, obj.getDocumento_comprobatorio());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {

            msg = "Erro ao cadastrar baixa patrimonial: "
                    + e.getMessage();
        }

        return msg;
    }


    // =========================
    // LISTAR
    // =========================
    public List<BaixasPatrimoniais> listar() {

        List<BaixasPatrimoniais> lista = new ArrayList<>();

        String sql = "SELECT * FROM baixas_patrimoniais";

        try {

            abrirConexao();

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                BaixasPatrimoniais obj =
                        new BaixasPatrimoniais();

                obj.setId(
                    rs.getInt("id")
                );

                obj.setPatrimonio_id(
                    rs.getInt("patrimonio_id")
                );

                obj.setUsuario_registro_id(
                    rs.getInt("usuario_registro_id")
                );

                obj.setTipo_baixa(
                    rs.getString("tipo_baixa")
                );

                obj.setMotivo(
                    rs.getString("motivo")
                );

                obj.setValor_recuperado(
                    rs.getBigDecimal("valor_recuperado")
                );

                obj.setDocumento_comprobatorio(
                    rs.getString("documento_comprobatorio")
                );

                obj.setData_baixa(
                    rs.getTimestamp("data_baixa")
                );

                lista.add(obj);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {

            System.out.println(
                "Erro ao listar baixas patrimoniais: "
                + e.getMessage()
            );
        }

        return lista;
    }


    // =========================
    // ATUALIZAR
    // =========================
    public String atualizar(BaixasPatrimoniais obj) {

        String msg =
            "Baixa patrimonial atualizada com sucesso!";

        String sql =
            "UPDATE baixas_patrimoniais SET "
          + "patrimonio_id = ?, "
          + "usuario_registro_id = ?, "
          + "tipo_baixa = ?, "
          + "motivo = ?, "
          + "valor_recuperado = ?, "
          + "documento_comprobatorio = ? "
          + "WHERE id = ?";

        try {

            abrirConexao();

            PreparedStatement stmt =
                    con.prepareStatement(sql);

            stmt.setInt(
                1,
                obj.getPatrimonio_id()
            );

            stmt.setInt(
                2,
                obj.getUsuario_registro_id()
            );

            stmt.setString(
                3,
                obj.getTipo_baixa()
            );

            stmt.setString(
                4,
                obj.getMotivo()
            );

            stmt.setBigDecimal(
                5,
                obj.getValor_recuperado()
            );

            stmt.setString(
                6,
                obj.getDocumento_comprobatorio()
            );

            stmt.setInt(
                7,
                obj.getId()
            );

            stmt.executeUpdate();

            stmt.close();

        } catch (SQLException e) {

            msg =
                "Erro ao atualizar baixa patrimonial: "
                + e.getMessage();
        }

        return msg;
    }


    // =========================
    // EXCLUIR
    // =========================
    public String excluir(Integer id) {

        String msg =
            "Baixa patrimonial excluída com sucesso!";

        String sql =
            "DELETE FROM baixas_patrimoniais "
          + "WHERE id = ?";

        try {

            abrirConexao();

            PreparedStatement stmt =
                    con.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();

            stmt.close();

        } catch (SQLException e) {

            msg =
                "Erro ao excluir baixa patrimonial: "
                + e.getMessage();
        }

        return msg;
    }
}