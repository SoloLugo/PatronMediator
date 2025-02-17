/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mediator;

/**
 *
 * @author jorge
 */
import java.util.ArrayList;
import java.util.List;

// Mediador
class ControlCentral {
    private List<Dispositivo> dispositivos = new ArrayList<>();

    public void registrar(Dispositivo dispositivo) {
        dispositivos.add(dispositivo);
    }

    public void notificar(Dispositivo remitente, String evento) {
        if (remitente instanceof SensorMovimiento && evento.equals("movimiento_detectado")) {
            for (Dispositivo d : dispositivos) {
                if (d instanceof LucesInteligentes) {
                    ((LucesInteligentes) d).encender();
                }
                if (d instanceof CamaraSeguridad) {
                    ((CamaraSeguridad) d).grabar();
                }
                if (d instanceof SistemaAlarma) {
                    ((SistemaAlarma) d).activar();
                }
            }
        } else if (remitente instanceof Termostato && evento.equals("temperatura_alta")) {
            for (Dispositivo d : dispositivos) {
                if (d instanceof AireAcondicionado) {
                    ((AireAcondicionado) d).encender();
                }
            }
        }
    }
}

// Componentes Base
abstract class Dispositivo {
    protected ControlCentral mediador;

    public Dispositivo(ControlCentral mediador) {
        this.mediador = mediador;
    }
}

class SensorMovimiento extends Dispositivo {
    public SensorMovimiento(ControlCentral mediador) {
        super(mediador);
    }

    public void detectarMovimiento() {
        System.out.println("Sensor: Movimiento detectado");
        mediador.notificar(this, "movimiento_detectado");
    }
}

class LucesInteligentes extends Dispositivo {
    public LucesInteligentes(ControlCentral mediador) {
        super(mediador);
    }

    public void encender() {
        System.out.println("Luces: Encendidas");
    }
}

class CamaraSeguridad extends Dispositivo {
    public CamaraSeguridad(ControlCentral mediador) {
        super(mediador);
    }

    public void grabar() {
        System.out.println("Cámara: Grabando video");
    }
}

class Termostato extends Dispositivo {
    public Termostato(ControlCentral mediador) {
        super(mediador);
    }

    public void detectarTemperaturaAlta() {
        System.out.println("Termostato: Temperatura alta detectada");
        mediador.notificar(this, "temperatura_alta");
    }
}

class AireAcondicionado extends Dispositivo {
    public AireAcondicionado(ControlCentral mediador) {
        super(mediador);
    }

    public void encender() {
        System.out.println("Aire Acondicionado: Encendido");
    }
}

class SistemaAlarma extends Dispositivo {
    public SistemaAlarma(ControlCentral mediador) {
        super(mediador);
    }

    public void activar() {
        System.out.println("Alarma: Activada");
    }
}

// Uso
public class conMediator {
    public static void main(String[] args) {
        ControlCentral mediador = new ControlCentral();

        SensorMovimiento sensor = new SensorMovimiento(mediador);
        LucesInteligentes luces = new LucesInteligentes(mediador);
        CamaraSeguridad camara = new CamaraSeguridad(mediador);
        Termostato termostato = new Termostato(mediador);
        AireAcondicionado aire = new AireAcondicionado(mediador);
        SistemaAlarma alarma = new SistemaAlarma(mediador);

        // Registrar dispositivos en el mediador
        mediador.registrar(sensor);
        mediador.registrar(luces);
        mediador.registrar(camara);
        mediador.registrar(termostato);
        mediador.registrar(aire);
        mediador.registrar(alarma);

        // Simulación de eventos
        sensor.detectarMovimiento();  // Encenderá luces, grabará video y activará alarma
        termostato.detectarTemperaturaAlta();  // Encenderá el aire acondicionado
    }
}
