# ✈️ Sistema de Reservas de Viagem

![badge-java](https://img.shields.io/badge/Java-17-orange?style=flat&logo=java)
![badge-status](https://img.shields.io/badge/status-Concluído-brightgreen)
![badge-license](https://img.shields.io/badge/license-MIT-blue)

Projeto Java orientado a objetos para **gerenciar reservas de viagens**, com carrinho de reservas, múltiplas formas de pagamento, validações robustas e arquitetura por camadas. 💼

---

## 📚 Funcionalidades

✔️ Cadastro de cliente e reservas  
✔️ Validação de entradas com tratamento de exceções personalizadas  
✔️ Cálculo de preço com diferentes meios de transporte  
✔️ Pagamento via Pix ou Cartão (com desconto ou taxa)  
✔️ Estrutura organizada em camadas: `Entities`, `Services`, `Utils`, `Validators`, `Exceptions`  
✔️ Interação via console com menu amigável

---

## 🧠 Tecnologias usadas

- ☕ **Java 17**
- 🧱 **Paradigma OOP (POO)** completo
- 📦 Estrutura modular por pacotes
- 🧪 Tratamento de exceções customizadas
- 📃 PlantUML (para documentação)

---

## 🧩 Estrutura do Projeto

```
src/
├── Entities/
│   ├── Cliente.java
│   ├── Reserva.java
│   └── CarrinhoDeReservas.java
├── ServicesMenu/
│   └── MenuService.java
├── ServicesMetodoPagamento/
│   └── MetodoPagamento + Implementações
├── ServicesMeioDeTransporte/
│   └── MeioDeTransporte + Implementações
├── Utils/
│   ├── Validator.java
│   └── ConsoleUtils.java
└── Exceptions/
    └── Todas as exceções personalizadas
```
---

## 🗂️ Diagrama de Classes UML

Representação da arquitetura de classes com relacionamentos, interfaces e pacotes:

<p align="center">
  <img src="docs/1diagrama-uml.png" alt="Diagrama de Classes UML" width="800"/>
</p>

<p align="center">
  <img src="docs/2diagrama-uml.png" alt="Diagrama de Classes UML" width="800"/>
</p>

---

## ⚙️ Como executar

```bash
1. Clone o repositório:
   git clone https://github.com/richarddherrera/java-travel-reservation

2. Abra no Eclipse ou IntelliJ

3. Rode a classe principal (MenuService ou Main)

4. Interaja pelo console 😄

========== MENU DE RESERVAS ==========
1 - Ver carrinho de reservas
2 - Adicionar nova reserva
3 - Remover reserva do carrinho
4 - Finalizar compra
0 - Sair          
````

## 👨‍💻 Autor 
Desenvolvido por Richard Herrera Gomes 💻
