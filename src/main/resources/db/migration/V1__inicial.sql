-- Criação da tabela de Clientes
CREATE TABLE clientes (
    cpf VARCHAR(11) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    endereco TEXT NOT NULL,
    telefone VARCHAR(15),
    renda DECIMAL(10, 2) NOT NULL
);

-- Criação da tabela de Vendedores
CREATE TABLE vendedores (
    codigo SERIAL PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL
);

-- Criação da tabela de Veículos
CREATE TABLE veiculos (
    numero_chassi VARCHAR(17) PRIMARY KEY,
    placa VARCHAR(7) UNIQUE NOT NULL,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    ano_fabricacao INT NOT NULL,
    ano_modelo INT NOT NULL,
    cor VARCHAR(30),
    valor DECIMAL(10, 2) NOT NULL
);

-- Criação da tabela de Operações
CREATE TABLE operacoes (
    numero BIGSERIAL PRIMARY KEY,
    data DATE NOT NULL,
    cliente_cpf VARCHAR(11) NOT NULL,
    vendedor_codigo INT NOT NULL,
    veiculo_chassi VARCHAR(17) NOT NULL,
    valor_entrada DECIMAL(10, 2),
    valor_financiado DECIMAL(10, 2),
    valor_total DECIMAL(10, 2) NOT NULL,
    CONSTRAINT fk_cliente_operacao FOREIGN KEY (cliente_cpf) REFERENCES clientes (cpf),
    CONSTRAINT fk_vendedor_operacao FOREIGN KEY (vendedor_codigo) REFERENCES vendedores (codigo),
    CONSTRAINT fk_veiculo_operacao FOREIGN KEY (veiculo_chassi) REFERENCES veiculos (numero_chassi)
);

ALTER TABLE operacoes ADD COLUMN veiculo_numero_chassi VARCHAR(255);

-- Criação da tabela de Montadoras
CREATE TABLE montadoras (
    cnpj VARCHAR(14) PRIMARY KEY,
    razao_social VARCHAR(100) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    contato VARCHAR(100),
    telefone VARCHAR(15)
);

-- Criação da tabela de Pedidos
CREATE TABLE pedidos (
    numero BIGSERIAL PRIMARY KEY,
    data DATE NOT NULL,
    cliente_cpf VARCHAR(11) NOT NULL,
    vendedor_codigo INT NOT NULL,
    montadora_cnpj VARCHAR(14) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    ano INT NOT NULL,
    cor VARCHAR(30),
    acessorios TEXT,
    valor DECIMAL(10, 2) NOT NULL,
    CONSTRAINT fk_cliente_pedido FOREIGN KEY (cliente_cpf) REFERENCES clientes (cpf),
    CONSTRAINT fk_vendedor_pedido FOREIGN KEY (vendedor_codigo) REFERENCES vendedores (codigo),
    CONSTRAINT fk_montadora_pedido FOREIGN KEY (montadora_cnpj) REFERENCES montadoras (cnpj)
);

