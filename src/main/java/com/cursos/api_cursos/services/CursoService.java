package com.cursos.api_cursos.services;

import java.util.ArrayList;
import java.util.List;

import com.cursos.api_cursos.entities.Curso;
import com.cursos.api_cursos.entities.Disciplina;
import com.cursos.api_cursos.entities.Fornecedor;
import com.cursos.api_cursos.models.CursoDto;
import com.cursos.api_cursos.repositories.CursoRepository;
import com.cursos.api_cursos.repositories.DisciplinaRepository;
import com.cursos.api_cursos.repositories.FornecedorRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoService implements ICursoService {
    private final CursoRepository cursoRepository;
    private final FornecedorRepository fornecedorRepository;
    private final DisciplinaRepository disciplinaRepository;

    @Override
    @Transactional
    public Curso criar(CursoDto dto) {
        Fornecedor fornecedor = new Fornecedor(dto.getFornecedor());    
        Disciplina disciplina = new Disciplina(dto.getDisciplina(), dto.getNivel());
        
        Curso curso = new Curso();
        curso.setNome(dto.getNome());
        curso.setPreco(dto.getPreco());
        curso.setFornecedor(fornecedor);
        curso.setDisciplina(disciplina);

        fornecedorRepository.save(fornecedor);
        disciplinaRepository.save(disciplina);
        return cursoRepository.save(curso);
    }

//     @Override
//     public DadosUsuarioDTO obterUsuarioPorId(Integer id) {
//         return usuarioRepository.findById(id).map(u -> {
//             return DadosUsuarioDTO
//                     .builder()
//                     .email(u.getEmail())
//                     .nome(u.getNome())
//                     .perfil(PerfilDTO.builder()
//                             .id(u.getPerfil().getId())
//                             .nome(u.getPerfil().getNome()).build())
//                     .build();
//         })
//                 .orElseThrow(() -> new RegraNegocioException("Usuário não encontrado"));
//     }

//     @Override
//     @Transactional
//     public void remover(Integer id) {
//         usuarioRepository.deleteById(id);
//     }

//     @Override
//     @Transactional
//     public void editar(Integer id, UsuarioDTO dto) {
//         Usuario usuario = usuarioRepository.findById(id)
//                 .orElseThrow(() -> new RegraNegocioException("Usuário não encontrado"));
//         Perfil perfil = perfilRepository.findById(dto.getPerfil())
//                 .orElseThrow(() -> new RegraNegocioException("Perfil não existe"));

//         usuario.setEmail(dto.getEmail());
//         usuario.setNome(dto.getNome());
//         usuario.setSenha(dto.getSenha());
//         usuario.setPerfil(perfil);

//         usuarioRepository.save(usuario);

//     }

//     @Override
//     public ArrayList<DadosUsuarioDTO> obterUsuarios() {
//         ArrayList<DadosUsuarioDTO> dados = new ArrayList<>();

//         List<Usuario> usuarios = usuarioRepository.findAll();
//         usuarios.forEach(u -> {
//             dados.add(
//                     DadosUsuarioDTO
//                             .builder()
//                             .email(u.getEmail())
//                             .nome(u.getNome())
//                             .perfil(PerfilDTO.builder()
//                                     .id(u.getPerfil().getId())
//                                     .nome(u.getPerfil().getNome()).build())
//                             .build());
//         });
//         return dados;
//     }
}
