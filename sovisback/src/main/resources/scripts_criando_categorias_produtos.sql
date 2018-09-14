/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guilherme Villaca <guilherme.villaca>
 * Created: 14/09/2018
 */

select * from produto;
select * from categoria;
select * from formapagamento;

--insert forma pagamento
INSERT INTO sovis.formapagamento (`FrmPgt_Descricao`) 
	VALUES ('Cartao');
INSERT INTO sovis.formapagamento (`FrmPgt_Descricao`) 
	VALUES ('Boleto');

--insert categorias
INSERT INTO sovis.categoria (`Ctg_Descricao`) 
	VALUES ('Camisas');
INSERT INTO sovis.categoria (`Ctg_Descricao`) 
	VALUES ('Calças');

--insert produtos
INSERT INTO sovis.produto (`Prd_Descricao`, `Prd_Titulo`, `Ctg_Codigo`, `Prd_Valor`) 
	VALUES ('camisa infantil polo', 'Camisa Polo', 1, 50.0);
INSERT INTO sovis.produto (`Prd_Descricao`, `Prd_Titulo`, `Ctg_Codigo`, `Prd_Valor`) 
	VALUES ('camisa infantil vermelha homem aranha', 'Camisa Homem aranha', 1, 80.0);
INSERT INTO sovis.produto (`Prd_Descricao`, `Prd_Titulo`, `Ctg_Codigo`, `Prd_Valor`) 
	VALUES ('camisa infantil azul batman', 'Camisa Batman', 1, 99.0);
INSERT INTO sovis.produto (`Prd_Descricao`, `Prd_Titulo`, `Ctg_Codigo`, `Prd_Valor`) 
	VALUES ('calça jeans masculina', 'Calça Jeans Original', 2, 159.0);
INSERT INTO sovis.produto (`Prd_Descricao`, `Prd_Titulo`, `Ctg_Codigo`, `Prd_Valor`) 
	VALUES ('calça infantil blue blue', 'Calça Blue Blue', 2, 39.0);
INSERT INTO sovis.produto (`Prd_Descricao`, `Prd_Titulo`, `Ctg_Codigo`, `Prd_Valor`) 
	VALUES ('calça infantil batman', 'Calça Batman', 2, 19.0);
INSERT INTO sovis.produto (`Prd_Descricao`, `Prd_Titulo`, `Ctg_Codigo`, `Prd_Valor`) 
	VALUES ('camisa infantil homem de ferro', 'Camisa Iron Man', 1, 49.0);
