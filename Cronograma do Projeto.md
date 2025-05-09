# Cronograma do Projeto - Sistema Bancário

| **Sprint** | **Data Início** | **Data Fim** | **Tarefas Principais** |
| --- | --- | --- | --- |
| Sprint 1: Setup e Design | 14/04/2025 | 18/04/2025 | Configuração do ambiente, design da interface, modelagem do banco de dados |
| Sprint 2: Transferência entre Contas Próprias | 21/04/2025 | 02/05/2025 | Implementação das funcionalidades de transferência entre contas do mesmo titular |
| Sprint 3: Transferência para Terceiros | 05/05/2025 | 09/05/2025 | Desenvolvimento do sistema de transferência para outras contas do banco |
| Sprint 4: Transferência Interbancária | 12/05/2025 | 16/05/2025 | Implementação de transferências entre bancos diferentes |
| Sprint 5: Extrato e Histórico | 19/05/2025 | 23/05/2025 | Desenvolvimento do sistema de extrato e histórico de transações |
| Sprint 6: Segurança e Logs | 26/05/2025 | 30/05/2025 | Implementação de sistemas de segurança e registro de operações |
| Sprint 7: Integração | 02/06/2025 | 06/06/2025 | Integração com outros módulos do sistema |
| Sprint 8: Apresentação Final | 09/06/2025 | 13/06/2025 | Preparação e realização da apresentação final |

Visualização do Cronograma:

```mermaid
gantt
    dateFormat  DD/MM/YYYY
    title Cronograma do Projeto - Sistema Bancário
    axisFormat %d/%m
    
    section Sprint 1
    Setup e Design           :active, s1, 2025-04-14, 2025-04-18
    Review S1               :milestone, 2025-04-18, 1d

    section Sprint 2
    Transferência Contas Próprias (Parte 1) :s2a, 2025-04-21, 2025-04-25
    Review Parcial S2      :milestone, 2025-04-25, 1d
    Transferência Contas Próprias (Parte 2) :s2b, 2025-04-28, 2025-05-02
    Review Final S2        :milestone, 2025-05-02, 1d

    section Sprint 3
    Transferência Terceiros :s3, 2025-05-05, 2025-05-09
    Review S3               :milestone, 2025-05-09, 1d

    section Sprint 4
    Transferência Interbancária :s4, 2025-05-12, 2025-05-16
    Review S4               :milestone, 2025-05-16, 1d

    section Sprint 5
    Extrato e Histórico     :s5, 2025-05-19, 2025-05-23
    Review S5               :milestone, 2025-05-23, 1d

    section Sprint 6
    Segurança e Logs        :s6, 2025-05-26, 2025-05-30
    Review S6               :milestone, 2025-05-30, 1d

    section Sprint 7
    Integração              :s7, 2025-06-02, 2025-06-06
    Review S7               :milestone, 2025-06-06, 1d

    section Sprint 8
    Apresentação Final      :s8, 2025-06-09, 2025-06-13
    Review Final            :milestone, 2025-06-13, 1d
```

<aside>
📅 Sprint Reviews acontecem todas as sextas-feiras 

</aside>

## Observações Importantes

- Cada Sprint tem duração de 5 dias úteis (segunda a sexta), exceto Sprint 2 que tem 10 dias úteis
- O projeto tem duração total de 9 semanas 
- Data de início das sprints: 14/04/2025
- Data de conclusão: 13/06/2025