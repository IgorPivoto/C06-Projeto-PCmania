import Computador.Computador;

public class Cliente 
{    
    private String nome;
    private String cpf;

    private Computador[] computadores;
    private int quantidadeComprados = 0;

    public Cliente(String nome, String cpf) 
    {
        this.nome = nome;
        this.cpf = cpf;
        computadores = new Computador[5]; 
    }

    public void addComputador(Computador pc) 
    {
        if (quantidadeComprados < computadores.length) {
            computadores[quantidadeComprados] = pc;
            quantidadeComprados++;
        }
    }

    public float calculaTotalCompra() 
    {
        float total = 0;
        for (int i = 0; i < quantidadeComprados; i++) {
            total += computadores[i].getPreco();
        }
        return total;
    }

    public void mostraCompras() 
    {
        System.out.println("\nCliente: " + nome);
        System.out.println("CPF: " + cpf);

        for (int i = 0; i < quantidadeComprados; i++) {
            computadores[i].mostraPCConfig();
            System.out.println("-----------------------------");
        }

        System.out.println("Total: R$" + calculaTotalCompra());
    }

    public Computador[] getComputadores() 
    {
        return computadores;
    }

    public int getQuantidadeComprados() 
    {
        return quantidadeComprados;
    }
}
