package br.com.exemplo.dao;
 
import java.sql.SQLException;
import java.util.List;
 
import br.com.exemplo.pojo.Patrimonio;
 
 
public class DAOPatrimonio extends Conexao implements CRUD<Patrimonio>{
 
	@Override
	public String cadastrar(Patrimonio obj) {
		String msg = "Patrimonio cadastrado!";
		//Tentar abrir a conexão com o banco de dados
		try {
			if(abrir()) {
 
				String localInsert= "INSERT INTO patrimonio(numero_tombamento, nome, descricao, curso_id, local_id, categoria_id, status, valor_aquisicao, data_aquisicao, criado_por) VALUES (?,?,?,?,?,?,?,?,?,?)";
				//Abaixo, os parâmetros passados para cada ponto de interrogação
				//com seus respectivos valores
				pst.setString(1, obj.getNumero_tombamento());
				pst.setString(2, obj.getNome());
				pst.setString(3, obj.getDescricao());
				pst.setInt(4, obj.getCurso_id());
				pst.setInt(5, obj.getLocal_id());
				pst.setInt(6, obj.getCategoria_id());
				pst.setString(7, obj.getStatus().toString());
				pst.setDouble(8, obj.getValor_aquisicao());
				pst.setDate(9, obj.getData_aquisicao());
				pst.setInt(10, obj.getCriado_por());
				
				//Estamos executando a consulta e obtendo o retorno desta execução.
				//Se retornar 0(zero), então, não houve cadastro; caso contrário, cadastrou
				int i = pst.executeUpdate();
						
				if(i < 1) {
					msg = "Não foi possível cadastrar";
				}
				
			}
			else {
				msg = "Conexão Fechada";
			}
		}
		catch(SQLException se) {
			msg = "Erro ao tentar cadastrar o usuário. Mensagem: "+se.getMessage();
		}
		catch(Exception ex) {
			msg = "Erro inseperado. Mensagem: "+ex.getMessage();
		}
		finally {
			fechar();
		}
		
		return msg;
	}
 
	@Override
	public Boolean atualizar(Patrimonio obj) {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public String deletar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public List<Patrimonio> listar() {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public Patrimonio listarID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
 
}