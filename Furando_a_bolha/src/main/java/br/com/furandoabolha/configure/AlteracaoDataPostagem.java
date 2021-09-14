package br.com.furandoabolha.configure;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class AlteracaoDataPostagem {
	// Verfifcar na task9
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "criado", nullable = true)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "atualizado", nullable = true)
    private Date updated;

    @PrePersist
    protected void onCreate() {
    updated = created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
    updated = new Date();
    }
}