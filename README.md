# 📘 Atividade Prática SOLID - Feira Livre

## 👥 Integrantes

- Tiago Albuquerque
- Lucas Azevedo

---

## 🎯 Objetivo

Refatorar um sistema com problemas de design aplicando os princípios **SOLID**, melhorando:

- Organização do código
- Separação de responsabilidades
- Redução de acoplamento
- Facilidade de manutenção e evolução

---

## 🔧 Principais melhorias realizadas

### ✅ 1. Aplicação do SRP (Single Responsibility Principle)

- Separação clara entre:
  - Regras de desconto (`desconto`)
  - Processamento de pagamento (`pagamento`)
  - Impressão de cupom (`cupom`)
  - Notificação (`notificacao`)
  - Relatórios (`relatorio`)
- Cada classe agora possui **uma única responsabilidade**

---

### ✅ 2. Aplicação do OCP (Open/Closed Principle)

- Sistema aberto para extensão:
  - Novas promoções podem ser adicionadas sem alterar código existente
  - Novos métodos de pagamento podem ser incluídos facilmente

Exemplo:

- `MotorDesconto` trabalha com lista de regras (`RegraPromo`)

---

### ✅ 3. Aplicação do LSP (Liskov Substitution Principle)

- Implementações de:
  - `ImpressoraCupom`
  - `GatewayPagamento`
  - `CalculadoraPrazoEntrega`
- Podem ser substituídas sem quebrar o sistema

---

### ✅ 4. Aplicação do ISP (Interface Segregation Principle)

- Interfaces específicas:
  - `ImpressoraCupom`
  - `ExportadorRelatorioPedido`
  - `Notificador`
- Evita classes dependerem de métodos que não utilizam

---

### ✅ 5. Aplicação do DIP (Dependency Inversion Principle)

- `CheckOutService` depende de abstrações:
  - `GatewayPagamento`
  - `ImpressoraCupom`
  - `Notificador`
- Facilita testes e extensibilidade

---

## 🧱 Estrutura do projeto

```
feira.solucao
├── cupom
├── desconto
├── domain
├── entrega
├── notificacao
├── pagamento
├── relatorio
├── repository
└── service
```

---

## ▶️ Como executar o projeto

### 1. Compilar

```bash
javac -d .. (Get-ChildItem -Recurse -Filter *.java | Select-Object -ExpandProperty FullName)
```

### 2. Executar

```bash
java feira.solucao.SolucaoMain
```

---

## 📊 Resultado esperado

- Processamento de pedido
- Aplicação de desconto
- Pagamento
- Impressão de cupom
- Notificação via WhatsApp
- Geração de relatório CSV
- Cálculo de prazo de entrega

---

## 🧠 Sobre os commits

Foram utilizados commits para demonstrar a evolução do projeto:

- `versao-original` → código inicial
- `refatoracao-solid` → aplicação dos princípios SOLID
- `merge do repositorio remoto` → integração com repositório remoto

---

## 🔗 Repositório

[https://github.com/TiagoAlbuquerque19/Atividade-Solid-Feira-Livre-Java](https://github.com/TiagoAlbuquerque19/Atividade-Solid-Feira-Livre-Java)
