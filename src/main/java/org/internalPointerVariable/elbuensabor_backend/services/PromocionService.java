package org.internalPointerVariable.elbuensabor_backend.services;

import org.internalPointerVariable.elbuensabor_backend.dtos.PromocionDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.Promocion;
import org.internalPointerVariable.elbuensabor_backend.entities.PromocionDetalle;
import org.internalPointerVariable.elbuensabor_backend.repositories.PromocionRepository;
import org.internalPointerVariable.elbuensabor_backend.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class PromocionService extends BaseService<Promocion, PromocionDtos.ResponseDTO, PromocionDtos.RequestDTO> {

    private final PromocionRepository repository;
    public PromocionService(PromocionRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    protected void processEntityRelationshipsWrite(Promocion entity, PromocionDtos.RequestDTO requestDTO) {
        for (PromocionDetalle detalle : entity.getDetalles()) {
            detalle.setPromocion(entity);
        }
    }

    @Override
    protected void processEntityRelationshipsUpdate(Promocion existing, Promocion updated) {
        existing.getDetalles().clear();
        existing.getDetalles().addAll(updated.getDetalles());

        for (PromocionDetalle detalle : existing.getDetalles()) {
            detalle.setPromocion(existing);
        }
    }

    @Override
    protected String[] getIgnorePropertiesArray() {
        return new String[]{"id", "detalles"};
    }
}
