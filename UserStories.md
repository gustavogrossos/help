# Histórias de Usuários - Módulo de Transações

Este documento contém as histórias de usuário definidas para o Módulo de Transações. Ele detalha as funcionalidades essenciais e os critérios de aceitação para garantir que o desenvolvimento atenda às necessidades dos usuários.

---

## 1. Transferências para Contas Próprias

**História de Usuário:**

- **Como:** um usuário com múltiplas contas no banco,
- **Quero:** transferir dinheiro entre minhas próprias contas (por exemplo, da conta corrente para a poupança),
- **Para que:** eu possa gerenciar meus saldos e organizar melhor minhas finanças.

**Critérios de Aceitação:**

- O sistema deve exibir todas as contas do usuário disponíveis para transferência.
- O usuário deve poder selecionar a conta de origem e a conta de destino.
- É necessário informar o valor da transferência.
- O sistema deve exibir uma tela de confirmação antes de concluir a operação.
- Caso o saldo na conta de origem seja insuficiente, o sistema deve exibir uma mensagem de erro.
- Após a conclusão, o saldo de ambas as contas deve ser atualizado e exibido ao usuário.

---

## 2. Transferências para Terceiros

**História de Usuário:**

- **Como:** um usuário que precisa pagar contas ou enviar dinheiro para amigos e familiares,
- **Quero:** realizar transferências para contas de terceiros dentro do mesmo banco,
- **Para que:** eu possa efetuar pagamentos de maneira rápida e segura.

**Critérios de Aceitação:**

- O sistema deve permitir o cadastro dos dados do destinatário, como nome completo e CPF.
- O usuário pode selecionar um destinatário já cadastrado ou cadastrar um novo.
- É necessário informar o valor da transferência.
- Antes de concluir, o sistema deve apresentar uma tela de revisão dos dados e do valor a ser transferido.
- Após a confirmação, o sistema deve processar a transferência e exibir uma mensagem de sucesso.
- O usuário pode receber uma notificação (via SMS ou e-mail) confirmando a transação.

---

## 3. Transferências para Outros Bancos

**História de Usuário:**

- **Como:** um usuário que precisa enviar dinheiro para contas em outros bancos,
- **Quero:** realizar transferências interbancárias,
- **Para que:** eu possa enviar recursos a qualquer destinatário, mesmo que ele não possua conta na minha instituição.

**Critérios de Aceitação:**

- O sistema deve solicitar e permitir o preenchimento dos dados bancários do destinatário: nome completo, código do banco, agência e número da conta.
- Deve haver uma validação dos dados inseridos para garantir que estão corretos e completos.
- O usuário deve ter a opção de revisar os dados antes de confirmar a operação.
- Após a confirmação, a transferência deve ser processada e uma mensagem de sucesso exibida.
- Se ocorrer algum erro (como dados incorretos ou saldo insuficiente), o sistema deve informar o usuário e solicitar a correção.


Para enviar R$ 400 a um fornecedor que possui conta em outro banco, o usuário preenche os dados bancários (por exemplo, código do banco "341", agência e número da conta), revisa as informações e, ao confirmar, o sistema processa a transferência, exibindo uma mensagem de sucesso.

## 4. Acessar Histórico de Transações (US-4)

**Como**: cliente,  
**Quero**: acessar o histórico de ações da minha conta,  
**Para que**: eu possa consultar movimentações anteriores e monitorar minha conta.

**Critérios de Aceitação:**  
- O cliente deve ter permissão para acessar essas informações.  
- O sistema deve exibir o histórico do último mês.  
- O cliente acessa a seção de histórico e visualiza as transações realizadas.  
- O histórico deve ser exibido corretamente e sem erros.

---

## 5. Visualizar Extratos (US-5)

**Como**: cliente,  
**Quero**: visualizar extratos no sistema,  
**Para que**: eu possa acompanhar minhas transações detalhadamente.

**Critérios de Aceitação:**  
- O cliente deve estar logado para acessar os extratos.  
- O sistema deve permitir visualizar extratos do último mês.  
- O cliente clica no botão “Visualizar extrato” e vê os detalhes.  
- Os dados devem corresponder às transações realizadas e ao filtro que o cliente escolheu.

---

## 6. Checagem de Segurança para Transações (US-6)

**Como**: cliente,  
**Quero**: passar por uma checagem de segurança antes de realizar qualquer transação,  
**Para que**: minhas movimentações estejam protegidas contra acessos indevidos.

**Critérios de Aceitação:**  
- A checagem de segurança (senha ou autenticação de dois fatores) deve ser obrigatória antes de transações acima de um determinado valor.  
- O cliente tenta realizar uma transação e é solicitado a passar pela checagem.  
- O cliente deve receber um alerta se a checagem falhar.  
- A transação só será concluída após a checagem de segurança ser finalizada com sucesso.

---

*Este documento serve como base para o desenvolvimento do Módulo de Transações, garantindo que cada funcionalidade seja implementada de acordo com as necessidades dos usuários e os critérios de aceitação definidos. Atualize este README sempre que houver mudanças nas histórias ou nos requisitos do projeto.*
