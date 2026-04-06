package Computador;
public class Computador {
    
    private String marca;
    private float preco;
    private HardwareBasico[] hardware;
    private SistemaOperacional sistemaOperacional;
    private MemoriaUSB memoriaUSB;

    public Computador(String marca, float preco, int quantiadeHardware, SistemaOperacional so)
    {
        this.marca = marca;
        this.preco = preco;
        this.hardware = new HardwareBasico[quantiadeHardware];
        this.sistemaOperacional = so;
    }

    public float getPreco()
    {
        return preco;
    }

    public void addHardware(HardwareBasico hardware, int posicao) 
    {
        if (posicao >= 0 && posicao < this.hardware.length) {
            this.hardware[posicao] = hardware;
        } else {
            System.out.println("Posição inválida!");
        }
    }

    public void mostraPCConfig()
    {
        System.out.println("Marca: " + marca);
        System.out.println("Preço: R$" + preco );
        System.out.println("Sistema Operacional " + sistemaOperacional.getNome()  + " (" + sistemaOperacional.getTipo() + " bits)");
        for (int i = 0; i < this.hardware.length; i++) {
            if (this.hardware[i] != null) {
                System.out.println(this.hardware[i].getNome() + " (" + this.hardware[i].getCapacidadePlus() + ")");
            }
        }
        if (memoriaUSB != null) {
            System.out.println(memoriaUSB.getNome() + " (" + memoriaUSB.getCapacidade() + "Gb)");
        }
    }

    public void addMemoriaUSB(MemoriaUSB MemoriaUSB)
    {
        this.memoriaUSB = MemoriaUSB;
    }

    public MemoriaUSB getMemoriaUSB() 
    {
        return memoriaUSB;
    }

}
