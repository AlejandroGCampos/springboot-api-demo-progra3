package com.ejemplo.demo.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.ejemplo.demo.api.contract.DemoEstadoApi;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DemoEstadoController implements DemoEstadoApi {

    // Variable de estado para simular el comportamiento Singleton
    private Integer valorSingleton = 0;

    @Override
    public ResponseEntity<Object> actualizarSingleton(Integer valor) {
        this.valorSingleton = valor;
        return ResponseEntity.ok(generarRespuesta("singleton", this.valorSingleton));
    }

    @Override
    public ResponseEntity<Object> obtenerSingleton() {
        return ResponseEntity.ok(generarRespuesta("singleton", this.valorSingleton));
    }

    @Override
    public ResponseEntity<Object> reiniciarSingleton() {
        this.valorSingleton = 0;
        return ResponseEntity.ok(generarRespuesta("singleton", this.valorSingleton));
    }

    @Override
    public ResponseEntity<Object> actualizarManual(Integer valor) {
        // En un bean manual no se conserva el estado global entre peticiones, 
        // simulamos la respuesta directa con el valor enviado.
        return ResponseEntity.ok(generarRespuesta("manual", valor));
    }

    @Override
    public ResponseEntity<Object> obtenerManual() {
        return ResponseEntity.ok(generarRespuesta("manual", 0));
    }

    // Método utilitario para estructurar el JSON de salida de forma limpia
    private Map<String, Object> generarRespuesta(String tipo, Integer valor) {
        Map<String, Object> res = new HashMap<>();
        res.put("tipo", tipo);
        res.put("valorActual", valor);
        return res;
    }
}