/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sinMediator;

// Componentes
class SensorMovimiento {
    private LucesInteligentes luces;
    private CamaraSeguridad camara;
    private SistemaAlarma alarma;

    public SensorMovimiento(LucesInteligentes luces, CamaraSeguridad camara, SistemaAlarma alarma) {
        this.luces = luces;
        this.camara = camara;
        this.alarma = alarma;
    }

    public void detectarMovimiento() {
        System.out.println("Sensor: Movimiento detectado");
        luces.encender();
        camara.grabar();
        alarma.activar();
    }
}

class LucesInteligentes {
    public void encender() {
        System.out.println("Luces: Encendidas");
    }
}

class CamaraSeguridad {
    public void grabar() {
        System.out.println("Cámara: Grabando video");
    }
}

class Termostato {
    private AireAcondicionado aire;

    public Termostato(AireAcondicionado aire) {
        this.aire = aire;
    }

    public void detectarTemperaturaAlta() {
        System.out.println("Termostato: Temperatura alta detectada");
        aire.encender();
    }
}

class AireAcondicionado {
    public void encender() {
        System.out.println("Aire Acondicionado: Encendido");
    }
}

class SistemaAlarma {
    public void activar() {
        System.out.println("Alarma: Activada");
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        // Crear instancias de los dispositivos
        LucesInteligentes luces = new LucesInteligentes();
        CamaraSeguridad camara = new CamaraSeguridad();
        SistemaAlarma alarma = new SistemaAlarma();
        AireAcondicionado aire = new AireAcondicionado();

        // Configurar dependencias
        SensorMovimiento sensor = new SensorMovimiento(luces, camara, alarma);
        Termostato termostato = new Termostato(aire);

        // Simulación de eventos
        sensor.detectarMovimiento(); // Encenderá luces, grabará video y activará alarma
        termostato.detectarTemperaturaAlta(); // Encenderá el aire acondicionado
    }
}
