package br.com.alura.forum.repository;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alura.forum.modelo.Curso;

@RunWith(SpringRunner.class)
@DataJpaTest // indica que vai testar EJBS e carrega somente coisas referente repository
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // informa que e para o spring nao substituir o banco pelo bando de memoria
@ActiveProfiles("test") // indica que o profile ativo
public class CursoRepositoryTest {

	@Autowired
	private CursoRepository cursoRepository;
	

	@Autowired
	private EntityManager em; // como esta usando banco limpo, usa o entitymanager, pra inserir algum registro para testar

	@Test
	public void deveriaCarreagarUmCursoAoBuscarPeloNome() {
		Curso curso = new Curso();
		curso.setNome("HTML 5");
		curso.setCategoria("FRONT");
		//em.getTransaction().begin();
		em.persist(curso);
		//em.getTransaction().commit();
		String nomeCurso = "HTML 5";
		Curso cursoTeste = cursoRepository.findByNome(nomeCurso);
		Assert.assertNotNull(cursoTeste);
		Assert.assertEquals(nomeCurso, cursoTeste.getNome());
	}

	@Test
	public void naoDeveriaCarreagarUmCursoAoBuscarPeloNome() {
		String nomeCurso = "jpo 5";
		Curso curso = cursoRepository.findByNome(nomeCurso);
		Assert.assertNull(curso);
	}

}
