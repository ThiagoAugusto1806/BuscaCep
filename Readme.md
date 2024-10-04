## 🗺️ Buscador de CEP (Sugestão) 🗺️

Este projeto é uma aplicação Java para buscar e gerenciar informações de CEP (Código de Endereçamento Postal), consumindo dados da API ViaCEP.

## 💻 Tecnologias Utilizadas:

- Java
- API ViaCEP

## 📂 Arquitetura do Projeto

### 📁 src/

Contém o código-fonte principal da aplicação.

- `Main.java` 🚀: Ponto de entrada da aplicação.
- `Http/` 🌐:  Lógica relacionada a requisições HTTP e integração com a API ViaCEP.
    - `ConsultaCep.java`:  Responsável por realizar consultas de CEP.
    - `ViaCep.java`: Uma classe Record para interagir especificamente com a API do ViaCEP.
    - `GeraArquivo.java`:  Uma classe para gerar arquivos com os dados de CEP obtidos.

### 📁 out/

Diretório de saída da compilação do código Java.

- `production/Busca de Cep`: Contém as classes compiladas da aplicação.

### 📁 .git/

Diretório que armazena o repositório Git do projeto.

- Diversos arquivos relacionados ao controle de versão, como histórico de commits, configurações, etc.

### 📄 Arquivos da raiz

- `.gitignore`: Define arquivos e pastas ignorados pelo Git.

## Como funciona

A aplicação consiste na busca de um CEP na API ViaCEP, na qual retorna um Json com os dados do CEP, a aplicação pega esses dados e em caso da não existencia de um dos dados necessarios retorna um pedido de complemento ao usuario, após todas as validações do endereço retornado é gerado um arquivo .json referente ao endereço pesquisado, contendo os dados do endereço retornado pela API e os complementos do usuario.