package com.mtz.todolist.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class CompTarKey implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "tarefa_id")
    private Long tarafaId;

    public CompTarKey() {
    }

    public CompTarKey(Long id, Long usuarioId, Long tarafaId) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.tarafaId = tarafaId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Long getUsuarioId() {
        return this.usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getTarafaId() {
        return this.tarafaId;
    }

    public void setTarafaId(Long tarafaId) {
        this.tarafaId = tarafaId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CompTarKey)) {
            return false;
        }
        CompTarKey compTarKey = (CompTarKey) o;
        return Objects.equals(usuarioId, compTarKey.usuarioId) && Objects.equals(tarafaId, compTarKey.tarafaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, tarafaId);
    }

}