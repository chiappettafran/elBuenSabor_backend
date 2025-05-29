package org.internalPointerVariable.elbuensabor_backend.services;

import org.internalPointerVariable.elbuensabor_backend.dtos.PedidoDtos;
import org.internalPointerVariable.elbuensabor_backend.entities.Pedido;
import org.internalPointerVariable.elbuensabor_backend.entities.PedidoDetalle;
import org.internalPointerVariable.elbuensabor_backend.repositories.PedidoRepository;
import org.internalPointerVariable.elbuensabor_backend.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class PedidoService extends BaseService<Pedido, PedidoDtos.ResponseDTO, PedidoDtos.RequestDTO> {

    private final PedidoRepository repository;
    public PedidoService(PedidoRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    protected void processEntityRelationshipsWrite(Pedido entity, PedidoDtos.RequestDTO requestDTO) {
        for (PedidoDetalle detalle : entity.getDetalles()) {
            detalle.setPedido(entity);
        }
    }
}
