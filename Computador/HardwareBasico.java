package Computador;
public class HardwareBasico {
    
    private String nome;
    private float capacidade;

    public HardwareBasico(String nome, float capacidade)
    {
        this.nome = nome;
        this.capacidade = capacidade;
    }

    // nome
    public String getNome()
    {
        return nome;
    }

    // capacidade
    // public float getCapacidade() usei esse get por um tempo, mas depois criei o getCapacidadePlus para formatar a saída de acordo com o tipo de hardware. Por isso, comentei esse método.
    // {
    //     return capacidade;
    // }

    public String getCapacidadePlus() 
    {
        if (nome.toLowerCase().contains("hd")) 
        {
            if (capacidade >= 1 && capacidade <=2) 
            {
                return capacidade + " Tb";
            } else 
            {
                return capacidade + " Gb";
            }
        } 
        else if (nome.toLowerCase().contains("ram")) 
        {
            return capacidade + " Gb";
        } 
        else if (nome.toLowerCase().contains("pentium") || nome.toLowerCase().contains("core")) 
        {
            return capacidade + " MHz";
        }

        return capacidade + " (unidade desconhecida)";
    }

}
