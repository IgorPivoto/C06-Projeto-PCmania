import java.util.Scanner;

import Computador.Computador;
import Computador.HardwareBasico;
import Computador.MemoriaUSB;
import Computador.SistemaOperacional;
import utils.ProcessarPedido;

class Main{

    public static void main(String[] args) 
    {
        int matricula = 767;
        
        //pc1
        SistemaOperacional so1 = new SistemaOperacional("macOS Sequoia",64);
        HardwareBasico pc1h1 = new HardwareBasico("Pentium Core i3", 2200);
        HardwareBasico pc1h2 = new HardwareBasico("Memoria Ram", 8);
        HardwareBasico pc1h3 = new HardwareBasico("HD", 500);
        Computador pc1 = new Computador("Apple", matricula, 3, so1);
        MemoriaUSB mUsb1 = new MemoriaUSB("Pen-drive", 16);
        pc1.addHardware(pc1h1, 0);
        pc1.addHardware(pc1h2, 1);
        pc1.addHardware(pc1h3, 2);
        pc1.addMemoriaUSB(mUsb1);

        //pc2
        SistemaOperacional so2 = new SistemaOperacional("Windows 8",64);
        HardwareBasico pc2h1 = new HardwareBasico("Pentium Core i5", 3370);
        HardwareBasico pc2h2 = new HardwareBasico("Memoria Ram", 16);
        HardwareBasico pc2h3 = new HardwareBasico("HD", 1);
        Computador pc2 = new Computador("Samsung", matricula+1234, 3, so2);
        MemoriaUSB mUsb2 = new MemoriaUSB("Pen-drive", 32);
        pc2.addHardware(pc2h1, 0);
        pc2.addHardware(pc2h2, 1);
        pc2.addHardware(pc2h3, 2);
        pc2.addMemoriaUSB(mUsb2);

        //pc3
        SistemaOperacional so3 = new SistemaOperacional("Windows 10",64);
        HardwareBasico pc3h1 = new HardwareBasico("Pentium Core i7", 4500);
        HardwareBasico pc3h2 = new HardwareBasico("Memoria Ram", 32);
        HardwareBasico pc3h3 = new HardwareBasico("HD", 2);
        Computador pc3 = new Computador("Dell", matricula+5678, 3, so3);
        MemoriaUSB mUsb3 = new MemoriaUSB("HD Externo", 1);
        pc3.addHardware(pc3h1, 0);
        pc3.addHardware(pc3h2, 1);
        pc3.addHardware(pc3h3, 2);
        pc3.addMemoriaUSB(mUsb3);


        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf);

        while (true) 
        {
            System.out.println("\n==================Menu==================");
            System.out.println("Digite 1 para ver os dados da primeira promoção");
            System.out.println("Digite 2 para ver os dados da segunda promoção");
            System.out.println("Digite 3 para ver os dados da terceira promoção");
            System.out.println("Digite 4 para escolher as opções de compra");
            System.out.println("Digite 0 para sair");
            int opcao = 0;
            opcao = scanner.nextInt();
            switch (opcao) 
            {
                case 1:
                    System.out.println("PC 1:");
                    pc1.mostraPCConfig();
                    break;
                    
                case 2:
                    System.out.println("PC 2:");
                    pc2.mostraPCConfig();
                    break;

                case 3:
                    System.out.println("PC 3:");
                    pc3.mostraPCConfig();
                    break;

                case 4:

                    int compraOpcao;

                    do {
                        System.out.println("\n===== COMPRA =====");
                        System.out.println("1 - Comprar PC 1");
                        System.out.println("2 - Comprar PC 2");
                        System.out.println("3 - Comprar PC 3");
                        System.out.println("0 - Finalizar compra");

                        compraOpcao = scanner.nextInt();

                        switch (compraOpcao) {
                            case 1:
                                cliente.addComputador(pc1);
                                System.out.println("PC 1 adicionado ao carrinho.");
                                break;

                            case 2:
                                cliente.addComputador(pc2);
                                System.out.println("PC 2 adicionado ao carrinho.");
                                break;

                            case 3:
                                cliente.addComputador(pc3);
                                System.out.println("PC 3 adicionado ao carrinho.");
                                break;

                            case 0:
                                System.out.println("Finalizando compra...");
                                break;

                            default:
                                System.out.println("Opção inválida.");
                        }

                    } while (compraOpcao != 0);

                    cliente.mostraCompras();
                    ProcessarPedido.processar(cliente.getComputadores());

                    break;
                
                case 0:
                    scanner.close();
                    System.out.println("Encerrando sistema...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção não encontrada.");
                    break;
            }   
        }
    }
}