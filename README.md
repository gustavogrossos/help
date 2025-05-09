# 💸 Módulo de Transações Bancárias – Sistema Financeiro Integrado

Este módulo faz parte de um sistema bancário completo, desenvolvido colaborativamente por várias turmas. Cada turma é responsável por um módulo específico do sistema, e ao final todos os módulos serão integrados em um projeto único.

Nosso grupo está responsável pelo **Módulo de Transações Bancárias**, abrangendo funcionalidades como transferências entre contas (próprias, terceiros e interbancárias), além do extrato e histórico de operações.

> 💡 **Atenção:** O **Módulo de Contas** já foi criado e está disponível para uso. Ele deve ser utilizado em conjunto com o módulo de transações, conforme orientação da professora.

---

## 📌 Funcionalidades

### 🔁 Transações Bancárias

- **Transferência entre contas próprias:** por exemplo, conta corrente para poupança;
- **Transferência para contas de terceiros:** dentro do mesmo banco, com cadastro e seleção de destinatários;
- **Transferência interbancária:** envio para outros bancos com validação de dados bancários;
- **Revisão dos dados antes da confirmação da transação;**
- **Validação de saldo disponível;**
- **Mensagens claras de sucesso ou erro.**

### 📄 Extrato e Histórico

- **Extrato de Transações:** últimas movimentações detalhadas (data, tipo e valor);
- **Histórico de Operações:** todas as transações feitas, organizadas e filtráveis.

---

## 🧰 Tecnologias Utilizadas

- **Linguagem:** Java
- **Interface Gráfica:** JavaFX
- **Banco de Dados:** MySQL
- **Versionamento:** Git + GitLab

---

## 🧪 Requisitos do Sistema

- Java JDK 17+
- IDE com suporte a JavaFX (IntelliJ IDEA, Eclipse, VSCode com plugin)
- Banco de Dados MySQL instalado e configurado
- Git instalado

---

## 🚀 Como Executar o Projeto

```bash
# Clone o repositório
git clone https://gitlab.com/seu-usuario/modulo-transacoes.git

# Entre na pasta do projeto
cd modulo-transacoes

# Configure a conexão MySQL no arquivo de configuração (application.properties ou .env)
```

---

## 🔐 Segurança

- Validação do saldo antes das transações;
- Validação dos dados bancários inseridos;
- Revisão prévia das transações;
- Mensagens claras em casos de erro.

---

## 📅 Metodologia de Trabalho

- ✅ **Metodologia Ágil (Scrum)**
- 📌 **Backlog e tarefas gerenciadas no GitLab**
- 🔁 **Sprints semanais de 5 dias**
- 🔍 **Sprint Reviews às sextas-feiras**
- 🧪 **Code Review realizado por Wallace de Freitas**
- 🧭 **Scrum Master:** Alícia Beatriz

---

## 📚 Documentação do Projeto

- 📄 **Documento Geral de Requisitos:** *[a ser adicionado]*
- 📊 **Registro de Daily e Sprint Reviews (Google Planilha):**  
  [📎 Clique aqui para acessar](https://docs.google.com/spreadsheets/d/1RJpakvcnppma-jRAoaoT9xbtS2JuE-Q6E4rcr_XZ4ug/edit#gid=828792226)
- 🧠 **Exemple Mapping de Histórias (Miro):**  
  [📌 Clique aqui para visualizar o board no Miro](https://miro.com/app/board/uXjVIBXkBm8=/)

---

## 👥 Equipe do Módulo

| Nome               | Função                               |
|--------------------|--------------------------------------|
| Alícia Beatriz     | Scrum Master, QA e Documentação      |
| Wallace de Freitas | Dev Fullstack, Líder Code Review     |
| Caio Sarmento      | Dev Frontend (JavaFX)                |
| Gustavo Neves      | Dev Backend (Java)                   |
| João Mendonça      | DBA (MySQL)                          |

---

## 📂 Estrutura do Projeto

```
src/
├── controller/   # Controladores das telas JavaFX
├── model/        # Modelos (classes de entidades)
├── view/         # Arquivos FXML (telas JavaFX)
├── repository/   # Conexões com o banco MySQL
├── service/      # Regras e lógica de negócios
└── util/         # Classes utilitárias e validações
```

---

## 🔄 Integração com outros módulos

Este módulo será integrado aos seguintes módulos desenvolvidos por outras turmas:

- ✅ **Módulo de Contas:** criação, visualização, atualização e exclusão de contas (já criado e disponibilizado pela professora);
- 📄 **Módulo de Empréstimos:** solicitação, cálculo de valores, planos de pagamento e agendamento de parcelas;
- 💳 **Módulo Cartão de Crédito:** solicitação de cartões, cálculo de limites, gerenciamento de compras e pagamentos;
- 📊 **Módulo de Pagamento de Serviços:** pagamentos externos como mensalidades universitárias e serviços telefônicos;

---

## 🧠 Como Contribuir

1. Crie uma branch específica para sua tarefa;
2. Faça commits com mensagens objetivas;
3. Submeta um Merge Request para `main` com solicitação de revisão.

---

## 💬 Contato

Dúvidas, sugestões ou comunicação com a equipe devem ser feitas via canal oficial no Microsoft Teams ou por meio de Issues abertas no GitLab.

---
