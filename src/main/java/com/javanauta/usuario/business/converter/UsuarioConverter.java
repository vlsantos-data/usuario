package com.javanauta.usuario.business.converter;

import com.javanauta.usuario.business.dto.EnderecosDTO;
import com.javanauta.usuario.business.dto.TelefoneDTO;
import com.javanauta.usuario.business.dto.UsuarioDTO;
import com.javanauta.usuario.infrastructure.entity.Enderecos;
import com.javanauta.usuario.infrastructure.entity.Telefone;
import com.javanauta.usuario.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioConverter {

    public Usuario paraUsuario(UsuarioDTO usuarioDTO) {
        return Usuario.builder()

                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEnderecos(usuarioDTO.getEnderecos()))
                .telefones(paraListaTelefone(usuarioDTO.getTelefones()))
                .build();
    }

    public List<Enderecos> paraListaEnderecos(List<EnderecosDTO> enderecosDTO) {
        return enderecosDTO.stream().map(this::paraEnderecos).toList();
    }

    public Enderecos paraEnderecos(EnderecosDTO enderecosDTO) {
        return Enderecos.builder()
                .rua(enderecosDTO.getRua())
                .numero(enderecosDTO.getNumero())
                .estado(enderecosDTO.getEstado())
                .cep(enderecosDTO.getCep())
                .cidade(enderecosDTO.getCidade())
                .complemento(enderecosDTO.getComplemento())
                .build();
    }
    public List<Telefone> paraListaTelefone(List<TelefoneDTO> telefoneDTO) {
        List<Telefone> telefones = new ArrayList<>();
        for (TelefoneDTO telefonesDTO : telefoneDTO) {
            telefones.add(paraTelefone(telefonesDTO));
        }
        return telefones;
    }

    public Telefone paraTelefone(TelefoneDTO telefoneDTO) {
        return Telefone.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }

    public UsuarioDTO paraUsuarioDTO(Usuario usuarioDTO) {
        return UsuarioDTO.builder()

                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEnderecosDTO(usuarioDTO.getEnderecos()))
                .telefones(paraListaTelefoneDTO(usuarioDTO.getTelefones()))
                .build();
    }

    public List<EnderecosDTO> paraListaEnderecosDTO(List<Enderecos> enderecosDTO) {
      return enderecosDTO.stream().map(this::paraEnderecosDTO).toList();
    }

    public EnderecosDTO paraEnderecosDTO(Enderecos enderecosDTO) {
        return EnderecosDTO.builder()
                .rua(enderecosDTO.getRua())
                .cep(enderecosDTO.getCep())
                .cidade(enderecosDTO.getCidade())
                .complemento(enderecosDTO.getComplemento())
                .numero(enderecosDTO.getNumero())
                .build();
    }
    public List<TelefoneDTO> paraListaTelefoneDTO(List<Telefone> telefoneDTO) {
        return telefoneDTO.stream().map(this::paraTelefoneDTO).toList();

        }

    public TelefoneDTO paraTelefoneDTO(Telefone telefoneDTO) {
        return TelefoneDTO.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }
}
