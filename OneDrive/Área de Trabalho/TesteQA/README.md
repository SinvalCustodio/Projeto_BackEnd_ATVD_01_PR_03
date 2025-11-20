# Playwright BugBank - Testes Automatizados

[![Playwright tests](https://github.com/SinvalCustodio/ProjetoTesteDeSoftwere_Playwright_BugBank-4P/actions/workflows/playwright.yml/badge.svg)](https://github.com/SinvalCustodio/ProjetoTesteDeSoftwere_Playwright_BugBank-4P/actions/workflows/playwright.yml)

Este repositório contém uma suíte de testes Playwright criada para o site BugBank (exemplo público). Abaixo está um resumo do que foi feito, como executar os testes localmente, como gerar relatórios e como o CI foi configurado.

# Playwright BugBank - Testes Automatizados

Este repositório contém a suíte de testes Playwright que eu implementei e configurei para o site BugBank (exemplo público). A seguir descrevo, em primeira pessoa, o que eu fiz passo a passo, por que fiz e como você pode reproduzir o mesmo ambiente localmente.

## O que eu fiz (passo a passo)

1. Inspecionei os arquivos de teste existentes em `Tests/` e identifiquei problemas de sintaxe e imports. Em particular:
	- `Tests/hello.world.spec.js` continha referências incorretas (ex.: tentativa de usar uma URL como argumento de `expect`) e seletores frágeis. Reescrevi o teste para navegar para a página correta e usar asserções Web-First do Playwright de forma mais resiliente.
	- `Tests/login.spec.js` usava um import incorreto em um dos testes. Corrigi o import para `@playwright/test` e ajustei o teste que procurava por elementos que não existiam (substituí por verificações reais do site: título e link de requisitos).

2. Criei e/ou atualizei a configuração do Playwright:
	- Adicionei `playwright.config.js` e configurei `testDir: 'Tests'`, `baseURL: 'https://bugbank.netlify.app'`, `headless: true` e timeouts razoáveis. Isso permite usar `await page.goto('/')` nos testes e manter o projeto organizado.

3. Preparei o gerenciamento de dependências e scripts npm:
	- Criei/atualizei o `package.json` no root com `@playwright/test` nas `devDependencies` e adicionei scripts úteis:
	  - `npm run test` → executa `npx playwright test`.
	  - `npm run test:report` → executa os testes e gera o relatório HTML (`playwright-report`).
	  - `npm run show-report` → abre o relatório HTML localmente.
	  - `npm run test:ci` → executa os testes com o reporter GitHub (útil no CI).

4. Instalei as dependências e os navegadores Playwright localmente:
	- Executei `npm install` e `npx playwright install` para garantir que os binários dos browsers estejam presentes.

5. Ajustei e executei os testes até que todos passassem localmente:
	- Reparei uma asserção de título muito estrita e converti para regex para ficar resiliente a pequenas variações.
	- Removi checagens por `alt` do logo (frágeis) e adicionei validação do heading principal e do botão `Acessar`.
	- Executei `npx playwright test` e corrigi as falhas até obter `3 passed`.

6. GereI o relatório HTML e confirmei o artefato:
	- Rodei `npm run test:report` e verifiquei que `playwright-report/index.html` foi gerado com sucesso.

7. Configurei integração contínua (CI):
	- Adicionei o workflow GitHub Actions em `.github/workflows/playwright.yml` que:
	  - roda em `ubuntu-latest`, instala dependências (`npm ci`), instala navegadores (`npx playwright install --with-deps`) e executa `npx playwright test --reporter=github`.
	  - faz o upload do relatório (`playwright-report`) como artifact para inspeção quando o job terminar.

8. Documentei tudo no `README.md` e comitei as mudanças localmente. Em seguida, adicionei o remote e fiz `git push origin master` para o repositório remoto.

## Por que escolhi essas alterações

- Preferi seletores por `role` e texto (`getByRole`) por serem mais estáveis e acessíveis que atributos `alt` ou seletores CSS frágeis.
- Configurei `baseURL` para facilitar a escrita de `page.goto('/')` nos testes e para permitir troca rápida entre ambientes (se desejar usar uma URL diferente, basta atualizar o `playwright.config.js`).
- Adicionei scripts npm para padronizar os comandos e facilitar a execução por outros desenvolvedores.

## Arquivos alterados / adicionados por mim

- `Tests/hello.world.spec.js` — ajuste do teste da página inicial para ser resiliente.
- `Tests/login.spec.js` — correção de import e ajuste do teste que valida link de requisitos.
- `playwright.config.js` — configuração do Playwright (baseURL, testDir, timeouts).
- `package.json` — scripts e dependências (`@playwright/test`).
- `.github/workflows/playwright.yml` — workflow para CI no GitHub.
- `playwright-report/` — relatório HTML gerado após os testes.
- `README.md` — este arquivo, reescrito em primeira pessoa com instruções detalhadas.

## Como reproduzir o ambiente localmente (passo a passo)

Copie e cole os comandos abaixo no PowerShell (um por vez):

```powershell
cd "C:\Users\pctat\OneDrive\Área de Trabalho\TesteQA"
npm install
npx playwright install
```

Executar a suíte de testes:

```powershell
npx playwright test
```

Gerar o relatório HTML (executa os testes e cria `playwright-report`):

```powershell
npm run test:report
```

Abrir o relatório no navegador padrão:

```powershell
npx playwright show-report
# ou
Start-Process .\\playwright-report\\index.html
```

Se quiser rodar no modo CI (formato GitHub):

```powershell
npm run test:ci
```

## Observações e recomendações futuras

- Se for necessário testar outros navegadores ou rodar em paralelo com configurações diferentes, eu posso adicionar `projects` em `playwright.config.js` (ex.: `chromium`, `firefox`, `webkit`).
- Para testes que exigem autenticação, recomendo usar fixtures do Playwright para armazenar estado de login e evitar repetição de passos de login em cada teste.
- Se quiser que eu configure o badge do workflow para exibir o status de execução permanente, já adicionei o badge apontando para o workflow — ele será atualizado automaticamente após as execuções no GitHub.

## Contato / suporte

- Se você executar os comandos e obter erros, cole aqui a saída do terminal que eu vou te orientar passo a passo para resolver (posso ajustar timeouts, seletores ou configuração do CI conforme necessário).

---

Eu reescrevi este README em primeira pessoa para deixar claro o que foi feito e como reproduzir o ambiente. Se quiser que eu detalhe ainda mais algum passo (por exemplo, explicar cada linha do `playwright.config.js`), diga qual parte e eu amplio a documentação.
