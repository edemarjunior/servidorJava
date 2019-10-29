package br.com.wesp32.repository;

import br.com.wesp32.entity.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionRepository {

	private final EntityManagerFactory entityManagerFactory;
	private final EntityManager entityManager;

	public ConnectionRepository() {

		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_aluno_db");
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	public void salvarPresenca(PresencaEntity presenca) {

		this.entityManager.getTransaction().begin();
		this.entityManager.persist(presenca);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
		this.entityManagerFactory.close();
		
	}

	public void salvarRaw(RawEntity raw) {

		this.entityManager.getTransaction().begin();
		this.entityManager.persist(raw);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
		this.entityManagerFactory.close();
	}

	@SuppressWarnings("unchecked")
	public List<AlunoEntity> getAlunos() {
		List<AlunoEntity> lista = this.entityManager.createQuery("SELECT a FROM AlunoEntity a ORDER BY a.nome_alu")
				.getResultList();
		this.entityManager.close();
		this.entityManagerFactory.close();
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<PresencaEntity> getPresencas(String sala_pre, java.util.Date dataini, java.util.Date datafim) {

		List<PresencaEntity> lista = this.entityManager
				.createQuery("SELECT a FROM PresencaEntity a "
						+ "where a.sala_pre =:sala_pre and a.data_pre between :de and :ate ORDER BY a.data_pre")
				.setParameter("sala_pre", sala_pre).setParameter("de", dataini).setParameter("ate", datafim)
				.getResultList();
		this.entityManager.close();
		this.entityManagerFactory.close();
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<RawEntity> getRaw(String sala_inf, String esp_inf, int tipo_inf) {

		List<RawEntity> lista = this.entityManager
				.createQuery("SELECT a FROM RawEntity a "
						+ "where a.sala_inf =:sala_inf and a.esp_inf =:esp_inf and a.tipo_inf =:tipo_inf ")
				.setParameter("sala_inf", sala_inf).setParameter("esp_inf", esp_inf).setParameter("tipo_inf", tipo_inf)
				.getResultList();
		this.entityManager.close();
		this.entityManagerFactory.close();
		return lista;

	}

	public AlunoEntity getPessoa(Integer codigo) {

		return this.entityManager.find(AlunoEntity.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<AlunoEntity> getLogin(String usuario_alu, String senha_alu) {
		List<AlunoEntity> aluno = this.entityManager
				.createQuery(
						"SELECT a FROM AlunoEntity a where a.usuario_alu =:usuario_alu and a.senha_alu =:senha_alu")
				.setParameter("usuario_alu", usuario_alu).setParameter("senha_alu", senha_alu).getResultList();
		this.entityManager.close();
		this.entityManagerFactory.close();
		return aluno;
	}

}
