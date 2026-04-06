# C06-Projeto-PCmania

Igor Silva Pivoto - GES - 767 

O uso de inteligência artificial foi realizado apenas ao final do projeto, com o objetivo de verificar sua conformidade. O prompt utilizado foi o seguinte: Com base no PDF fornecido, analise todo o projeto desenvolvido, incluindo todos os arquivos e a lógica implementada.
Verifique se o sistema atende completamente aos requisitos especificados no enunciado.

A análise deve incluir:

Validação da lógica do sistema
Correção da implementação em relação à UML e aos requisitos
Identificação de possíveis erros ou inconsistências
Sugestões de melhorias e otimizações (código, estrutura e boas práticas)

Ao final, informe claramente:

Se o projeto está correto e completo
Quais pontos podem ser melhorados
Se há algo faltando em relação ao que foi solicitado

o agente usado foi o Claude Haiku 4.5 pelo copilot, ele retornou esses dados:


## 📋 ANÁLISE COMPLETA DO PROJETO PCMania

Realizei uma análise abrangente do projeto comparando com os requisitos do enunciado PDF. Segue meu parecer detalhado:

---

### ✅ **REQUISITOS ATENDIDOS**

1. **Estrutura de Pacotes**: Organização correta em Computador e utils
2. **Classes Principais**: Cliente, Computador, HardwareBasico, MemoriaUSB, SistemaOperacional presentes
3. **Encapsulamento**: Todos os atributos como `private` conforme solicitado
4. **Getters/Setters**: Apenas criados quando necessário (sem excesso)
5. **Construtores**: Todas as classes possuem construtores parametrizados
6. **Sem ArrayList**: Uso correto de arrays primitivos
7. **Interface de Compra**: Loop funcional permitindo múltiplas compras (1/2/3 para comprar, 0 para finalizar)
8. **Exibição de Dados**: Cliente, PCs adquiridos e total são exibidos
9. **Método Utilitário**: `Pedido.processar()` é um método helper estático correto

---

### ❌ **ERROS CRÍTICOS E INCONSISTÊNCIAS**

#### **1. BUG FATAL no método `addMemoriaUSB()` - Computador.java**
```java
public void addMemoriaUSB(MemoriaUSB MemoriaUSB){
    this.memoriaUSB = memoriaUSB;  // ❌ ERRO: variável com "m" minúsculo não existe!
}
```
**Problema**: O parâmetro é `MemoriaUSB` (maiúsculo), mas a atribuição usa `memoriaUSB` (minúsculo). Isso causará `NullPointerException` em tempo de execução.

**Impacto**: Nenhuma MemoriaUSB é realmente adicionada ao computador.

---

#### **2. MemoriaUSB não é exibida - Computador.java**
O método `mostraPCConfig()` não mostra as informações da MemoriaUSB (pen-drive ou HD externo), embora a adição no Main seja feita. Faltam getters em MemoriaUSB.java.

---

#### **3. Classe nomeada incorretamente - Pedido.java**
O enunciado pede uma classe chamada `ProcessarPedido`, mas está nomeada `Pedido`. 

**Alinhamento**: Deveria ser `utils/ProcessarPedido.java`

---

#### **4. Falta de getters em MemoriaUSB - MemoriaUSB.java**
A classe não possui getters para `nome` e `capacidade`, impossibilitando exibir esses dados.

---

#### **5. Falta getter para quantidade de computadores comprados - Cliente.java**
O atributo `quantidadeComprados` é privado e não possui getter. O método `getComputadores()` retorna todo o array, não apenas os realmente comprados.

**Impacto**: Dificulta saber quantos itens foram adicionados ao carrinho e processá-los corretamente.

---

### ⚠️ **INCONSISTÊNCIAS E PONTOS A MELHORAR**

#### **1. Lógica de Menu confusa**
O Main possui um menu adicional (opções 1, 2, 3 para "ver dados" + opção 4 para "escolher compra"). O enunciado sugere uma interface mais direta. Embora funcione, a navegação poderia ser mais simples.

#### **2. Unitário do HD inconstante**
No Main:
- `pc2h3`: capacidade = `1` (deveria ser explicitamente diferente para indicar 1TB)
- `pc3h3`: capacidade = `2` (mesmo problema)

O método `getCapacidadePlus()` tenta compensar, mas a lógica de capacidade seria mais clara se usasse valores como `1000` para 1TB ou tivesse unidades explícitas.

#### **3. CPF como `long` em vez de `String`**
Cliente.java usa `long` para CPF. Enquanto funciona, CPFs como Strings seria melhor (evita overflow e permite validações).

#### **4. Falta validação em `addComputador()`**
Cliente.java não valida duplicatas ou avisa quando o limiteArrays de 5 é atingido elegantemente.

---

### 📊 **RESUMO FINAL**

| Aspecto | Status | Observação |
|---------|--------|-----------|
| **Estrutura OOP** | ✅ Correto | Pacotes, encapsulamento, construtores |
| **Requisitos Funcionais** | ⚠️ Parcial | Interface funciona, mas com bugs críticos |
| **Bug `addMemoriaUSB()`** | ❌ CRÍTICO | Deve ser consertado urgentemente |
| **Exibição MemoriaUSB** | ❌ Faltando | Não aparece na configuração do PC |
| **Nomenclatura Classe** | ⚠️ Diverge | `Pedido` vs `ProcessarPedido` |
| **Completude** | ⚠️ 70% | Funciona com limitações |

---

### 🔧 **AÇÕES RECOMENDADAS (PRIORIDADE)**

**🔴 CRÍTICO (concertar antes de entregar):**
1. Corrigir bug em `addMemoriaUSB()`: mudar `memoriaUSB` para `MemoriaUSB`
2. Renomear classe para `ProcessarPedido`
3. Adicionar getters em `MemoriaUSB` (`getNome()`, `getCapacidade()`)
4. Exibir MemoriaUSB em `mostraPCConfig()`
5. Adicionar getter `getQuantidadeComprados()` em Cliente

**🟡 IMPORTANTE (melhorias):**
1. Simplificar menu (remover opções 1, 2, 3 desnecessárias ou integrar melhor)
2. CPF como `String` ao invés de `long`
3. Adicionar validação em `addComputador()` (avisando quando limite é atingido)
4. Unitários claros para capacidades (usar `1000` para 1TB ou indicação explícita)

---

**Conclusão**: O projeto tem a **estrutura correta** e **atende 70% dos requisitos**, mas possui **bugs críticos** que prejudicam o funcionamento (especialmente `addMemoriaUSB()` e falta de exibição). Após correções, estará **completo e pronto para entrega**.

No caso, aqui eu apenas aproveitei os pontos criticos que ele apontou e corrigi, já que os bugs importantes apenas o de CPF era realmente algo dentro do scopo. O resultado foi bem satisfatorio, apontou erros que cometi por bobeira.