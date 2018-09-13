package br.com.estudo.domain.estudante.converter;

import br.com.estudo.domain.estudante.vo.EstudanteVO;
import br.com.estudo.entity.Estudante;
import org.springframework.core.convert.converter.Converter;

public class EstudantoConverter implements Converter<EstudanteVO, Estudante> {

    @Override
    public Estudante convert(EstudanteVO vo) {
        Estudante estudante = new Estudante.EstudanteBuilder()
                .withCurso(vo.getCurso())
                .withDtNascimento(vo.getDtNascimento())
                .withNome(vo.getNome())
                .withPredio(vo.getPredio())
                .build();

        return estudante;
    }

}