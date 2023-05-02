package com.deg.productservice.service;

import com.deg.productservice.model.InvoiceDetail;
import com.deg.productservice.repository.InvoiceDetailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class InvoiceDetailService {
    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    // Obtener todas las facturas-detalle
    public List<InvoiceDetail> findAll() { return invoiceDetailRepository.findAll(); }

    // Crear factura-detalle
    public InvoiceDetail create(InvoiceDetail invoiceDetail) {
        return invoiceDetailRepository.save(invoiceDetail);
    }
}
