package com.ventas.ventas.service;

import com.ventas.ventas.model.Producto;
import com.ventas.ventas.model.Venta;
import com.ventas.ventas.repository.IProductoRepository;
import com.ventas.ventas.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService implements ICRUDService<Venta>{

    @Autowired
    private IVentaRepository ventaRepository;
    @Autowired
    private IProductoRepository productoRepository;
    @Override
    public List<Venta> finAll() {
        return ventaRepository.findAll();
    }

    @Override
    public Optional<Venta> findbyid(Integer id) {
        return ventaRepository.findById(id);
    }

    @Override
    public Venta create(Venta venta) {
        //recorrer la lista
        venta.getDetalleVentaList().forEach(detalleVenta -> {
            Optional<Producto> producto=productoRepository.findById(detalleVenta.getIdProducto().getIdProducto());
            if(producto.isPresent()){
                Double precioUnitario=producto.get().getPrecio();
                Double precioTotal=precioUnitario*detalleVenta.getCantidad().doubleValue();
                detalleVenta.setPrecioUnitario(precioUnitario);
                detalleVenta.setPrecioTotal(precioTotal);
                detalleVenta.setIdVenta(venta);
            }
        });
        return ventaRepository.save(venta);
    }

    @Override
    public Venta update(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public void delete(Integer id) {
    ventaRepository.deleteById(id);
    }
}
